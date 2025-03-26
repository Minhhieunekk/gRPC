package com.example.mainservice.service;

import com.example.gRPC.GreetingRequest;
import com.example.gRPC.GreetingResponse;
import com.example.gRPC.GreetingServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;


@GrpcService
public class GreetingSerivceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {
    @Override
    public void greeting(GreetingRequest request, StreamObserver<GreetingResponse> responseObserver) {
        String message = "Hello " + request.getMessage();
        System.out.println("Greeting: " + message);

        GreetingResponse response = GreetingResponse.newBuilder().setMessage("Received your " + message + ". Hello From Server. ").build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
