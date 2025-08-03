package com.springcloud.reservationservice.controller;

import com.springcloud.reservationservice.dto.Reservation;
import com.springcloud.reservationservice.service.ReservationService;
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
    public ResponseEntity<List<Reservation>> reservationList(){
        return ResponseEntity.ok(reservationService.reservationList());
    }
}
