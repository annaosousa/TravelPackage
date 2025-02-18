package com.example;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.70.0)",
    comments = "Source: helloworld.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TravelAgencyGrpc {

  private TravelAgencyGrpc() {}

  public static final java.lang.String SERVICE_NAME = "helloworld.TravelAgency";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.TripRequest,
      com.example.TripResponse> getBookTripMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BookTrip",
      requestType = com.example.TripRequest.class,
      responseType = com.example.TripResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.TripRequest,
      com.example.TripResponse> getBookTripMethod() {
    io.grpc.MethodDescriptor<com.example.TripRequest, com.example.TripResponse> getBookTripMethod;
    if ((getBookTripMethod = TravelAgencyGrpc.getBookTripMethod) == null) {
      synchronized (TravelAgencyGrpc.class) {
        if ((getBookTripMethod = TravelAgencyGrpc.getBookTripMethod) == null) {
          TravelAgencyGrpc.getBookTripMethod = getBookTripMethod =
              io.grpc.MethodDescriptor.<com.example.TripRequest, com.example.TripResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BookTrip"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.TripRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.TripResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TravelAgencyMethodDescriptorSupplier("BookTrip"))
              .build();
        }
      }
    }
    return getBookTripMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TravelAgencyStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TravelAgencyStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TravelAgencyStub>() {
        @java.lang.Override
        public TravelAgencyStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TravelAgencyStub(channel, callOptions);
        }
      };
    return TravelAgencyStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static TravelAgencyBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TravelAgencyBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TravelAgencyBlockingV2Stub>() {
        @java.lang.Override
        public TravelAgencyBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TravelAgencyBlockingV2Stub(channel, callOptions);
        }
      };
    return TravelAgencyBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TravelAgencyBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TravelAgencyBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TravelAgencyBlockingStub>() {
        @java.lang.Override
        public TravelAgencyBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TravelAgencyBlockingStub(channel, callOptions);
        }
      };
    return TravelAgencyBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TravelAgencyFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TravelAgencyFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TravelAgencyFutureStub>() {
        @java.lang.Override
        public TravelAgencyFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TravelAgencyFutureStub(channel, callOptions);
        }
      };
    return TravelAgencyFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void bookTrip(com.example.TripRequest request,
        io.grpc.stub.StreamObserver<com.example.TripResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBookTripMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service TravelAgency.
   */
  public static abstract class TravelAgencyImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return TravelAgencyGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service TravelAgency.
   */
  public static final class TravelAgencyStub
      extends io.grpc.stub.AbstractAsyncStub<TravelAgencyStub> {
    private TravelAgencyStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TravelAgencyStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TravelAgencyStub(channel, callOptions);
    }

    /**
     */
    public void bookTrip(com.example.TripRequest request,
        io.grpc.stub.StreamObserver<com.example.TripResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBookTripMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service TravelAgency.
   */
  public static final class TravelAgencyBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<TravelAgencyBlockingV2Stub> {
    private TravelAgencyBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TravelAgencyBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TravelAgencyBlockingV2Stub(channel, callOptions);
    }

    /**
     */
    public com.example.TripResponse bookTrip(com.example.TripRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBookTripMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service TravelAgency.
   */
  public static final class TravelAgencyBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<TravelAgencyBlockingStub> {
    private TravelAgencyBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TravelAgencyBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TravelAgencyBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.TripResponse bookTrip(com.example.TripRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBookTripMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service TravelAgency.
   */
  public static final class TravelAgencyFutureStub
      extends io.grpc.stub.AbstractFutureStub<TravelAgencyFutureStub> {
    private TravelAgencyFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TravelAgencyFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TravelAgencyFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.TripResponse> bookTrip(
        com.example.TripRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBookTripMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_BOOK_TRIP = 0;

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
        case METHODID_BOOK_TRIP:
          serviceImpl.bookTrip((com.example.TripRequest) request,
              (io.grpc.stub.StreamObserver<com.example.TripResponse>) responseObserver);
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
          getBookTripMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.TripRequest,
              com.example.TripResponse>(
                service, METHODID_BOOK_TRIP)))
        .build();
  }

  private static abstract class TravelAgencyBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TravelAgencyBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.HelloWorldProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TravelAgency");
    }
  }

  private static final class TravelAgencyFileDescriptorSupplier
      extends TravelAgencyBaseDescriptorSupplier {
    TravelAgencyFileDescriptorSupplier() {}
  }

  private static final class TravelAgencyMethodDescriptorSupplier
      extends TravelAgencyBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    TravelAgencyMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (TravelAgencyGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TravelAgencyFileDescriptorSupplier())
              .addMethod(getBookTripMethod())
              .build();
        }
      }
    }
    return result;
  }
}
