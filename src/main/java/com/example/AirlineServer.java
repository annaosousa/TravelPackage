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

        @Override
        public void bookFlight(FlightRequest request, StreamObserver<FlightResponse> responseObserver) {
            flightNumber = "FL-100";

            FlightResponse response = FlightResponse.newBuilder()
                    .setStatus("Flight booked ")
                    .setFlightNumber(flightNumber)
                    .build();
                
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        @Override
        public void cancelFlight(CancelFlightRequest request, StreamObserver<CancelFlightResponse> responseObserver) {
            // Obtém o número do voo a ser cancelado
            String bookedFlight = request.getFlightNumber();
            StringBuilder statusMessage = new StringBuilder();
            
            // Verifica se o voo a ser cancelado é o mesmo reservado
            if (bookedFlight.equals(flightNumber)) {
                // Cancelar o voo (limpar a variável)
                flightNumber = null; // Ou qualquer outra lógica de cancelamento
                statusMessage.append("Flight ").append(bookedFlight).append(" canceled successfully. ");
            } else {
                // Se o voo não for encontrado
                statusMessage.append("Error: Flight ").append(bookedFlight).append(" not found. ");
            }
            
            // Criando a resposta
            CancelFlightResponse response = CancelFlightResponse.newBuilder()
                    .setStatus(statusMessage.toString())
                    .build();
            
            // Enviar a resposta para o cliente
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}
