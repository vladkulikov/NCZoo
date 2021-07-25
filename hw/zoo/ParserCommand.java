package hw.zoo;

import hw.zoo.model.*;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ParserCommand {

    ZooFactory zooFactory = new ZooFactory();
    Zoo zoo = new Zoo(Integer.parseInt(Files.readAllLines(Paths.get("C:\\UNC-Source-Code-main\\src\\hw\\Species.txt")).get(0)));
    Scanner keyboard = new Scanner(System.in);

    public ParserCommand() throws IOException {
    }


    public void getResult() throws IOException {
        while (true) {
            String command = keyboard.nextLine();
            String[] word = command.split("\\s");
            String c = word[0];
            switch (c) {
                case "check-in" -> {
                    try {
                        Species.getSpecies(word[1]);
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                        getResult();
                    }
                    zoo.checkInAnimal(zooFactory.createAnimal(Species.getSpecies(word[1]), word[2]));
                }
                case "check-out" -> {
                    try {
                        Species.getSpecies(word[1]);
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                        getResult();
                    }
                    zoo.checkOutAnimal(zooFactory.createAnimal(Species.getSpecies(word[1]), word[2]));
                }
                case "log" -> log(zoo.getHistory());
                case "exit" -> System.exit(1);
                default -> System.out.println("Incorrect command. Try again.");
            }
        }
    }


    public void log(List<InhibitionLog> inhibitionLogs) {
        for (InhibitionLog inhibitionLog : inhibitionLogs) {
            System.out.print(inhibitionLog);
        }
    }


}
