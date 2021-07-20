package hw.zoo.model;

public class Cage implements ICage{

    private int number;
    private int area;
    private ICondition condition;
    private boolean vacantCage;

    public Cage(int number, int area, ICondition condition, boolean vacantCage) {
        this.number = number;
        this.area = area;
        this.condition = condition;
        this.vacantCage = vacantCage;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public ICondition getCondition() {
        return condition;
    }

    @Override
    public boolean isVacantCage() {
        return vacantCage;
    }
}
