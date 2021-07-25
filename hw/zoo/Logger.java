package hw.zoo;

import hw.zoo.model.IAnimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Logger extends InhibitionLog{
    List<InhibitionLog> inhibitionLogs = new ArrayList<>();

    public void addLogIn(IAnimal animal, String result){
        inhibitionLogs.add(new InhibitionLog.Builder().
                withInDate(new Date()).
                withName(animal.getName()).
                withSpecies(animal.getSpecies()).
                withResult(result).
                build()
        );
    }

    public void addLogOut(IAnimal animal, String result){
        inhibitionLogs.add(new InhibitionLog.Builder().
                withOutDate(new Date()).
                withName(animal.getName()).
                withSpecies(animal.getSpecies()).
                withResult(result).
                build()
        );
    }

    public List<InhibitionLog> getLogs(){
        return inhibitionLogs;
    }

}
