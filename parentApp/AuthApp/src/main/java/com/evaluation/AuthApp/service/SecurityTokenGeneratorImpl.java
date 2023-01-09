package com.evaluation.AuthApp.service;

import com.evaluation.AuthApp.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SecurityTokenGeneratorImpl implements SecurityTokenGenerator {
    @Override
    public Map<String, String> generateToken(User user) {
        Map<String,String>result=new HashMap<>();
        Map<String,Object>data=new HashMap<>();
        data.put("userObj",user);
        Date date=new Date();
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE,15);

        String jwtToken= Jwts.builder().setClaims(data)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512,"mysecurekey")
                .compact();

        result.put("token",jwtToken);
        result.put("message","User Logged In Successfully");
        return result;
    }
}
