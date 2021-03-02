package com.fabyosk.fsknotes;

import com.fabyosk.fsknotes.model.User;
import com.fabyosk.fsknotes.services.user.UserServices;

public class AppTest {
    public static void main(String[] args) {
        System.out.println("hello world");


        UserServices userServices = new UserServices();

        User userFoundedByName = userServices.findByName("fsk");
        User userFoundedById = userServices.findById(2);

        System.out.println(userFoundedByName.getName() + "Founded by name");
        System.out.println(userFoundedById.getName() + "Founded by id");


        User newUser = new User("SKA");
        userServices.add(newUser);

        System.out.println(newUser.getName() + " added on db");


    }
}
