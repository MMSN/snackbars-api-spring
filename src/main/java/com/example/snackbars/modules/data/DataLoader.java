package com.example.snackbars.modules.data;

import com.example.snackbars.modules.auth.entity.ERole;
import com.example.snackbars.modules.auth.entity.Role;
import com.example.snackbars.modules.auth.repository.RoleRepository;
import com.example.snackbars.modules.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public DataLoader(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public void run(ApplicationArguments args) {
        roleRepository.save(new Role(ERole.ROLE_USER));
        roleRepository.save(new Role(ERole.ROLE_MODERATOR));
        roleRepository.save(new Role(ERole.ROLE_ADMIN));
        //userRepository.save(new User("lala", "lala", "lala"));
    }
}