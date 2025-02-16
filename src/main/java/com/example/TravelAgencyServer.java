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

import com.example.DAO.AirlineDAO;
import com.example.DAO.CarDAO;
import com.example.DAO.HotelDAO;
import com.example.DAO.TripDAO;
import com.example.model.Airline;
import com.example.model.Car;
import com.example.model.Hotel;
import com.example.model.Trip;
import com.google.api.SystemParameter;

public class TravelAgencyServer {
    private static final Logger logger = Logger.getLogger(TravelAgencyServer.class.getName());
    private Server server;

    private final AirlineGrpc.AirlineBlockingStub airlineStub;
    private final HotelGrpc.HotelBlockingStub hotelStub;
    private final CarRentalGrpc.CarRentalBlockingStub carRentalStub;

    public TravelAgencyServer() {
        ManagedChannel airlineChannel = ManagedChannelBuilder.forAddress("localhost", 50380)
                .usePlaintext()
                .build();
        ManagedChannel carRentalChannel = ManagedChannelBuilder.forAddress("localhost", 50081)
                .usePlaintext()
                .build();
        ManagedChannel hotelChannel = ManagedChannelBuilder.forAddress("localhost", 50082)
                .usePlaintext()
                .build();
        

        airlineStub = AirlineGrpc.newBlockingStub(airlineChannel);
        hotelStub = HotelGrpc.newBlockingStub(hotelChannel);
        carRentalStub = CarRentalGrpc.newBlockingStub(carRentalChannel);
    }

    private void start() throws IOException {
        int port = 50083;
        server = Grpc.newServerBuilderForPort(port, InsecureServerCredentials.create())
            .addService(new TravelAgencyImpl())
            .build()
            .start();
        logger.info("Travel Agency Server started, listening on " + port);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Aqui");
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            try {
                TravelAgencyServer.this.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.err.println("*** server shut down");
        }));

    }

    private void stop() {
        if (server != null) {
            server.shutdown(); // Primeiro, faz o shutdown normal
            try {
                if (!server.awaitTermination(60, java.util.concurrent.TimeUnit.SECONDS)) {
                    System.err.println("Forçando shutdown...");
                    server.shutdownNow(); // Força o shutdown se não encerrar em 5s
                    if ( !server.awaitTermination ( 60 , java.util.concurrent.TimeUnit.SECONDS ) ){
                        System.err.println ( "Executor service did not terminate. ");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                server.shutdownNow();
                Thread.currentThread ( ).interrupt ( );
            }
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
        private TripDAO tripDAO = new TripDAO();
        private AirlineDAO airlineDAO = new AirlineDAO();
        private CarDAO carDAO = new CarDAO();
        private HotelDAO hotelDAO = new HotelDAO();

        Trip trip = new Trip();

        @Override
        public void bookTrip(TripRequest request, StreamObserver<TripResponse> responseObserver) {
            
            trip.setType(request.getType());
            trip.setOrigin(request.getOrigin());
            trip.setDestination(request.getDestination());
            trip.setDepartureDate(request.getDepartureDate());
            trip.setReturnDate(request.getReturnDate());
            trip.setNumPeople(request.getNumPeople());

            System.out.println(trip.getNumPeople());
            System.out.println(trip.getReturnDate());

            trip.setStatus("pending");

            tripDAO.saveTrip(trip);
            
            String flightNumber = null;
            String hotelReservationId = null;
            String carReservationId = null;
    
            // Estado de sucesso/falha de cada etapa
            boolean flightSuccess = false;
            boolean hotelSuccess = false;
            boolean carSuccess = false;
    
            try {
                // Etapa 1: Compra da passagem aérea
                FlightRequest flightRequest = FlightRequest.newBuilder()
                        .setOrigin(request.getOrigin())
                        .setDestination(request.getDestination())
                        .setDate(request.getDepartureDate())
                        .setNumPeople(request.getNumPeople())
                        .build();
                FlightResponse flightResponse = airlineStub.bookFlight(flightRequest);
                flightNumber = flightResponse.getFlightNumber();

                Airline airline = new Airline();
                airline.setFlightNumber("FL-100");
                airline.setTripId(trip.getId());

                airlineDAO.saveAirline(airline);

                logger.info("Passagem aérea reservada: " + flightNumber);
                flightSuccess = true;
    
                // Etapa 2: Reserva do hotel
                if (flightSuccess) {
                    HotelRequest hotelRequest = HotelRequest.newBuilder()
                            .setDestination(request.getDestination())
                            .setCheckInDate(request.getDepartureDate())
                            .setCheckOutDate(request.getReturnDate())
                            .setNumPeople(request.getNumPeople())
                            .build();
                    HotelResponse hotelResponse = hotelStub.bookHotel(hotelRequest);
                    hotelReservationId = hotelResponse.getHotelName();

                    Hotel hotel = new Hotel();
                    hotel.setHotelName("Anna and Pedro hotel");
                    hotel.setTripId(trip.getId());

                    hotelDAO.saveHotel(hotel);

                    logger.info("Hotel reservado: " + hotelReservationId);
                    hotelSuccess = true;
                }
    
                // Etapa 3: Reserva do carro
                if (hotelSuccess) {
                    CarRequest carRequest = CarRequest.newBuilder()
                            .setDestination(request.getDestination())
                            .setPickUpDate(request.getDepartureDate())
                            .setDropOffDate(request.getReturnDate())
                            .build();
                    CarResponse carResponse = carRentalStub.bookCar(carRequest);
                    carReservationId = carResponse.getCarModel();

                    Car car = new Car();
                    car.setCarModel("Sedan 2024");
                    car.setTripId(trip.getId());

                    carDAO.saveCar(car);                    

                    logger.info("Carro reservado: " + carReservationId);
                    carSuccess = true;
                }
    
                // Se todas as etapas forem bem-sucedidas, responde com sucesso
                if (flightSuccess && hotelSuccess && carSuccess) {
                    trip.setStatus("success");

                    TripResponse response = TripResponse.newBuilder()
                            .setStatus("Booking Successful")
                            .setFlightDetails(flightResponse.getFlightNumber())
                            .setHotelDetails(hotelReservationId)
                            .setCarDetails(carReservationId)
                            .build();
                    responseObserver.onNext(response);
                    responseObserver.onCompleted();

                    tripDAO.updateTripStatus(trip.getId(),"success");
                }
    
            } catch (Exception e) {
                // Se falhar, inicia rollback
                logger.warning("Booking failed, rolling back...");
                rollback(flightSuccess, hotelSuccess, carSuccess, flightNumber, hotelReservationId, carReservationId);
                responseObserver.onError(e);
            }
        }
    
        private void rollback(boolean flightSuccess, boolean hotelSuccess, boolean carSuccess,
                              String flightNumber, String hotelReservationId, String carReservationId) {
            try {
                // Compensação baseada nas falhas
                if (carSuccess) {
                    logger.warning("Cancelando carro: " + carReservationId);
                    carRentalStub.cancelCar(CancelCarRequest.newBuilder().setCarModel(carReservationId).build());
                    carDAO.deleteCar(trip.getId());
                    tripDAO.updateTripStatus(trip.getId(), "cancel");
                }
    
                if (hotelSuccess) {
                    logger.warning("Cancelando hotel: " + hotelReservationId);
                    hotelStub.cancelHotel(CancelHotelRequest.newBuilder().setHotelName(hotelReservationId).build());
                    hotelDAO.deleteHotel(trip.getId());
                    tripDAO.updateTripStatus(trip.getId(), "cancel");
                }
    
                if (flightSuccess) {
                    logger.warning("Cancelando voo: " + flightNumber);
                    airlineStub.cancelFlight(CancelFlightRequest.newBuilder().setFlightNumber(flightNumber).build());
                    airlineDAO.deleteAirline(trip.getId());
                    tripDAO.updateTripStatus(trip.getId(), "cancel");
                }
    
                logger.warning("Rollback concluído.");
            } catch (Exception e) {
                logger.warning("Erro ao realizar rollback: " + e.getMessage());
            }
        }
    }
    
}