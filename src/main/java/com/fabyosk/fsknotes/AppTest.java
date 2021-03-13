package com.fabyosk.fsknotes;

import com.fabyosk.fsknotes.model.Note;
import com.fabyosk.fsknotes.model.User;
import com.fabyosk.fsknotes.services.user.UserServices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring/spring-config.xml");
        User user = new User();
        user.setName("fsk");
        user.setUsername("fsk");
        user.setPassword("fsk");

        UserServices userServices = context.getBean(UserServices.class);


        userServices.add(user);

    }
}
