package org.mathquiz;

public class Result {
    public boolean isSuccessful;
    public String value; // Change the type as needed
    public char correctValue; // Change the type as needed
    public long timeTaken;

    // Constructor
    public Result(boolean isSuccessful, String value, char correctValue, long timeTaken) {
        this.isSuccessful = isSuccessful;
        this.value = value;
        this.timeTaken = timeTaken;
        this.correctValue = correctValue;

    }
}