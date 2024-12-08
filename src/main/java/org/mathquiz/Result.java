package org.mathquiz;

public class Result {
    public boolean isSuccessful;
    public double value; // Change the type as needed
    public double correctValue; // Change the type as needed
    public long timeTaken;

    // Constructor
    public Result(boolean isSuccessful, double value, double correctValue, long timeTaken) {
        this.isSuccessful = isSuccessful;
        this.value = value;
        this.timeTaken = timeTaken;
        this.correctValue = correctValue;

    }
}