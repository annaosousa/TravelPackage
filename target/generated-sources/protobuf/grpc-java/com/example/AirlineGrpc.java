package com.example;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.70.0)",
    comments = "Source: helloworld.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class AirlineGrpc {

  private AirlineGrpc() {}

  public static final java.lang.String SERVICE_NAME = "helloworld.Airline";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.FlightRequest,
      com.example.FlightResponse> getBookFlightMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BookFlight",
      requestType = com.example.FlightRequest.class,
      responseType = com.example.FlightResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.FlightRequest,
      com.example.FlightResponse> getBookFlightMethod() {
    io.grpc.MethodDescriptor<com.example.FlightRequest, com.example.FlightResponse> getBookFlightMethod;
    if ((getBookFlightMethod = AirlineGrpc.getBookFlightMethod) == null) {
      synchronized (AirlineGrpc.class) {
        if ((getBookFlightMethod = AirlineGrpc.getBookFlightMethod) == null) {
          AirlineGrpc.getBookFlightMethod = getBookFlightMethod =
              io.grpc.MethodDescriptor.<com.example.FlightRequest, com.example.FlightResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BookFlight"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.FlightRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.FlightResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AirlineMethodDescriptorSupplier("BookFlight"))
              .build();
        }
      }
    }
    return getBookFlightMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AirlineStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AirlineStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AirlineStub>() {
        @java.lang.Override
        public AirlineStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AirlineStub(channel, callOptions);
        }
      };
    return AirlineStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static AirlineBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AirlineBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AirlineBlockingV2Stub>() {
        @java.lang.Override
        public AirlineBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AirlineBlockingV2Stub(channel, callOptions);
        }
      };
    return AirlineBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AirlineBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AirlineBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AirlineBlockingStub>() {
        @java.lang.Override
        public AirlineBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AirlineBlockingStub(channel, callOptions);
        }
      };
    return AirlineBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AirlineFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AirlineFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AirlineFutureStub>() {
        @java.lang.Override
        public AirlineFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AirlineFutureStub(channel, callOptions);
        }
      };
    return AirlineFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void bookFlight(com.example.FlightRequest request,
        io.grpc.stub.StreamObserver<com.example.FlightResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBookFlightMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Airline.
   */
  public static abstract class AirlineImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return AirlineGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Airline.
   */
  public static final class AirlineStub
      extends io.grpc.stub.AbstractAsyncStub<AirlineStub> {
    private AirlineStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AirlineStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AirlineStub(channel, callOptions);
    }

    /**
     */
    public void bookFlight(com.example.FlightRequest request,
        io.grpc.stub.StreamObserver<com.example.FlightResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBookFlightMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Airline.
   */
  public static final class AirlineBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<AirlineBlockingV2Stub> {
    private AirlineBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AirlineBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AirlineBlockingV2Stub(channel, callOptions);
    }

    /**
     */
    public com.example.FlightResponse bookFlight(com.example.FlightRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBookFlightMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service Airline.
   */
  public static final class AirlineBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AirlineBlockingStub> {
    private AirlineBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AirlineBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AirlineBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.FlightResponse bookFlight(com.example.FlightRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBookFlightMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Airline.
   */
  public static final class AirlineFutureStub
      extends io.grpc.stub.AbstractFutureStub<AirlineFutureStub> {
    private AirlineFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AirlineFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AirlineFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.FlightResponse> bookFlight(
        com.example.FlightRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBookFlightMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_BOOK_FLIGHT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_BOOK_FLIGHT:
          serviceImpl.bookFlight((com.example.FlightRequest) request,
              (io.grpc.stub.StreamObserver<com.example.FlightResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getBookFlightMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.FlightRequest,
              com.example.FlightResponse>(
                service, METHODID_BOOK_FLIGHT)))
        .build();
  }

  private static abstract class AirlineBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AirlineBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.HelloWorldProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Airline");
    }
  }

  private static final class AirlineFileDescriptorSupplier
      extends AirlineBaseDescriptorSupplier {
    AirlineFileDescriptorSupplier() {}
  }

  private static final class AirlineMethodDescriptorSupplier
      extends AirlineBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AirlineMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (AirlineGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AirlineFileDescriptorSupplier())
              .addMethod(getBookFlightMethod())
              .build();
        }
      }
    }
    return result;
  }
}
