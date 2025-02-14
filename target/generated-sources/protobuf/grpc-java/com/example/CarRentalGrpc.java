package com.example;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.70.0)",
    comments = "Source: helloworld.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CarRentalGrpc {

  private CarRentalGrpc() {}

  public static final java.lang.String SERVICE_NAME = "helloworld.CarRental";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.CarRequest,
      com.example.CarResponse> getBookCarMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BookCar",
      requestType = com.example.CarRequest.class,
      responseType = com.example.CarResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.CarRequest,
      com.example.CarResponse> getBookCarMethod() {
    io.grpc.MethodDescriptor<com.example.CarRequest, com.example.CarResponse> getBookCarMethod;
    if ((getBookCarMethod = CarRentalGrpc.getBookCarMethod) == null) {
      synchronized (CarRentalGrpc.class) {
        if ((getBookCarMethod = CarRentalGrpc.getBookCarMethod) == null) {
          CarRentalGrpc.getBookCarMethod = getBookCarMethod =
              io.grpc.MethodDescriptor.<com.example.CarRequest, com.example.CarResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BookCar"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.CarRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.CarResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CarRentalMethodDescriptorSupplier("BookCar"))
              .build();
        }
      }
    }
    return getBookCarMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CarRentalStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CarRentalStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CarRentalStub>() {
        @java.lang.Override
        public CarRentalStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CarRentalStub(channel, callOptions);
        }
      };
    return CarRentalStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static CarRentalBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CarRentalBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CarRentalBlockingV2Stub>() {
        @java.lang.Override
        public CarRentalBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CarRentalBlockingV2Stub(channel, callOptions);
        }
      };
    return CarRentalBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CarRentalBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CarRentalBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CarRentalBlockingStub>() {
        @java.lang.Override
        public CarRentalBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CarRentalBlockingStub(channel, callOptions);
        }
      };
    return CarRentalBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CarRentalFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CarRentalFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CarRentalFutureStub>() {
        @java.lang.Override
        public CarRentalFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CarRentalFutureStub(channel, callOptions);
        }
      };
    return CarRentalFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void bookCar(com.example.CarRequest request,
        io.grpc.stub.StreamObserver<com.example.CarResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBookCarMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CarRental.
   */
  public static abstract class CarRentalImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return CarRentalGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CarRental.
   */
  public static final class CarRentalStub
      extends io.grpc.stub.AbstractAsyncStub<CarRentalStub> {
    private CarRentalStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CarRentalStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CarRentalStub(channel, callOptions);
    }

    /**
     */
    public void bookCar(com.example.CarRequest request,
        io.grpc.stub.StreamObserver<com.example.CarResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBookCarMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CarRental.
   */
  public static final class CarRentalBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<CarRentalBlockingV2Stub> {
    private CarRentalBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CarRentalBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CarRentalBlockingV2Stub(channel, callOptions);
    }

    /**
     */
    public com.example.CarResponse bookCar(com.example.CarRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBookCarMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service CarRental.
   */
  public static final class CarRentalBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CarRentalBlockingStub> {
    private CarRentalBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CarRentalBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CarRentalBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.CarResponse bookCar(com.example.CarRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBookCarMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CarRental.
   */
  public static final class CarRentalFutureStub
      extends io.grpc.stub.AbstractFutureStub<CarRentalFutureStub> {
    private CarRentalFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CarRentalFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CarRentalFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.CarResponse> bookCar(
        com.example.CarRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBookCarMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_BOOK_CAR = 0;

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
        case METHODID_BOOK_CAR:
          serviceImpl.bookCar((com.example.CarRequest) request,
              (io.grpc.stub.StreamObserver<com.example.CarResponse>) responseObserver);
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
          getBookCarMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.CarRequest,
              com.example.CarResponse>(
                service, METHODID_BOOK_CAR)))
        .build();
  }

  private static abstract class CarRentalBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CarRentalBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.HelloWorldProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CarRental");
    }
  }

  private static final class CarRentalFileDescriptorSupplier
      extends CarRentalBaseDescriptorSupplier {
    CarRentalFileDescriptorSupplier() {}
  }

  private static final class CarRentalMethodDescriptorSupplier
      extends CarRentalBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CarRentalMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (CarRentalGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CarRentalFileDescriptorSupplier())
              .addMethod(getBookCarMethod())
              .build();
        }
      }
    }
    return result;
  }
}
