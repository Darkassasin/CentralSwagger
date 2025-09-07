package com.springcloud.userservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@Schema(description = "object representing a user")
public class User {

    @Schema(description = "Unique User Id", example = "1")
    private Long userId;

    @Schema(description = "Username of the user", example = "JohnDoe2452")
    private String username;

    @Schema(description = "Full name of the user", example = "John Doe")
    private String fullName;

    @Schema(description = "Email of the user", example = "john.doe@gmail.com")
    private String email;
}
