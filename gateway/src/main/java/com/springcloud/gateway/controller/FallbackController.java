package com.springcloud.gateway.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fb")
public class FallbackController {

    @PostMapping(value = "/ticket")
    @Operation(
            summary = "Fallback for Ticket Service",
            description = "Informs that the Ticket Service is unavailable"
    )
    public ResponseEntity<HttpStatus> ticketFallback(){
        return ResponseEntity.ok(HttpStatus.SERVICE_UNAVAILABLE);
    }

    @PostMapping(value = "/reservation")
    @Operation(
            summary = "Fallback for Reservation Service",
            description = "Informs that the Reservation Service is unavailable"
    )
    public ResponseEntity<HttpStatus> reservationFallback(){
        return ResponseEntity.ok(HttpStatus.SERVICE_UNAVAILABLE);
    }

    @PostMapping(value = "/user")
    @Operation(
            summary = "Fallback for User Service",
            description = "Informs that the User Service is unavailable"
    )
    public ResponseEntity<HttpStatus> userFallback(){
        return ResponseEntity.ok(HttpStatus.SERVICE_UNAVAILABLE);
    }
}
