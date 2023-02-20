package com.reeinvent.backend.user.service;

import com.reeinvent.backend.GRPCRole;
import com.reeinvent.backend.GRPCUser;
import com.reeinvent.backend.user.entities.UserEntity;
import com.reeinvent.backend.user.mapper.UserMapper;
import com.reeinvent.backend.user.repository.RoleRepository;
import com.reeinvent.backend.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public GRPCUser getUser(GRPCUser request) {
        UserEntity user = userRepository.findByEmail(request.getEmail()).orElseThrow(() -> new RuntimeException("User not found: " + request.getEmail()));
        return UserMapper.toGRPCUser(user);
    }

    public GRPCUser createUser(GRPCUser request) {
        UserEntity user = new UserEntity();
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        List<String> roles = request.getRolesList()
                .stream()
                .map(GRPCRole::getName)
                .collect(Collectors.toList());
        user.setRoles(roleRepository.findByNameIn(roles));
        return UserMapper.toGRPCUser(userRepository.save(user));
    }
}
