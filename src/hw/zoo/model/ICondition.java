package hw.zoo.model;

import java.util.List;

/**
 * class provide information about who can placed in Cage
 */
public interface ICondition {
    List<Species> isAvailableFor();
}
