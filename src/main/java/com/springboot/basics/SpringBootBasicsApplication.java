package com.springboot.basics;

import com.springboot.basics.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootBasicsApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBootBasicsApplication.class, args);

        UserRepository userRepository = context.getBean(UserRepository.class);

        User user = new User("Jitu Thakur", "Korba", "College Se pareshan Hai");
        User u = userRepository.save(user);
        System.out.println(u);
    }

}
