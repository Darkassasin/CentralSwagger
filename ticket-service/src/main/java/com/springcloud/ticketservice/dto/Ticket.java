package com.springcloud.ticketservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@Schema(description = "Ticket Response")
public class Ticket {

    @Schema(description = "Unique id for ticket", example = "11")
    private Long ticketId;

    @Schema(description = "", example = "2792")
    private Long ticketNumber;

    @Schema(description = "Date of ticket issued", example = "2025-09-07T14:48:58.401+00:00")
    private Date ticketDate;
}
