package com.university.project.service;

import com.university.project.domain.Role;
import com.university.project.domain.User;
import com.university.project.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailSender mailSender;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public boolean addUser(User user) {
        User userFromDB = userRepository.findByUsername(user.getUsername());

        if (userFromDB != null) {
            return false;
        }

        user.setActive(false);
        user.setRoles(Collections.singleton(Role.USER));//сет с одним значением
        user.setActivationCode(UUID.randomUUID().toString());
        userRepository.save(user);

        //+ в методе activateUser(String code) добавить user.setActive(true).
        if (!StringUtils.isEmpty(user.getEmail())) {

            String message = String.format(
                    "Добрый день, %s! \n" +
                            "Добро пожаловать на сайт makeAcake.com. Чтобы подтвердить свою регистрацию," +
                            "пожалуйста, перейдите по этой ссылке:  http://localhost:8081/activate/%s",
                    user.getName(),
                    user.getActivationCode()
            );
            mailSender.send(user.getEmail(), "Код активации на сайте makeAcake.com", message);
        }
        return true;
    }

    public boolean activateUser(String code) {
        User user = userRepository.findByActivationCode(code);

        if (user == null) {
            return false;
        }
        user.setActivationCode(null);
        user.setActive(true);
        userRepository.save(user);

        return true;
    }
}
