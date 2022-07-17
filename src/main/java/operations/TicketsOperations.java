package operations;

import models.ticket.Ticket;

import java.io.*;

public class TicketsOperations {


    public static void saveTicket(Ticket ticket){
        try{
            File file = new File("src/main/resources/tickets.txt");
            FileWriter fileWriter = new FileWriter(file,true);
            fileWriter.write(ticket.giveFormat() + "\n");
            fileWriter.flush();
            fileWriter.close();

        }catch (FileNotFoundException exception){
            System.out.println("The file doesn't exit");
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }
}
