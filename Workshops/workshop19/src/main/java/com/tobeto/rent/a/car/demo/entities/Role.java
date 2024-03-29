package com.tobeto.rent.a.car.demo.entities;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;

@Getter
public enum Role implements GrantedAuthority {

    ROLE_USER("USER"),
    ROLE_ADMIN("ADMIN"),
    ROLE_MODERATOR("MODERATOR"),
    ROLE_MANAGER("MANAGER");

    private final String value;

    Role(String value) {
        this.value = value;
    }

    @Override
    public String getAuthority() {
        return name();
    }

}
