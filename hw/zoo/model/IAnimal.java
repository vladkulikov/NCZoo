package hw.zoo.model;

/**
 * class provide information about Animal
 * each animal should has own class
 * @getName is used as primary key of Animal
 */
public interface IAnimal {
    String getName();
    Species getSpecies();
}
