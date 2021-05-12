package com.example.changeit;

import androidx.lifecycle.ViewModelProvider;

import com.example.changeit.model.Advertisement;
import com.example.changeit.model.User;
import com.example.changeit.model.UserHandler;
import com.example.changeit.ui.profile.ProfileFragment;
import com.example.changeit.ui.profile.ProfileViewModel;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Moa Berglund, Lisa Samuelsson
 * A class that tests the user and userhandler classes
 * @since 2020-04-14
 */

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

/*
    @Test
    public void getUsersApartments_test(){
        ProfileFragment profileFragment = new ProfileFragment();

        List<Advertisement> advertisementList = profileFragment.profileViewModel.getAdvertisements().getValue();
        assertNotEquals(null, advertisementList.get(0));
    }

 */

    @Test
    public void getUsersApartments_test(){

        UserHandler userHandler = UserHandler.getInstance();

        int userN = userHandler.getAllUsers().size();
        //String name = user.getName();

        assertEquals(0,userN);
    }


     // TODO - clean up






}
