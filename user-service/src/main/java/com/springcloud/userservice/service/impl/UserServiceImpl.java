package com.springcloud.userservice.service.impl;

import com.springcloud.userservice.dto.User;
import com.springcloud.userservice.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class UserServiceImpl implements UserService {

    /**
     * @return List<Ticket>
     *     no params
     */
    @Override
    public List<User> userList() {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = User.builder().userId(ThreadLocalRandom.current().nextLong(100))
                    .username(getRandomUsername())
                    .fullName(getRandomFullName())
                    .email(getRandomEmail())
                    .build();
            userList.add(user);
        }
        return userList;
    }

    public static String getRandomFullName() {
        String[] firstNames = {"John", "Jane", "Mike", "Sarah", "David", "Emma", "Chris", "Lisa", "Alex", "Maria"};
        String[] lastNames = {"Smith", "Johnson", "Brown", "Davis", "Wilson", "Miller", "Moore", "Taylor", "Anderson", "Thomas"};

        String firstName = firstNames[ThreadLocalRandom.current().nextInt(firstNames.length)];
        String lastName = lastNames[ThreadLocalRandom.current().nextInt(lastNames.length)];

        return firstName + " " + lastName;
    }

    public static String getRandomEmail() {
        String[] firstNames = {"john", "jane", "mike", "sarah", "david", "emma", "chris", "lisa", "alex", "maria"};
        String[] lastNames = {"smith", "johnson", "brown", "davis", "wilson", "miller", "moore", "taylor", "anderson", "thomas"};
        String[] domains = {"gmail.com", "yahoo.com", "hotmail.com", "outlook.com", "example.com"};

        String firstName = firstNames[ThreadLocalRandom.current().nextInt(firstNames.length)];
        String lastName = lastNames[ThreadLocalRandom.current().nextInt(lastNames.length)];
        String domain = domains[ThreadLocalRandom.current().nextInt(domains.length)];

        return firstName + "." + lastName + "@" + domain;
    }

    public static String getRandomUsername() {
        String[] adjectives = {"cool", "smart", "fast", "brave", "wild", "dark", "bright", "swift", "bold", "epic"};
        String[] nouns = {"tiger", "eagle", "wolf", "shark", "dragon", "ninja", "warrior", "hunter", "storm", "shadow"};

        String adjective = adjectives[ThreadLocalRandom.current().nextInt(adjectives.length)];
        String noun = nouns[ThreadLocalRandom.current().nextInt(nouns.length)];
        int number = ThreadLocalRandom.current().nextInt(100, 1000);

        return adjective + noun + number;
    }
}
