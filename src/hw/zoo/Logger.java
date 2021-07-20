package hw.zoo;

import hw.zoo.model.IAnimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Logger extends InhibitionLog{
    List<InhibitionLog> inhibitionLogs = new ArrayList<InhibitionLog>();

    public void addLog(IAnimal animal, String result){
        inhibitionLogs.add(new InhibitionLog.Builder().
                withInDate(new Date()).
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
