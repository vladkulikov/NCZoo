package hw.zoo;

import hw.zoo.model.*;

import java.util.*;

public class Zoo implements IZoo{

    Map<Species, String> cages = new HashMap<Species, String>();
    List<InhibitionLog> inhibitionLogs = new ArrayList<InhibitionLog>();

    @Override
    public void checkInAnimal(IAnimal animal) {
        if(cages.containsKey(animal.getSpecies())){
            System.out.println("Занято");

            inhibitionLogs.add(new InhibitionLog.Builder().
                    withInDate(new Date()).
                    withName(animal.getName()).
                    withSpecies(animal.getSpecies()).
                    withResult("No success").
                    build()
            );
        }
        else{

            cages.put(animal.getSpecies(), animal.getName());
            System.out.println("Заселили");

            inhibitionLogs.add(new InhibitionLog.Builder().
                    withInDate(new Date()).
                    withName(animal.getName()).
                    withSpecies(animal.getSpecies()).
                    withResult("Success").
                    build()
            );
        }
    }

    @Override
    public void checkOutAnimal(IAnimal animal) {
        if(cages.containsValue(animal.getName())){
            System.out.println("Выселяем");
            cages.remove(animal.getSpecies());

            inhibitionLogs.add(new InhibitionLog.Builder().
                    withOutDate(new Date()).
                    withName(animal.getName()).
                    withSpecies(animal.getSpecies()).
                    withResult("Success").
                    build()
            );

        }
        else{
            //cages.put(animal.getSpecies(), animal.getName());
            System.out.println("Такого животного нет");

            inhibitionLogs.add(new InhibitionLog.Builder().
                    withOutDate(new Date()).
                    withName(animal.getName()).
                    withSpecies(animal.getSpecies()).
                    withResult("No success").
                    build()
            );
        }
    }


    @Override
    public List<InhibitionLog> getHistory() {
        return inhibitionLogs;
    }


}
