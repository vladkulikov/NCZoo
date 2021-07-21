package hw.zoo;
import hw.zoo.model.*;


import java.io.IOException;
import java.lang.*;
import java.util.List;
import java.util.Scanner;

public class ParserCommand {

    ZooFactory zooFactory = new ZooFactory();
    Zoo zoo = new Zoo();
    Scanner keyboard = new Scanner(System.in);



   public void getResult() throws IOException {
        while(true) {
            String command = keyboard.nextLine();
            String[] word = command.split("\\s");
            String c = word[0];
            switch (c) {
                case "check-in" -> {
                    try {
                        getSpecies(word[1]);
                    }
                    catch (IOException e) {
                        System.out.println(e.getMessage());
                        getResult();
                    }
                    zoo.checkInAnimal(zooFactory.createAnimal(getSpecies(word[1]), word[2]));
                }
                case "check-out" -> {
                    try {
                        getSpecies(word[1]);
                    }
                    catch (IOException e) {
                        System.out.println(e.getMessage());
                        getResult();
                    }
                    zoo.checkOutAnimal(zooFactory.createAnimal(getSpecies(word[1]), word[2]));
                }
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

    public Species getSpecies(String name) throws IOException {
        Species species = null;

            switch (name.toUpperCase()) {
                case "LEON" -> species = Species.LEON;
                case "GIRAFFE" -> species = Species.GIRAFFE;
                case "SQUIRREL" -> species = Species.SQUIRREL;
                case "PENGUIN" -> species = Species.PENGUIN;
            }
        if (species == null) {
            throw new IOException("Incorrect species. Try again.");
        }
        return species;
    }








}
