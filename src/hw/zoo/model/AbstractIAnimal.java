package hw.zoo.model;

public class AbstractIAnimal implements IAnimal {
    private final String name;
    private final Species species;

    public AbstractIAnimal(String name, Species species) {
        this.name = name;
        this.species = species;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Species getSpecies() {
        return species;
    }

    /*public String getSpeciesName() {
        String string = "re";

        switch (species) {
            case LEON:
                string = "LEON";
                break;
            case GIRAFFE:
                string = "LEON";
                break;
            case SQUIRREL:
                string = "LEON";
                break;
            case PENGUIN:
                string = "LEON";
                break;
        }
            return string;
        }

     */

}