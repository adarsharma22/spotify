package com.evaluation.AuthApp.controller;

import com.evaluation.AuthApp.model.CommonUser;
import com.evaluation.AuthApp.model.User;
import com.evaluation.AuthApp.service.SecurityTokenGenerator;
import com.evaluation.AuthApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth-app/v1")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private SecurityTokenGenerator securityTokenGenerator;

    //[POST]
    //http://localhost:2222/auth-app/v1/register-user
    @PostMapping("/register-user")
    public ResponseEntity<?>registerUser(@RequestBody CommonUser commonUser){
        return new ResponseEntity<>(userService.addUser(commonUser), HttpStatus.OK);
    }

    //[POST]
    //http://localhost:2222/auth-app/v1/authenticate
    @PostMapping("/authenticate")
    public ResponseEntity<?>authenticateUser(@RequestBody User user){
        User result=userService.loginCheck(user.getUserId(), user.getPassword());
        if(result!=null){//if user found attach jwt in return
            Map<String,String>key=securityTokenGenerator.generateToken(result);
            return new ResponseEntity<>(key,HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Auth Failed",HttpStatus.NOT_FOUND);
        }
    }
}
