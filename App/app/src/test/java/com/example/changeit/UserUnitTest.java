package com.example.changeit;

import com.example.changeit.model.User;
import com.example.changeit.model.UserHandler;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserUnitTest {

    UserHandler userHandler = UserHandler.getInstance();

    @Test
    public void createUser_test() {

        userHandler.createUser("Lisa", "test@gmail.com", "123", "hej");
        userHandler.createUser("Moa", "test@gmail.com", "123", "hej");

        assertEquals(userHandler.getAllUsers().size(), 1);



    }


    @Test
    public void getUserByEmail_test() {

        userHandler.createUser("Lisa", "test@gmail.com", "123", "hej");
        userHandler.createUser("Moa", "hej@gmail.com", "456", "hej");


        User user = userHandler.getUserByEmail("test@gmail.com");

        User user2 = userHandler.getUserByEmail("hej@gmail.com");

        assertNotEquals(user, user2);

        assertEquals(user2.getName(), "Moa");

    }





}
