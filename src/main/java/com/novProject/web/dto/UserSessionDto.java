package com.novProject.web.dto;

import com.novProject.domain.user.Role;
import com.novProject.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class UserSessionDto implements Serializable {
    private String name;
    private String email;
    private Role role;

    public UserSessionDto(User entity){
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.role = entity.getRole();
    }
}
