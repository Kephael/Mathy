package com.localhost.mathy;
import android.util.Log;

import java.util.Random;

public class MathEngine {
    static int vals[] = new int[3];

    enum lastMode {
        ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION
    }
    private static lastMode mode = null;

    private void generate(int limit) {
        Random engine = new Random();
        do {
            vals[0] = Math.abs(engine.nextInt() % (limit + 1));
            vals[1] = Math.abs(engine.nextInt() % (limit + 1));
        } while(vals[0] < vals[1] || vals[1] == 0); // prevents negative subtraction answers and divide by zero errors
    }

    public String display() {
        String out;
        switch (mode) {
            case ADDITION: 		    out = vals[0] + " + " + vals[1] + " = ";
                break;
            case SUBTRACTION:       out = vals[0] + " - " + vals[1] + " = ";
                break;
            case MULTIPLICATION:    out = vals[0] + " * " + vals[1] + " = ";
                break;
            case DIVISION:          out = vals[0] + " / " + vals[1] + " = ";
                break;
            default:			    out = "Enum error";
                                    Log.wtf("enum error", "enum mismatch, got " + mode);
                break;
        }
        for (int i = 0; i < vals.length; i++) {
            vals[i] = -999; // sentinel value
        }
        return out;
    }

    public void equSelect() {
        Random select = new Random();
        int mode = select.nextInt(4); // random generates a number 0 - 3 in order to select problem mode
        Log.v("select", "mode selection rolled " + mode);
        switch (mode) {
            case 0: this.addition();
                break;
            case 1: this.subtraction();
                break;
            case 2: this.division();
                break;
            case 3: this.multiplication();
                break;
            default: this.addition();
                break;
        }
    }

    private void addition() {
        this.generate(63);
        vals[2] = vals[0] + vals[1];
        mode = lastMode.ADDITION;
    }

    private void subtraction() {
        this.generate(63);
        vals[2] = vals[0] - vals[1];
        mode = lastMode.SUBTRACTION;
    }

    private void multiplication() {
        this.generate(12);
        vals[2] = vals[0] * vals[1];
        mode = lastMode.MULTIPLICATION;
    }

    private void division() {
        this.generate(20);
        vals[2] = vals[0] / vals[1];
        mode = lastMode.DIVISION;
    }

}
