package com.evaluation.AuthApp.service;

import com.evaluation.AuthApp.model.CommonUser;
import com.evaluation.AuthApp.model.Song;
import com.evaluation.AuthApp.model.User;
import com.evaluation.AuthApp.model.UserDTO;
import com.evaluation.AuthApp.proxy.UserProxy;
import com.evaluation.AuthApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserProxy userProxy;

    @Override
    public User addUser(CommonUser commonUser) {
        //Common User has all data so extract data from it and send required data to playlist application
        UserDTO userDTO=new UserDTO(commonUser.getUserName(), commonUser.getEmailId(), commonUser.getPhone(),new ArrayList<Song>());
        //now send the data through feign client to playlist application
        ResponseEntity<?> response=userProxy.sendObjToPlaylistApp(userDTO);
        System.out.println(response);//for confirmation


        //set required data in user by extracting data from common user
        User user=new User();
        user.setEmailId(commonUser.getEmailId());
        user.setPassword(commonUser.getPassword());
        user.setRole("Role_User");//hard-coded role

        return userRepository.save(user);//to register the user
    }

    @Override
    public User loginCheck(int userId, String password) {
        //first check whether the user is already existing or not
        //if yes then match the password
        //if not then send the return value as null
        if(userRepository.findById(userId).isPresent()){
            User result=userRepository.findById(userId).get();
            if(result.getPassword().equals(password)){
                result.setPassword("");//setting password blank for security reason
                return result;
            }else{
                return null;
            }
        }else{
        return null;
        }
    }
}
