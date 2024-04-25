package com.hasantuncay.kotlin.usability.destructuringdeclarations;


import android.util.Pair;

public class Main {
    public static Pair<Integer, String> compute(int input) {
        if (input > 5) {
            return new Pair(input * 2, "High");
        } else {
            return new Pair(input * 2, "Low");
        }
    }

    public static void main(String[] args) {
        Pair<Integer, String> result = compute(7);
        System.out.println("Value: " + result.first + ", Label: " + result.second);
    }
}
