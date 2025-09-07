package com.springcloud.reservationservice.controller;

import com.springcloud.reservationservice.dto.Reservation;
import com.springcloud.reservationservice.service.ReservationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/reservation")
@RestController
@RequiredArgsConstructor
@CrossOrigin
public class ReservationController {

    private final ReservationService reservationService;


    @GetMapping(value = "/list")
    @Operation(
            summary = "Get reservation list",
            description = "Fetches a reservation with details"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Reservation found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Reservation.class))),
            @ApiResponse(responseCode = "404", description = "Reservation not found")
    })
    public ResponseEntity<List<Reservation>> reservationList(){
        return ResponseEntity.ok(reservationService.reservationList());
    }
}
