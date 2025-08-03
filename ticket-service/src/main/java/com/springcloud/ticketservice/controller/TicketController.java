package com.springcloud.ticketservice.controller;

import com.springcloud.ticketservice.dto.Ticket;
import com.springcloud.ticketservice.service.TicketService;
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
