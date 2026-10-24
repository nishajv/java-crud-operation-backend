package com.poddar.CrudOperation.service;
import com.poddar.CrudOperation.mapper.UserRequest;
import com.poddar.CrudOperation.mapper.UserResponse;
import com.poddar.CrudOperation.repositary.UserRepositary;

import com.poddar.CrudOperation.mapper.LoginRequest;
import com.poddar.CrudOperation.model.UserRegs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Service
public class LoginService {


    LocalDateTime currentDateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String dateString = currentDateTime.format(formatter);

    @Autowired
    UserService userService;
    @Autowired
    UserRepositary userRepositary;

    public Boolean loginMethodService(LoginRequest loginRequest) {
        //loginRequest form data
        long id = loginRequest.getId();
        String pwd = loginRequest.getPassword();

        //Db store login data
        UserRegs user = userService.getUserById(id);
        if (user != null && user.isStatus()) {

            if (pwd.equals(user.getPassword())) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    //Delete Profile Service Method
    public boolean deleteMethodService(long id) {
        UserRegs userResponse = userService.getUserById(id);
        if (userResponse != null) {
            UserRegs userRegs = userResponse;
            if (userRegs.isStatus() == true) {
                userRegs.setStatus(false);
                userRegs.setDeleteDate(dateString);
                userRepositary.save(userRegs);
                return true;
            } else {
                return false;
            }

        } else {
            return false;
        }
    }
        // Update profile
        public UserResponse updateUserService(UserRequest userRequest, long id) {
            UserRegs idUser = userService.getUserById(id);
            UserResponse user = new UserResponse();
            if (idUser != null) {
                user.setEmail(userRequest.getEmail());
                user.setId(idUser.getId());
                user.setName(idUser .getName());
                user.setPassword(idUser .getPassword());
                user.setMobileNo(idUser .getMobileNo());
                //
                UserRegs user1 = new UserRegs();
                user1.setId(idUser.getId());
                user1.setName(idUser .getName());
                user1.setEmail(idUser .getEmail());
                user1.setMobileNo(idUser .getMobileNo());
                user1.setPassword(idUser .getPassword());
                user1.setCreateDate(idUser.getCreateDate());
                user1.setModifiedDate(dateString);
                user1.setDeleteDate(null);
                user1.setStatus(true);

                userRepositary.save(user1);
                //
            } else {
                return null;
            }


            return user;
        }
    }







