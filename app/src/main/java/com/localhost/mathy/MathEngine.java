package com.localhost.mathy;
import java.util.Random;

public class MathEngine {
    static int vals[] = new int[3];

    enum lastMode {
        ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION
    }
    public static lastMode mode = null;

    public void generate() {
        Random engine = new Random();
        do {
            vals[0] = Math.abs(engine.nextInt() % 64);
            vals[1] = Math.abs(engine.nextInt() % 64);
        } while(vals[0] < vals[1] || vals[1] == 0); // prevents negative subtraction answers and divide by zero errors
    }

    public String display() {
        String out;
        switch (mode) {
            case ADDITION: 		  out = vals[0] + " + " + vals[1] + " = ";
                break;
            case SUBTRACTION:     out = vals[0] + " - " + vals[1] + " = ";
                break;
            case MULTIPLICATION:  out = vals[0] + " * " + vals[1] + " = ";
                break;
            case DIVISION:       out = vals[0] + " / " + vals[1] + " = ";
                break;
            default:			  out = "Enum error";
                break;
        }
        for (int i = 0; i < vals.length; i++) {
            vals[i] = -999; // sentinel value
        }
        return out;
    }

    public void addition() {
        this.generate();
        vals[2] = vals[0] + vals[1];
        mode = lastMode.ADDITION;
    }

    public void subtraction() {
        this.generate();
        vals[2] = vals[0] - vals[1];
        mode = lastMode.SUBTRACTION;
    }

    public void multiplication() {
        this.generate();
        vals[2] = vals[0] * vals[1];
        mode = lastMode.MULTIPLICATION;
    }

    public void division() {
        this.generate();
        vals[2] = vals[0] / vals[1];
        mode = lastMode.DIVISION;
    }

}
