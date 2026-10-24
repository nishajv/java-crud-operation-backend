package com.poddar.CrudOperation.service;

import com.poddar.CrudOperation.mapper.UserRequest;
import com.poddar.CrudOperation.mapper.UserResponse;
import com.poddar.CrudOperation.model.UserRegs;
import com.poddar.CrudOperation.repositary.UserRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    LocalDateTime currentDateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String dateString = currentDateTime.format(formatter);

    @Autowired
    UserRepositary userRepository;

    public UserResponse postUserService(UserRequest userRequest) {
        UserResponse user = new UserResponse();
        user.setEmail(userRequest.getEmail());
        user.setId(System.currentTimeMillis());
        user.setName(userRequest.getName());
        user.setPassword(userRequest.getPassword());
        user.setMobileNo(userRequest.getMobileNo());
        //
        UserRegs user1 = new UserRegs();
        user1.setId(System.currentTimeMillis());
        user1.setName(userRequest.getName());
        user1.setEmail(userRequest.getEmail());
        user1.setMobileNo(userRequest.getMobileNo());
        user1.setPassword(userRequest.getPassword());
        user1.setCreateDate(dateString);
        user1.setModifiedDate(dateString);
        user1.setDeleteDate(null);
        user1.setStatus(true);

        userRepository.save(user1);

        //

        return user;
    }

    public List<UserRegs> getAllUser() {
        List<UserRegs> getAllUsers = userRepository.findAll();
        return getAllUsers;
    }

    public UserRegs getUserById(long id) {
        Optional<UserRegs> getUserById = userRepository.findById(id);
        if (getUserById.isPresent()) {
            UserRegs userRegs = getUserById.get();
            if (userRegs.isStatus() == true) {
                return userRegs;


            } else {
                return null;
            }

        } else {
            return null;
        }
    }
}
