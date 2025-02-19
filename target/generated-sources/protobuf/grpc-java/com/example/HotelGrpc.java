package com.example;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.70.0)",
    comments = "Source: helloworld.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class HotelGrpc {

  private HotelGrpc() {}

  public static final java.lang.String SERVICE_NAME = "helloworld.Hotel";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.HotelRequest,
      com.example.HotelResponse> getBookHotelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BookHotel",
      requestType = com.example.HotelRequest.class,
      responseType = com.example.HotelResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.HotelRequest,
      com.example.HotelResponse> getBookHotelMethod() {
    io.grpc.MethodDescriptor<com.example.HotelRequest, com.example.HotelResponse> getBookHotelMethod;
    if ((getBookHotelMethod = HotelGrpc.getBookHotelMethod) == null) {
      synchronized (HotelGrpc.class) {
        if ((getBookHotelMethod = HotelGrpc.getBookHotelMethod) == null) {
          HotelGrpc.getBookHotelMethod = getBookHotelMethod =
              io.grpc.MethodDescriptor.<com.example.HotelRequest, com.example.HotelResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BookHotel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.HotelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.HotelResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HotelMethodDescriptorSupplier("BookHotel"))
              .build();
        }
      }
    }
    return getBookHotelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.example.CancelHotelRequest,
      com.example.CancelHotelResponse> getCancelHotelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CancelHotel",
      requestType = com.example.CancelHotelRequest.class,
      responseType = com.example.CancelHotelResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.example.CancelHotelRequest,
      com.example.CancelHotelResponse> getCancelHotelMethod() {
    io.grpc.MethodDescriptor<com.example.CancelHotelRequest, com.example.CancelHotelResponse> getCancelHotelMethod;
    if ((getCancelHotelMethod = HotelGrpc.getCancelHotelMethod) == null) {
      synchronized (HotelGrpc.class) {
        if ((getCancelHotelMethod = HotelGrpc.getCancelHotelMethod) == null) {
          HotelGrpc.getCancelHotelMethod = getCancelHotelMethod =
              io.grpc.MethodDescriptor.<com.example.CancelHotelRequest, com.example.CancelHotelResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CancelHotel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.CancelHotelRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.CancelHotelResponse.getDefaultInstance()))
              .setSchemaDescriptor(new HotelMethodDescriptorSupplier("CancelHotel"))
              .build();
        }
      }
    }
    return getCancelHotelMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HotelStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HotelStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HotelStub>() {
        @java.lang.Override
        public HotelStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HotelStub(channel, callOptions);
        }
      };
    return HotelStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static HotelBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HotelBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HotelBlockingV2Stub>() {
        @java.lang.Override
        public HotelBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HotelBlockingV2Stub(channel, callOptions);
        }
      };
    return HotelBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HotelBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HotelBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HotelBlockingStub>() {
        @java.lang.Override
        public HotelBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HotelBlockingStub(channel, callOptions);
        }
      };
    return HotelBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HotelFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<HotelFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<HotelFutureStub>() {
        @java.lang.Override
        public HotelFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new HotelFutureStub(channel, callOptions);
        }
      };
    return HotelFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void bookHotel(com.example.HotelRequest request,
        io.grpc.stub.StreamObserver<com.example.HotelResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getBookHotelMethod(), responseObserver);
    }

    /**
     */
    default void cancelHotel(com.example.CancelHotelRequest request,
        io.grpc.stub.StreamObserver<com.example.CancelHotelResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCancelHotelMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Hotel.
   */
  public static abstract class HotelImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return HotelGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Hotel.
   */
  public static final class HotelStub
      extends io.grpc.stub.AbstractAsyncStub<HotelStub> {
    private HotelStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HotelStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HotelStub(channel, callOptions);
    }

    /**
     */
    public void bookHotel(com.example.HotelRequest request,
        io.grpc.stub.StreamObserver<com.example.HotelResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getBookHotelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void cancelHotel(com.example.CancelHotelRequest request,
        io.grpc.stub.StreamObserver<com.example.CancelHotelResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCancelHotelMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Hotel.
   */
  public static final class HotelBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<HotelBlockingV2Stub> {
    private HotelBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HotelBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HotelBlockingV2Stub(channel, callOptions);
    }

    /**
     */
    public com.example.HotelResponse bookHotel(com.example.HotelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBookHotelMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.CancelHotelResponse cancelHotel(com.example.CancelHotelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCancelHotelMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service Hotel.
   */
  public static final class HotelBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<HotelBlockingStub> {
    private HotelBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HotelBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HotelBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.example.HotelResponse bookHotel(com.example.HotelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getBookHotelMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.example.CancelHotelResponse cancelHotel(com.example.CancelHotelRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCancelHotelMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Hotel.
   */
  public static final class HotelFutureStub
      extends io.grpc.stub.AbstractFutureStub<HotelFutureStub> {
    private HotelFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HotelFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new HotelFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.HotelResponse> bookHotel(
        com.example.HotelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getBookHotelMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.CancelHotelResponse> cancelHotel(
        com.example.CancelHotelRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCancelHotelMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_BOOK_HOTEL = 0;
  private static final int METHODID_CANCEL_HOTEL = 1;

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
        case METHODID_BOOK_HOTEL:
          serviceImpl.bookHotel((com.example.HotelRequest) request,
              (io.grpc.stub.StreamObserver<com.example.HotelResponse>) responseObserver);
          break;
        case METHODID_CANCEL_HOTEL:
          serviceImpl.cancelHotel((com.example.CancelHotelRequest) request,
              (io.grpc.stub.StreamObserver<com.example.CancelHotelResponse>) responseObserver);
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
          getBookHotelMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.HotelRequest,
              com.example.HotelResponse>(
                service, METHODID_BOOK_HOTEL)))
        .addMethod(
          getCancelHotelMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.example.CancelHotelRequest,
              com.example.CancelHotelResponse>(
                service, METHODID_CANCEL_HOTEL)))
        .build();
  }

  private static abstract class HotelBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HotelBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.HelloWorldProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Hotel");
    }
  }

  private static final class HotelFileDescriptorSupplier
      extends HotelBaseDescriptorSupplier {
    HotelFileDescriptorSupplier() {}
  }

  private static final class HotelMethodDescriptorSupplier
      extends HotelBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    HotelMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (HotelGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HotelFileDescriptorSupplier())
              .addMethod(getBookHotelMethod())
              .addMethod(getCancelHotelMethod())
              .build();
        }
      }
    }
    return result;
  }
}
