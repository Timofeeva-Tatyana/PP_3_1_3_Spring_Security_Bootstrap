package ru.kata.PP_3_1_3_Spring_Security_Bootstrap.configs;

import org.springframework.stereotype.Component;
import ru.kata.PP_3_1_3_Spring_Security_Bootstrap.model.Role;
import ru.kata.PP_3_1_3_Spring_Security_Bootstrap.model.User;
import ru.kata.PP_3_1_3_Spring_Security_Bootstrap.service.RoleService;
import ru.kata.PP_3_1_3_Spring_Security_Bootstrap.service.UserService;

import javax.annotation.PostConstruct;

@Component
public class DataInitializer {
    private final UserService userService;
    private final RoleService roleService;

    public DataInitializer(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    private void init() {

        Role role1 = new Role("ADMIN");
        Role role2 = new Role("USER");
        roleService.saveRole(role1);
        roleService.saveRole(role2);

        User user = new User();
        user.setName("Zaur");
        user.setSurname("Tregulov");
        user.setAge(33);
        user.setEmail("zaur@mail.ru");
        user.setPassword("Zaur");
        user.addRole(role1);
        user.addRole(role2);

        User user2 = new User();
        user2.setName("Oleg");
        user2.setSurname("Ivanov");
        user2.setAge(28);
        user2.setEmail("oleg@mail.ru");
        user2.setPassword("Oleg");
        user2.addRole(role1);

        User user3 = new User();
        user3.setName("Elena");
        user3.setSurname("Sidorova");
        user3.setAge(18);
        user3.setEmail("elena@mail.ru");
        user3.setPassword("Elena");
        user3.addRole(role2);

        User user4 = new User();
        user4.setName("Ivan");
        user4.setSurname("Petrov");
        user4.setAge(34);
        user4.setEmail("ivan@mail.ru");
        user4.setPassword("Ivan");
        user4.addRole(role2);

        User user5 = new User();
        user5.setName("Nina");
        user5.setSurname("Mironova");
        user5.setAge(43);
        user5.setEmail("nina@mail.ru");
        user5.setPassword("Nina");
        user5.addRole(role1);
        user5.addRole(role2);

        userService.saveUser(user);
        userService.saveUser(user2);
        userService.saveUser(user3);
        userService.saveUser(user4);
        userService.saveUser(user5);

    }
}
