package com.reeinvent.backend.user.mapper;

import com.reeinvent.backend.GRPCRole;
import com.reeinvent.backend.GRPCUser;
import com.reeinvent.backend.user.entities.RoleEntity;
import com.reeinvent.backend.user.entities.UserEntity;

import java.util.stream.Collectors;

public class UserMapper {

    public static GRPCUser toGRPCUser(UserEntity user) {
        return GRPCUser.newBuilder().setId(user.getId().toString())
                .setEmail(user.getEmail())
                .setPassword(user.getPassword())
                .addAllRoles(
                        user.getRoles().stream().map(UserMapper::toGRPCRole).collect(Collectors.toList())
                )
                .build();
    }

    public static GRPCRole toGRPCRole(RoleEntity role) {
        return GRPCRole.newBuilder().setId(role.getId().toString())
                .setName(role.getName().name())
                .setDescription(role.getDescription())
                .build();
    }
}
