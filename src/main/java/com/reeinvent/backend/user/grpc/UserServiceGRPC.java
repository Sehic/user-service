package com.reeinvent.backend.user.grpc;

import com.reeinvent.backend.GRPCUser;
import com.reeinvent.backend.UserServiceGrpc;
import com.reeinvent.backend.exceptions.GRPCException;
import com.reeinvent.backend.user.service.UserService;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceGRPC extends UserServiceGrpc.UserServiceImplBase {

    @Autowired
    private UserService userService;

    @Override
    public void getUser(GRPCUser request, StreamObserver<GRPCUser> responseObserver) {
        try {
            responseObserver.onNext(userService.getUser(request));
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(new GRPCException(Status.fromThrowable(e), e.getMessage(), e));
        }
    }

    @Override
    public void createUser(GRPCUser request, StreamObserver<GRPCUser> responseObserver) {
        try {
            responseObserver.onNext(userService.createUser(request));
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(new GRPCException(Status.fromThrowable(e), e.getMessage(), e));
        }
    }
}
