package com.example;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import com.example.AirlineGrpc.AirlineImplBase;

import io.grpc.Grpc;
import io.grpc.InsecureServerCredentials;
import io.grpc.Server;
import io.grpc.stub.StreamObserver;

public class AirlineServer {
    private static final Logger logger = Logger.getLogger(AirlineServer.class.getName());
    
    private Server server;

    private void start() throws IOException {
        /* The port on which the server should run */
        int port = 50052;
        server = Grpc.newServerBuilderForPort(port, InsecureServerCredentials.create())
            .addService(new AirlineImpl())
            .build()
            .start();
        logger.info("Airline Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
        @Override
        public void run() {
            // Use stderr here since the logger may have been reset by its JVM shutdown hook.
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            try {
                AirlineServer.this.stop();
            } catch (InterruptedException e) {
            e.printStackTrace(System.err);
            }
            System.err.println("*** server shut down");
        }
        });
    }

    private void stop() throws InterruptedException {
        if (server != null) {
        server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
      final AirlineServer server = new AirlineServer();
      server.start();
      server.blockUntilShutdown();
  }

  static class AirlineImpl extends AirlineImplBase {

    @Override
    public void bookFlight(FlightRequest request, StreamObserver<FlightResponse> responseObserver) {
      String flightNumber = "FL-" + (int) (Math.random() * 1000);
      FlightResponse response = FlightResponse.newBuilder()
              .setStatus("Flight booked successfully")
              .setFlightNumber(flightNumber)
              .build();
              
      responseObserver.onNext(response);
      responseObserver.onCompleted();
    }
  }
}
