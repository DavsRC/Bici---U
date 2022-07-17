package models.ticket;

import common.CommonMethods;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import models.bici.Bici;
import models.user.User;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static java.util.Objects.isNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ticket implements CommonMethods, Serializable {

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

    @Override
    public String toString() {
        return  "Code: " + code + '\n'+
                "Bicycle: " + bici.getId() + '\n'+
                "User: " + user.getId() + '\n'+
                "Name: " + user.getName() + '\n'+
                "Date: " + date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + '\n'+
                "Start time: " + startDate.format(DateTimeFormatter.ofPattern("HH:mm")) + '\n'+
                "End time: " + printEndHour(endDate) + '\n'+
                "Have helmet: " + helmet + '\n'+
                "Good condition: " + noDamage + '\n'+
                "Amount: $" + amount + '\n'+
                "Status: " + status+ '\n';
    }

    private String printEndHour(LocalTime endHour) {
        return isNull(endHour) ? "-" : this.endDate.format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    @Override
    public String giveFormat() {
        return  (code +"," + bici.giveDataToTicket() +"," + user.giveFormat() + "," + date +"," + startDate +"," + endDate +
                "," + helmet +"," + noDamage +"," + amount +"," + status);
    }
}
