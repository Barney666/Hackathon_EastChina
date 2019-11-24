package com.barney.hackathon;

import com.barney.hackathon.entity.Account;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class HackathonEastChinaApplication {

    public static Map<String, Account> tokenMap=new HashMap();

    public static Account findAccountByToken(String token){
        for(String string:tokenMap.keySet()){
            if(string.equals(token)){
                return tokenMap.get(string);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        SpringApplication.run(HackathonEastChinaApplication.class, args);
    }

}
