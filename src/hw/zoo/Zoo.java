package hw.zoo;

import hw.zoo.model.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Zoo implements IZoo {

    Logger logger = new Logger();
    Map<String, Cage> zoo = new HashMap<>();//клетка и какое животное там живет

    List<Cage> cages;//клетки
    List<Condition> condition;//список расс которые могут жить в i-ой клетке

    public Zoo(int size) throws IOException {
        cages = new ArrayList<>();
        condition = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            String s = Files.readAllLines(Paths.get("C:\\UNC-Source-Code-main\\src\\hw\\Species.txt")).get(i + 1);
            condition.add(new Condition(readConditions(s)));
            cages.add(new Cage(i + 1, 12, condition.get(i), true));
        }
    }

    @Override
    public void checkInAnimal(IAnimal animal) {
        boolean flag = true;
        for (Cage cage : cages) {
            if ((cage.isVacantCage()) && (cage.getCondition().isAvailableFor().contains(animal.getSpecies()))) {
                cage.setVacantCage(false);
                zoo.put(animal.getName(), cage);
                break;
            } else {
                flag = false;

            }
        }
        if (flag) {
            System.out.println("Заселили");
            logger.addLogIn(animal, "Success");
        } else {
            System.out.println("Нельзя поселить");
            logger.addLogIn(animal, "No success");
        }
    }

    @Override
    public void checkOutAnimal(IAnimal animal) {
        boolean flag = true;
        if (zoo.containsKey(animal.getName())) {
            zoo.get(animal.getName()).setVacantCage(true);
            zoo.remove(animal.getName());
        } else {
            flag = false;
        }
        if (flag) {
            System.out.println("Заселили");
            logger.addLogIn(animal, "Success");
        } else {
            System.out.println("Нельзя поселить");
            logger.addLogIn(animal, "No success");
        }
    }


    @Override
    public List<InhibitionLog> getHistory() {
        return logger.getLogs();
    }


    public List<Species> readConditions(String word) throws IOException {
        List<Species> result = new ArrayList<>();
        String[] words = word.split(" ");
        for (String s : words) {
            result.add(Species.getSpecies(s));
        }
        return result;
    }

}
