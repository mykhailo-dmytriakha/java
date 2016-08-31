package com.mdmytriaha.controllet;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @RequestMapping("/")
    public String home() {
        return "Hello to test application";
    }

    @RequestMapping("/api")
    public ResponseEntity  api() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok("Hello, " + user.getUsername() + "!");
    }
}
