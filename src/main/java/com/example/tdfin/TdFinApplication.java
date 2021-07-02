package com.example.tdfin;

import com.example.tdfin.entities.AppRole;
import com.example.tdfin.entities.AppUser;
import com.example.tdfin.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.stream.Stream;

@SpringBootApplication
public class TdFinApplication {
    @Autowired
    private AccountService accountService;
    @Autowired
    public static void main(String[] args) {
        SpringApplication.run(TdFinApplication.class, args);

    }
    @Bean
    public BCryptPasswordEncoder getBCPE() {
        return new BCryptPasswordEncoder();
    }
    public void run(String... args) throws Exception {
        accountService.saveUser(new AppUser("admin", "1234",null));
        accountService.saveUser(new AppUser("user", "1234",null));
        accountService.saveRole(new AppRole("ADMIN"));
        accountService.saveRole(new AppRole("USER"));
        accountService.addRoleToUser("admin", "ADMIN");
        accountService.addRoleToUser("user", "USER");
    }
}
