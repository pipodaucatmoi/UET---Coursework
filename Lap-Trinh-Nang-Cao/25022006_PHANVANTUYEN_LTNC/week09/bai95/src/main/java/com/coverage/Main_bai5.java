package com.coverage;

public class Main_bai5 {
    public String checkNumber(int n) {
        if (n > 0) {
            return "Positive";
        } else if (n < 0) {
            return "Negative";
        } else {
            return "Zero";
        }
    }
}