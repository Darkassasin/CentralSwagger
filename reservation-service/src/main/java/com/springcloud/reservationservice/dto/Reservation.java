package com.springcloud.reservationservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
@Schema(description = "Ticket Response")
public class Reservation {

    @Schema(description = "Unique id for reservation", example = "11")
    private Long reservationId;

    @Schema(description = "Date of reservation made", example = "2025-09-07T14:48:58.401+00:00")
    private Date reservationDate;
}
