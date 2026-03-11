package org.example.springhomework001.Model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.springhomework001.Enum.TicketStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketRequest {
        private String passengerName;
        private String travelDate;
        private String sourceStation;
        private String destinationStation;
        private Double price;
        private Boolean paymentStatus;
        private TicketStatus ticketStatus;
        private String seatNumber;
}
