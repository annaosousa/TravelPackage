package com.example;

import java.util.logging.Logger;

import io.grpc.Channel;
import io.grpc.Grpc;
import io.grpc.ManagedChannel;
import io.grpc.InsecureChannelCredentials;
import io.grpc.StatusRuntimeException;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class TravelAgencyClient {
    private static final Logger logger = Logger.getLogger(TravelAgencyClient.class.getName());

    private final TravelAgencyGrpc.TravelAgencyBlockingStub travelAgencyStub;

    public TravelAgencyClient(Channel channel) {
        travelAgencyStub = TravelAgencyGrpc.newBlockingStub(channel);
    }

    public void trip () {

        Scanner scanner = new Scanner(System.in);
        
        // Solicitando dados ao usuário
        System.out.println("Informe o tipo de viagem (round-trip / one-way): ");
        String type = scanner.nextLine();

        System.out.println("Informe o ponto de origem: ");
        String origin = scanner.nextLine();

        System.out.println("Informe o ponto de destino: ");
        String destination = scanner.nextLine();

        System.out.println("Informe a data de partida (AAAA-MM-DD): ");
        String departureDate = scanner.nextLine();

        System.out.println("Informe a data de retorno (AAAA-MM-DD), ou deixe em branco para uma viagem de ida: ");
        String returnDate = scanner.nextLine();
        if (returnDate.isEmpty()) {
            returnDate = "";  // Caso seja uma viagem de ida
        }

        System.out.println("Informe o número de pessoas: ");
        int numPeople = Integer.parseInt(scanner.nextLine());

        logger.info("Registering your trip...");
        // TripRequest request = TripRequest.newBuilder()
        //     .setType("round-trip") // ou "one-way"
        //     .setOrigin("São Paulo")
        //     .setDestination("Rio de Janeiro")
        //     .setDepartureDate("2025-03-15")
        //     .setReturnDate("2025-03-20")
        //     .setNumPeople(2)
        //     .build();
        TripRequest request = TripRequest.newBuilder()
            .setType(type) // ou "one-way"
            .setOrigin(origin)
            .setDestination(destination)
            .setDepartureDate(departureDate)
            .setReturnDate(returnDate)
            .setNumPeople(numPeople)
            .build();

        TripResponse response;

        try {
            response = travelAgencyStub.bookTrip(request);
            logger.info("Trip registered successfully!");
            logger.info("Status: " + response.getStatus());
            logger.info("Flight Details: " + response.getFlightDetails());
            logger.info("Hotel Details: " + response.getHotelDetails());
            logger.info("Car Details: " + response.getCarDetails());

        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "Agency Failed: {0}", e.getStatus());
            return;
        }
    }
    
    public static void main(String[] args) throws Exception {
        // Access a service running on the local machine on port 50051
        String target = "localhost:50083";
        
        if (args.length > 1) {
          target = args[1];
        }
    
        ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create())
            .build();
        try {
          TravelAgencyClient client = new TravelAgencyClient(channel);
          client.trip();
        } finally {
          channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
    }
}
