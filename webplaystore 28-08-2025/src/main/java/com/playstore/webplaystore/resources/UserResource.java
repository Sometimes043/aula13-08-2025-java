package com.playstore.webplaystore.resources;

import com.playstore.webplaystore.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1L,"Matheus", "ribeiroavilamatheus@gmail.com", "043996089567", "123456");
        return ResponseEntity.ok().body(u);
    }
}
