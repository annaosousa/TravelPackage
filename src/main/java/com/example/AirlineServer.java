package com.example;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.Random;

import com.example.AirlineGrpc.AirlineImplBase;
import com.example.DAO.AirlineDAO;
import com.example.model.Airline;

import io.grpc.Grpc;
import io.grpc.InsecureServerCredentials;
import io.grpc.Server;
import io.grpc.stub.StreamObserver;

public class AirlineServer {
    private static final Logger logger = Logger.getLogger(AirlineServer.class.getName());
    
    private Server server;

    private void start() throws IOException {
        /* The port on which the server should run */
        int port = 50380;
        server = Grpc.newServerBuilderForPort(port, InsecureServerCredentials.create())
            .addService(new AirlineImpl())
            .build()
            .start();
        logger.info("Airline Server started, listening on " + port);
        
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            // Use stderr here since the logger may have been reset by its JVM shutdown hook.
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            try {
                AirlineServer.this.stop();
            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
            }
            System.err.println("*** server shut down");
        }));
    }

    private void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown(); // Primeiro, faz o shutdown normal
            try {
                if (!server.awaitTermination(5, java.util.concurrent.TimeUnit.SECONDS)) {
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

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination(5,TimeUnit.HOURS);
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        final AirlineServer server = new AirlineServer();
        server.start();
        server.blockUntilShutdown();

        
    }

    static class AirlineImpl extends AirlineImplBase {
        String flightNumber;
        String flightNumberString = "FL-100";

        private AirlineDAO airlineDAO = new AirlineDAO();

        @Override
        public void bookFlight(FlightRequest request, StreamObserver<FlightResponse> responseObserver) {
            flightNumber = "FL-100";

            FlightResponse response = FlightResponse.newBuilder()
                    .setStatus("Flight booked ")
                    .setFlightNumber(flightNumber)
                    .build();
                
            Airline airline = new Airline();
                airline.setFlightNumber(flightNumberString);
                airline.setTripId(request.getTripId());

                airlineDAO.saveAirline(airline);

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        @Override
        public void cancelFlight(CancelFlightRequest request, StreamObserver<CancelFlightResponse> responseObserver) {
            
            CancelFlightResponse response = CancelFlightResponse.newBuilder()
                    .setStatus("cancel")
                    .build();
            
            airlineDAO.deleteAirline(request.getTripId());
            
            // Enviar a resposta para o cliente
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}
