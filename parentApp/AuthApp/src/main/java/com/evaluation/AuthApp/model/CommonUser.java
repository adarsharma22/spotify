package com.evaluation.AuthApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommonUser {
    private String userName,emailId,phone,password;
}
