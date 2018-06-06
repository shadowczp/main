package com.example.auth.po;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserSecretTest {
    @Test
    public void testLombok(){
        UserSecret userSecret = new UserSecret();
        userSecret.setId(10);
        System.out.println(userSecret);
    }
}