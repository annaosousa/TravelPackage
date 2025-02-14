package com.example;

import java.util.logging.Logger;

import io.grpc.Channel;
import io.grpc.Grpc;
import io.grpc.ManagedChannel;
import io.grpc.InsecureChannelCredentials;
import io.grpc.StatusRuntimeException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class TravelAgencyClient {
    private static final Logger logger = Logger.getLogger(TravelAgencyClient.class.getName());

    private final TravelAgencyGrpc.TravelAgencyBlockingStub travelAgencyStub;

    public TravelAgencyClient(Channel channel) {
        travelAgencyStub = TravelAgencyGrpc.newBlockingStub(channel);
    }

    public void trip () {
        logger.info("Registering your trip...");
        TripRequest request = TripRequest.newBuilder()
        .build();
        TripResponse response;

        try {
            response = travelAgencyStub.bookTrip(request);
        } catch (StatusRuntimeException e) {
            logger.log(Level.WARNING, "Agency Failed: {0}", e.getStatus());
            return;
        }
    }
    
    public static void main(String[] args) throws Exception {
        String user = "world";
        // Access a service running on the local machine on port 50051
        String target = "localhost:50052";
        // Allow passing in the user and target strings as command line arguments
        if (args.length > 0) {
          if ("--help".equals(args[0])) {
            System.err.println("Usage: [name [target]]");
            System.err.println("");
            System.err.println("  name    The name you wish to be greeted by. Defaults to " + user);
            System.err.println("  target  The server to connect to. Defaults to " + target);
            System.exit(1);
          }
          user = args[0];
        }
        if (args.length > 1) {
          target = args[1];
        }
    
        // Create a communication channel to the server, known as a Channel. Channels are thread-safe
        // and reusable. It is common to create channels at the beginning of your application and reuse
        // them until the application shuts down.
        //
        // For the example we use plaintext insecure credentials to avoid needing TLS certificates. To
        // use TLS, use TlsChannelCredentials instead.
        ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create())
            .build();
        try {
          TravelAgencyClient client = new TravelAgencyClient(channel);
          client.trip();
        } finally {
          // ManagedChannels use resources like threads and TCP connections. To prevent leaking these
          // resources the channel should be shut down when it will no longer be used. If it may be used
          // again leave it running.
          channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
    }
}
