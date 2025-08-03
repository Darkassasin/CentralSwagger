package com.springcloud.userservice.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class User {

    private Long userId;
    private String username;
    private String fullName;
    private String email;
}
