package com.example;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import com.example.CarRentalGrpc.CarRentalImplBase;
import com.example.DAO.CarDAO;
import com.example.model.Car;

import io.grpc.Grpc;
import io.grpc.InsecureServerCredentials;
import io.grpc.Server;
import io.grpc.stub.StreamObserver;

public class CarRentalServer {
    private static final Logger logger = Logger.getLogger(CarRentalServer.class.getName());
    
    private Server server;

    private void start() throws IOException {
        /* The port on which the server should run */
        int port = 50081;
        server = Grpc.newServerBuilderForPort(port, InsecureServerCredentials.create())
            .addService(new CarRentalImpl())
            .build()
            .start();
        logger.info("Car rental Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
        @Override
        public void run() {
            // Use stderr here since the logger may have been reset by its JVM shutdown hook.
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            try {
                CarRentalServer.this.stop();
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
        }

        System.exit(0);
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
        final CarRentalServer server = new CarRentalServer();
        server.start();
        server.blockUntilShutdown();
    }

    static class CarRentalImpl extends CarRentalImplBase {
        String carModel;

        private CarDAO carDAO = new CarDAO();

        @Override
        public void bookCar(CarRequest request, StreamObserver<CarResponse> responseObs) {
            carModel = "Sedan 2024";

            CarResponse response = CarResponse.newBuilder()
                    .setStatus("Car rental confirmed")
                    .setCarModel(carModel)
                    .build();

            Car car = new Car();
            car.setCarModel("Sedan 2024");
            car.setTripId(request.getTripId());

            carDAO.saveCar(car); 
                    
            responseObs.onNext(response);
            responseObs.onCompleted();
        }

        @Override
        public void cancelCar(CancelCarRequest request, StreamObserver<CancelCarResponse> responseObserver) {

            CancelCarResponse response = CancelCarResponse.newBuilder()
                .setStatus("cancel")
                .build();

            carDAO.deleteCar(request.getTripId());
            
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
    
}
