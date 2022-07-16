package models.ticket;

import models.bici.Bici;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import models.user.User;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket {

    private String code;
    private Bici bici;
    private User user;
    private LocalDate date;
    private LocalTime startDate;
    private LocalTime endDate;
    private boolean helmet;
    private boolean noDamage;
    private int amount;
    private Status status;
}
