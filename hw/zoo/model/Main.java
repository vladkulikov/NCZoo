package hw.zoo.model;

import hw.zoo.ParserCommand;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        List<Species> list = new ArrayList<Species>();
        //list = new Condition().isAvailableFor();
        System.out.println("Типы команд:");
        System.out.println("check-in [species] [name] - позволяет поселить животное в клетку");
        System.out.println("check-out [species] [name] - позволяет выселить животное из клетки");
        System.out.println("log - вывод логов");
        System.out.println("exit - выход из программы");


        System.out.println("Допустимые виды животных:");
        //list.forEach(System.out::println);
        ParserCommand parserCommand = new ParserCommand();
        parserCommand.getResult();
    }
}
