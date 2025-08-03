package com.springcloud.userservice.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class Ticket {

    private Long ticketId;
    private Long ticketNumber;
    private Date ticketDate;
}
