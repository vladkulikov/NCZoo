package hw.zoo.model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Condition implements ICondition{
    List<Species> list;


    public List<Species> isAvailableFor() {
        list = new ArrayList<>();
        list = Arrays.asList(Species.values());
        return list;
    }
}
