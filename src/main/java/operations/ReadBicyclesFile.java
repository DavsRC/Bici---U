package operations;

import models.bici.Bici;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReadBicyclesFile {

    static final String FILE = "src/main/resources/bicycles.txt";
    public static List<Bici> biciList = readBicycle();



    public static ArrayList<Bici> readBicycle(){

        ArrayList<Bici> biciList = new ArrayList<>();

        try {
            File file = new File(FILE);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            List<String> newBici;

            while ((line = bufferedReader.readLine()) != null){
                newBici = populateNewBiciList(line);
                String id = newBici.get(0);
                String type = newBici.get(1);
                String color = newBici.get(2);
                boolean available =  Boolean.parseBoolean( newBici.get(3));
                biciList.add(new Bici(id, type, color, available));
            }
            bufferedReader.close();
            fileReader.close();

        }catch (Exception exception){
            System.out.println("An error occurred while the file was been read. This can be caused by: " +  exception.getMessage());
        }

        return biciList;
    }

    private static List<String> populateNewBiciList(String line) {
        return Arrays.stream(line.split(";")).collect(Collectors.toList());
    }
}
