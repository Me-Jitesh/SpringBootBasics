package com.springboot.basics;

import com.springboot.basics.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@SpringBootApplication
public class SpringBootBasicsApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBootBasicsApplication.class, args);

        UserRepository userRepository = context.getBean(UserRepository.class);

        /*      Create Operation            */
        createOperation(userRepository);

        /*      Read Operation    */
        readOperation(userRepository);

        /*      Update Operation    */
        updateOperation(userRepository);

        /*      Delete Operation    */
        deleteOperation(userRepository);

    }

    private static void createOperation(UserRepository repository) {

//        Inserting Single Object
        User user = new User("Jitu Thakur", "Korba", "College Se pareshan Hai");

        User u = repository.save(user);
        System.out.println("******************************Print createOperation Single Object********************************");

        System.out.println(u);

//        Inserting Multiple Object
        User user2 = new User("Durga Shankar", "Korba", "ML Engineer");
        User user3 = new User("Utkarsh Tiwari", "Manendragarh", "Civil Engineer");
        User user4 = new User("Gitesh Kumar", "Dhamtari", "Front End Developer");

        List<User> userList = List.of(user2, user3, user4);
        Iterable<User> userIterable = repository.saveAll(userList);

        System.out.println("******************************Print createOperation Multiple Object********************************");
//        Print Output
        userIterable.forEach(users -> {
            System.out.println(users);
        });
    }

    public static void updateOperation(UserRepository repository) {
        Optional<User> optional = repository.findById(1);
        User user = optional.get();
        user.setName("Jitesh Singh");
        User res = repository.save(user);
        System.out.println("******************************Print updateOperation********************************");
        System.out.println(res);
    }

    public static void readOperation(UserRepository repository) {
        Iterable<User> iterable = repository.findAll();

        System.out.println("******************************Print readOperation Traditional Method********************************");

        Iterator<User> iterator = iterable.iterator();
        while (iterator.hasNext()) {
            User next = iterator.next();
            System.out.println(next);
        }

        System.out.println("******************************Print readOperation Consumer Method********************************");
        iterable.forEach(new Consumer<User>() {
            @Override
            public void accept(User user) {
                System.out.println(user);
            }
        });

        System.out.println("******************************Print readOperation Lambda Expression********************************");

        iterable.forEach(user -> System.out.println(user));
    }

    public static void deleteOperation(UserRepository repository) {

        repository.deleteById(1);
        System.out.println("******************************Print deleteOperation By Id********************************");

        Iterable<User> all = repository.findAll();
        repository.deleteAll(all);
        System.out.println("******************************Print deleteOperation By Iterator********************************");
    }
}
