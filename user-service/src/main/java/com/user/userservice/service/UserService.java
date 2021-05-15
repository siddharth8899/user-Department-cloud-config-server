package com.user.userservice.service;

import com.user.userservice.VO.Department;
import com.user.userservice.VO.ResponseTemplateVO;
import com.user.userservice.entity.User;
import com.user.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
@Slf4j
public class UserService{
    @Autowired
    UserRepository repo;
    @Autowired
    RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("inside saveUser of userService");
        return repo.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        log.info("inside getUserWithDepartment of userService");
        User user = repo.findByUserId(userId);
        Department department = restTemplate.getForObject("https://DEPARTMENT-SERVICE/departments/" +user.getDepartmentId(), Department.class);
        vo.setDepartment(department);
        vo.setUser(user);
        return vo;
    }
}
