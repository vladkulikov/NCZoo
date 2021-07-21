package hw.zoo;

import hw.zoo.model.*;

import java.util.*;

public class Zoo implements IZoo{
    Map<Species, String> cages = new HashMap<Species, String>();
    Logger logger = new Logger();

    @Override
    public void checkInAnimal(IAnimal animal) {
        if(cages.containsKey(animal.getSpecies())){
            System.out.println("Занято");
            logger.addLogIn(animal, "No success");
        }
        else{
            cages.put(animal.getSpecies(), animal.getName());
            System.out.println("Заселили");
            logger.addLogIn(animal, "Success");
        }
    }

    @Override
    public void checkOutAnimal(IAnimal animal) {
        if(cages.containsValue(animal.getName())){
            System.out.println("Выселяем");
            cages.remove(animal.getSpecies());
            logger.addLogOut(animal, "Success");
        }
        else{
            //cages.put(animal.getSpecies(), animal.getName());
            System.out.println("Такого животного нет");
            logger.addLogOut(animal, "No success");
        }
    }


    @Override
    public List<InhibitionLog> getHistory() {
        return logger.getLogs();
    }


    public Map<Species, String> getCages() {
        return cages;
    }


}
