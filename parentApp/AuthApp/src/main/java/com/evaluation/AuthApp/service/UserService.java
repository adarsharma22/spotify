package com.evaluation.AuthApp.service;

import com.evaluation.AuthApp.model.CommonUser;
import com.evaluation.AuthApp.model.User;

public interface UserService {
    public abstract User addUser(CommonUser commonUser);
    public abstract User loginCheck(int userId,String password);
}
