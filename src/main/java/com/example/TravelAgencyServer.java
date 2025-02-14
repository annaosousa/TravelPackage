package com.example;

import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.InsecureServerCredentials;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.util.logging.Logger;

public class TravelAgencyServer {
    private static final Logger logger = Logger.getLogger(TravelAgencyServer.class.getName());
    private Server server;

    private final AirlineGrpc.AirlineBlockingStub airlineStub;
    private final HotelGrpc.HotelBlockingStub hotelStub;
    private final CarRentalGrpc.CarRentalBlockingStub carRentalStub;

    public TravelAgencyServer() {
        ManagedChannel airlineChannel = ManagedChannelBuilder.forAddress("localhost", 50060)
                .usePlaintext()
                .build();
        ManagedChannel hotelChannel = ManagedChannelBuilder.forAddress("localhost", 50064)
                .usePlaintext()
                .build();
        ManagedChannel carRentalChannel = ManagedChannelBuilder.forAddress("localhost", 50061)
                .usePlaintext()
                .build();

        airlineStub = AirlineGrpc.newBlockingStub(airlineChannel);
        hotelStub = HotelGrpc.newBlockingStub(hotelChannel);
        carRentalStub = CarRentalGrpc.newBlockingStub(carRentalChannel);
    }

    private void start() throws IOException {
        int port = 50063;
        server = Grpc.newServerBuilderForPort(port, InsecureServerCredentials.create())
            .addService(new TravelAgencyImpl())
            .build()
            .start();
        logger.info("Travel Agency Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            TravelAgencyServer.this.stop();
            System.err.println("*** server shut down");
            if (server != null) {
                server.shutdown();
            }
        }));
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        final TravelAgencyServer server = new TravelAgencyServer();
        server.start();
        server.blockUntilShutdown();
    }

    class TravelAgencyImpl extends TravelAgencyGrpc.TravelAgencyImplBase {

        @Override
        public void bookTrip(TripRequest request, StreamObserver<TripResponse> responseObserver) {
            try {
                // Chama o serviço de voo
                FlightRequest flightRequest = FlightRequest.newBuilder()
                        .setOrigin(request.getOrigin())
                        .setDestination(request.getDestination())
                        .setDate(request.getDepartureDate())
                        .setNumPeople(request.getNumPeople())
                        .build();
                FlightResponse flightResponse = airlineStub.bookFlight(flightRequest);

                // Chama o serviço de hotel
                HotelRequest hotelRequest = HotelRequest.newBuilder()
                        .setDestination(request.getDestination())
                        .setCheckInDate(request.getDepartureDate())
                        .setCheckOutDate(request.getReturnDate())
                        .setNumPeople(request.getNumPeople())
                        .build();
                HotelResponse hotelResponse = hotelStub.bookHotel(hotelRequest);

                // Chama o serviço de locação de carro
                CarRequest carRequest = CarRequest.newBuilder()
                        .setDestination(request.getDestination())
                        .setPickUpDate(request.getDepartureDate())
                        .setDropOffDate(request.getReturnDate())
                        .build();
                CarResponse carResponse = carRentalStub.bookCar(carRequest);

                TripResponse response = TripResponse.newBuilder()
                        .setStatus("Booking Successful")
                        .setFlightDetails(flightResponse.getFlightNumber())
                        .setHotelDetails(hotelResponse.getHotelName())
                        .setCarDetails(carResponse.getCarModel())
                        .build();

                responseObserver.onNext(response);
                responseObserver.onCompleted();
            } catch (Exception e) {
                // Se falhar, inicia rollback
                logger.warning("Booking failed, rolling back...");
                responseObserver.onError(e);
            }
        }
    }
}