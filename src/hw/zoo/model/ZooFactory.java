package hw.zoo.model;

public class ZooFactory {

    public IAnimal createAnimal (Species species, String name) {
        IAnimal IAnimal = null;

        try {
            IAnimal = switch (species) {
                case LEON -> new Leon(name, species);
                case GIRAFFE -> new Giraffe(name, species);
                case SQUIRREL -> new Squirrel(name, species);
                case PENGUIN -> new Penguin(name, species);
            };
        }
        catch (Exception e){
            System.out.println("Нельзя поместить такого животного");
        }

        return IAnimal;
    }
}
