package com.poddar.CrudOperation.service;
import com.poddar.CrudOperation.repositary.UserRepositary;

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
   UserRepositary userRepositary;

    public Boolean loginMethodService(LoginRequest loginRequest) {

        //loginRequest form data
        long id = loginRequest.getId();
        String pwd = loginRequest.getPassword();

        //Db store login data
        Optional<UserRegs> user = userService.getUserById(id);
        if (user.isPresent()) {
            UserRegs userRegs = user.get();
            System.out.println(id + " " + pwd);
            if (userRegs.isStatus() == false) {
                return false;
            } else {
                if (id == user.get().getId() && pwd.equals(user.get().getPassword())) {
                    return true;
                } else {
                    return false;
                }
            }

            } else{
                return false;

            }
        }
                //Delete Profile Service Method
                public boolean deleteMethodService (long id){
                     Optional<UserRegs> userResponse = userService.getUserById(id);
                    if (userResponse.isPresent()) {
                        UserRegs userRegs = userResponse.get();
                        if(userRegs.isStatus() == true){
                            userRegs.setStatus(false);
                            userRegs.setDeleteDate("dateString");
                            userRepositary.save(userRegs);
                            return true;
                        }else {
                            return false;
                        }

                    } else {
                        return false;
                    }
                }
            }


