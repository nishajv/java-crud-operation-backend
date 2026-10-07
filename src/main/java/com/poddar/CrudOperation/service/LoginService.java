package com.poddar.CrudOperation.service;
import com.poddar.CrudOperation.repositary.UserRepositary;
import com.poddar.CrudOperation.repository.UserRepository;
import com.poddar.CrudOperation.mapper.LoginRequest;
import com.poddar.CrudOperation.model.UserRegs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    public Boolean LoginMethodService(LoginRequest loginRequest) {

        //loginRequest form data
        long id = loginRequest.getId();
        String pwd = loginRequest.getPassword();

        //Db store login data
        Optional<UserRegs> userResponse = userService.getUserById(id);
        if (userResponse.isPresent()) {
            UserRegs userRegs = userResponse.get();
            System.out.println(id + " " + pwd);
            if (userRegs.isStatus() == false) {
                return false;
            } else {
                if (id == userResponse.get().getId() && pwd.equals(userResponse.get().getPassword())) {
                    return true;
                } else {
                    return false;
                }

            } else{
                return false;

                //Delete Profile Service Method
                public boolean DeleteMethodService ( long id){
                    // Optional<UserRegs> userResponse = userService.getUserById(id);
                    if (userResponse.isPresent()) {
                        UserRegs userRegs = userResponse.get();
                        System.out.println(userRegs);
                        userRegs.setStatus(false);
                        userRegs.setDeleteDate("dateString");
                        System.out.println(userRegs);
                        UserRepositary userRepositary.save(userRegs);
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
    }
}