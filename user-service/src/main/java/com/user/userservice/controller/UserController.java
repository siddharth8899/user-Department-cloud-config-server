package com.user.userservice.controller;

import com.user.userservice.VO.ResponseTemplateVO;
import com.user.userservice.entity.User;
import com.user.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    UserService service;

    @PostMapping("/")
        public User saveUser(@RequestBody User user){
        log.info("inside saveUser of userController");
            return service.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long departmentId){
        log.info("inside getUserWithDepartment of userController");
        return service.getUserWithDepartment(departmentId);
    }

}
