package hw.zoo;

import hw.zoo.model.IAnimal;

import java.util.List;

/**
 * entity keep state of Zoo and provide service desk functionality
 * @checkInAnimal method add Animal to Zoo
 * should throw exception when Zoo can't provide place
 * @checkOutAnimal method remove Animal from Zoo
 * @getHistory - method show log of check in and check out
 */
public interface IZoo {
    void checkInAnimal(IAnimal animal);
    void checkOutAnimal(IAnimal animal);
    List<InhibitionLog> getHistory();
}
