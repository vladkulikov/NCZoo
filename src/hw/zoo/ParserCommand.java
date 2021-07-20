package hw.zoo;
import hw.zoo.model.*;


import java.lang.*;
import java.util.List;
import java.util.Scanner;

public class ParserCommand {

    ZooFactory zooFactory = new ZooFactory();
    Zoo zoo = new Zoo();




    public void getResult(){
        while(true) {
            Scanner keyboard = new Scanner(System.in);
            String command = keyboard.nextLine();
            command.replace("-","");
            String[] word = command.split("\\s");
            String c = word[0];
            switch (c) {
                case "check-in" -> zoo.checkInAnimal(zooFactory.createAnimal(getSpecies(word[1]), word[2]));
                case "check-out" -> zoo.checkOutAnimal(zooFactory.createAnimal(getSpecies(word[1]), word[2]));
                case "log" -> log(zoo.getHistory());
                case "exit" -> System.exit(1);
                default -> System.out.println("Incorrect command. Try again.");
            }
        }
    }


    public void log( List<InhibitionLog> inhibitionLogs){
        for (InhibitionLog inhibitionLog : inhibitionLogs) {
            System.out.print(inhibitionLog);
        }
    }

    public Species getSpecies(String name){
        Species species = null;
        try {
            switch (name.toUpperCase()) {
                case "LEON" -> species = Species.LEON;
                case "GIRAFFE" -> species = Species.GIRAFFE;
                case "SQUIRREL" -> species = Species.SQUIRREL;
                case "PENGUIN" -> species = Species.PENGUIN;
            }
        }
        catch (Exception e){
            System.out.println("Нельзя поместить такого животного");
        }
        return species;
    }


}
