package com.springcloud.userservice.controller;

import com.springcloud.userservice.dto.Ticket;
import com.springcloud.userservice.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/ticket")
@RestController
@RequiredArgsConstructor
@CrossOrigin
public class TicketController {

    private final TicketService ticketService;

    @GetMapping(value = "/list")
    public ResponseEntity<List<Ticket>> ticketList() {
        return ResponseEntity.ok(ticketService.ticketList());
    }
}
