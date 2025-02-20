package com.example;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import com.example.HotelGrpc.HotelImplBase;
import com.example.DAO.HotelDAO;
import com.example.model.Hotel;

import io.grpc.Grpc;
import io.grpc.InsecureServerCredentials;
import io.grpc.Server;
import io.grpc.stub.StreamObserver;

public class HotelServer {
    private static final Logger logger = Logger.getLogger(HotelServer.class.getName());
    
    private Server server;

    private void start() throws IOException {
        /* The port on which the server should run */
        int port = 50082;
        server = Grpc.newServerBuilderForPort(port, InsecureServerCredentials.create())
            .addService(new HotelImpl())
            .build()
            .start();
        logger.info("Hotel Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
        @Override
        public void run() {
            // Use stderr here since the logger may have been reset by its JVM shutdown hook.
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            try {
                HotelServer.this.stop();
            } catch (InterruptedException e) {
            e.printStackTrace(System.err);
            }
            System.err.println("*** server shut down");
        }
        });
    }

    
    private void stop() throws InterruptedException {
        if (server != null) {
            server.shutdownNow();
            System.exit(0);
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

    /**
     * Main launches the server from the command line.
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        final HotelServer server = new HotelServer();
        server.start();

        // Captura SIGINT (Ctrl + C) e finaliza corretamente
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("*** Shutting down gRPC server due to JVM shutdown...");
            try {
                server.stop();
            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
            }
            System.err.println("*** Server shut down.");
        }));

        server.blockUntilShutdown();
    }

    static class HotelImpl extends HotelImplBase {
        private String hotelName;

        private HotelDAO hotelDAO = new HotelDAO();

        @Override
        public void bookHotel(HotelRequest req, StreamObserver<HotelResponse> responseObserver) {
            hotelName = "Anna and Pedro hotel";

            HotelResponse reply = HotelResponse.newBuilder()
            .setStatus("Status ")
            .setHotelName(hotelName)
            .build();

            Hotel hotel = new Hotel();
            hotel.setHotelName("Anna and Pedro hotel");
            hotel.setTripId(req.getTripId());

            hotelDAO.saveHotel(hotel);
          
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        }

        @Override
        public void cancelHotel(CancelHotelRequest request, StreamObserver<CancelHotelResponse> responseObserver) {
            CancelHotelResponse response = CancelHotelResponse.newBuilder().build();

            hotelDAO.deleteHotel(request.getTripId());

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}
