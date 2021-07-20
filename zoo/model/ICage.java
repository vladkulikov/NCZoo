package hw.zoo.model;

/**
 * class provide information about Cage
 * Assumptions:
 * one Cage - one Animal
 * @getNumber() used as return primary key
 */
public interface ICage {
    //primary key
    int getNumber();
    double getArea();
    ICondition getCondition();
    boolean isVacantCage();
}
