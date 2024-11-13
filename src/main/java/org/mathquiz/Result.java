package org.mathquiz;

public class Result {
    public boolean isSuccessful;
    public double value; // Change the type as needed

    // Constructor
    public Result(boolean isSuccessful, double value) {
        this.isSuccessful = isSuccessful;
        this.value = value;
    }
}