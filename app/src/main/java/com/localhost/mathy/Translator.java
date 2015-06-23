// The Translator Class handles word representation of numbers, Glass voice input does not always provide a numeric representation for numbers
package com.localhost.mathy;

import android.util.Log;

import java.util.ArrayList;

public class Translator {

    public static int converted = -1;
     int parser(String x) {
        int value = 1;
        x.trim();
        ArrayList<String> list = new ArrayList<String>();
        String[] split = x.split("\\s+"); // splits where whitespace is seen
        for (String y : split) {
            list.add(y);
        }
        list.remove("and");
        for (int i = 0; i < list.size(); i++) { // designed to handle application max value, 63 * 63 = 3969
            if (i == 0 && list.size() == 1) { // Glass voice input read as intended numeric representation should not go through custom functions
                try{
                    value = Integer.parseInt(x);
                }
                catch (Exception E) {
                    Log.w("InputErr", "Non-numeric, one word input error");
                    value = englishToInt(x); // assign sentinel value
                }
                return value;
            }
            else if (i == 0) { // all values in application range handled
                value *= englishToInt(list.get(i));
            }
            else if (i == 1 && list.size() == 2) { // i.e. hundred eleven
                value += englishToInt(list.get(i));
            }
            else if (i == 1 && list.size() == 3) { // i.e. one thousand two
                value *= englishToInt(list.get(i));
            }
            else if (i == 2 && list.size() == 3) {  // i.e. one thousand two
                value += englishToInt(list.get(i));
            }
            else if (i == 1 && list.size() == 4) { // six thousand thirty one
                value *= englishToInt(list.get(i));
            }
            else if (i == 2 && list.size() == 4) { // six thousand thirty one
                value += englishToInt(list.get(i));
            }
            else if (i == 3 && list.size() == 4) { // six thousand thirty one
                value += englishToInt(list.get(i));
            }
            else if (i == 1 && list.size() == 5) {// six thousand one hundred five
                value *= englishToInt(list.get(i));
            }
            else if (i == 2 && list.size() == 5) { // six thousand one hundred five
                value += (englishToInt(list.get(i)) * englishToInt(list.get(++i)));
            }
            else if (i == 4 && list.size() == 5) {
                value += englishToInt(list.get(i));
            }

        }
        return value;
    }

    private int englishToInt(String english) // converts English word into integer representation
    {
        int number = 0;
        switch (english) {
            case "one":  number = 1;
                break;
            case "two":  number = 2;
                break;
            case "three":  number = 3;
                break;
            case "four":  number = 4;
                break;
            case "five":  number = 5;
                break;
            case "six":  number = 6;
                break;
            case "seven":  number = 7;
                break;
            case "eight":  number = 8;
                break;
            case "nine":  number = 9;
                break;
            case "ten": number = 10;
                break;
            case "eleven": number = 11;
                break;
            case "twelve": number = 12;
                break;
            case "thirteen": number = 13;
                break;
            case "fourteen": number = 14;
                break;
            case "fifteen": number = 15;
                break;
            case "sixteen": number = 16;
                break;
            case "seventeen": number = 17;
                break;
            case "eighteen": number = 18;
                break;
            case "nineteen": number = 19;
                break;
            case "twenty":  number = 20;
                break;
            case "thirty":  number = 30;
                break;
            case "forty":  number = 40;
                break;
            case "fifty":  number = 50;
                break;
            case "sixty":  number = 60;
                break;
            case "seventy":  number = 70;
                break;
            case"eighty":  number = 80;
                break;
            case "ninety":  number = 90;
                break;
            case "hundred": number = 100;
                break;
            case "thousand": number = 1000;
                break;
            case "million": number = 1000000;
            default: number = -9999999;
                break;
        }
        return number;
    }

}
