package hw.shapes;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Shape[][] list = new Shape[1][1];
        list[0] = new Shape[1];
        list[0][0] = new Box();

        for (Shape[] shape : list){
            for (Shape shape1 : shape) {
                System.out.println(shape1.getArea());
            }
        }
    }
}
