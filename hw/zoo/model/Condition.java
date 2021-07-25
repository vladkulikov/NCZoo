package hw.zoo.model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Condition implements ICondition{

    List<Species> list = new ArrayList<>();

    public Condition(List<Species> list) {
        this.list = list;
    }


    public List<Species> isAvailableFor() {
        return list;
    }

}
