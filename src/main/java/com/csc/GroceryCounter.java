package com.csc;

public class GroceryCounter {
    private int count;        // Represents the counter value
    private int overflows;    // Number of overflows
    private int maxValue;     // Custom maximum counter value

    // Constructor with a default maximum value of 9999
    public GroceryCounter(int startingValue, int maxValue) {
        if (startingValue < 0 || startingValue > maxValue) {
            throw new IllegalArgumentException("Starting value must be within the range 0 to " + maxValue);
        }
        this.count = startingValue;
        this.overflows = 0;
        this.maxValue = maxValue;
    }

    // Constructor with a default maximum value of 9999
    public GroceryCounter(int startingValue) {
        this(startingValue, 9999);
    }

    // Default constructor with default starting value of 0 and maximum value of 9999
    public GroceryCounter() {
        this(0, 9999);
    }

    // Increment the counter 
    private void incrementCounter() {
        count++;
        if (count > maxValue) {
            count = 0;
            overflows++;
        }
    }

    // Increment the tens digit
    public void incrementTens() {
        count += 100;
        while (count > maxValue) {
            count -= (maxValue + 1); 
            incrementCounter();
        }
    }

    // Increment the ones digit
    public void incrementOnes() {
        count += 1;
        while (count > maxValue) {
            count -= (maxValue + 1); 
            incrementCounter();
        }
    }

    // Increment the tenths digit
    public void incrementTenths() {
        count += 10;
        while (count > maxValue) {
            count -= (maxValue + 1); 
            incrementCounter();
        }
    }

    // Increment the hundredths digit
    public void incrementHundredths() {
        count += 100;
        while (count > maxValue) {
            count -= (maxValue + 1); 
            incrementCounter();
        }
    }

    // Decrement the tens digit
    public void decrementTens() {
        count -= 100;
        while (count < 0) {
            count += (maxValue + 1); 
            overflows--;
        }
    }

    // Decrement the ones digit
    public void decrementOnes() {
        count -= 1;
        while (count < 0) {
            count += (maxValue + 1); 
            overflows--;
        }
    }

    // Decrement the tenths digit
    public void decrementTenths() {
        count -= 10;
        while (count < 0) {
            count += (maxValue + 1); 
            overflows--;
        }
    }

    // Decrement the hundredths digit
    public void decrementHundredths() {
        count -= 100;
        while (count < 0) {
            count += (maxValue + 1); 
            overflows--;
        }
    }

    // Format the current count 
    public String total() {
        int dollars = count / 100;
        int cents = count % 100;
        return String.format("$%02d.%02d", dollars, cents);
    }

    // Get the number of overflows
    public int numberOfOverflows() {
        return overflows;
    }

    public void clear() {
        count = 0;
        overflows = 0;
    }
}
