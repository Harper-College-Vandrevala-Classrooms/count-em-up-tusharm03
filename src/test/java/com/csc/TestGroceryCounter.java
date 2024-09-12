package com.csc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestGroceryCounter {

    @Test
    public void testInitialState() {
        GroceryCounter counter = new GroceryCounter();
        assertEquals(0, counter.numberOfOverflows(), "Initial overflows should be 0");
        assertEquals("$00.00", counter.total(), "Initial total should be $00.00");
    }

    @Test
    public void testCustomStartingValue() {
        GroceryCounter counter = new GroceryCounter(1234);
        assertEquals(0, counter.numberOfOverflows(), "Initial overflows should be 0");
        assertEquals("$12.34", counter.total(), "Initial total should be $12.34");
    }

    @Test
    public void testCustomMaximumValue() {
        GroceryCounter counter = new GroceryCounter(0, 19999);
        counter.incrementTens(); // Increment by 100
        assertEquals("$01.00", counter.total(), "Total after incrementing tens should be $01.00");
        counter.incrementOnes(); // Increment by 1
        assertEquals("$01.01", counter.total(), "Total after incrementing ones should be $01.01");
    }

    @Test
    public void testIncrementTens() {
        GroceryCounter counter = new GroceryCounter();
        counter.incrementTens(); // Increment by 100
        assertEquals("$01.00", counter.total(), "Total after incrementing tens by 100 should be $01.00");
        counter.incrementTens(); // Increment by another 100
        assertEquals("$02.00", counter.total(), "Total after incrementing tens by 200 should be $02.00");
    }

    @Test
    public void testIncrementOnes() {
        GroceryCounter counter = new GroceryCounter();
        for (int i = 0; i < 5; i++) {
            counter.incrementOnes(); // Increment by 1 each time
        }
        assertEquals("$00.05", counter.total(), "Total after incrementing ones by 5 should be $00.05");
    }

    @Test
    public void testIncrementTenths() {
        GroceryCounter counter = new GroceryCounter();
        counter.incrementTenths(); // Increment by 10
        assertEquals("$00.10", counter.total(), "Total after incrementing tenths by 10 should be $00.10");
    }

    @Test
    public void testIncrementHundredths() {
        GroceryCounter counter = new GroceryCounter();
        counter.incrementHundredths(); // Increment by 100
        assertEquals("$01.00", counter.total(), "Total after incrementing hundredths by 100 should be $01.00");
    }

    @Test
    public void testDecrementTens() {
        GroceryCounter counter = new GroceryCounter(1000);
        counter.decrementTens(); // Decrement by 100
        assertEquals("$09.00", counter.total(), "Total after decrementing tens by 100 should be $09.00");
        counter.decrementTens(); // Decrement by another 100
        assertEquals("$08.00", counter.total(), "Total after decrementing tens by 200 should be $08.00");
    }

    @Test
    public void testDecrementOnes() {
        GroceryCounter counter = new GroceryCounter(5);
        counter.decrementOnes(); // Decrement by 1
        assertEquals("$00.04", counter.total(), "Total after decrementing ones by 1 should be $00.04");
    }

    @Test
    public void testDecrementTenths() {
        GroceryCounter counter = new GroceryCounter(15);
        counter.decrementTenths(); // Decrement by 10
        assertEquals("$00.05", counter.total(), "Total after decrementing tenths by 10 should be $00.05");
    }

    @Test
    public void testDecrementHundredths() {
        GroceryCounter counter = new GroceryCounter(100);
        counter.decrementHundredths(); // Decrement by 100
        assertEquals("$00.00", counter.total(), "Total after decrementing hundredths by 100 should be $00.00");
    }

    @Test
    public void testClear() {
        GroceryCounter counter = new GroceryCounter();
        for (int i = 0; i < 500; i++) {
            counter.incrementOnes(); // Increment by 1 each time
        }
        counter.clear();
        assertEquals(0, counter.numberOfOverflows(), "Overflows should be 0 after clearing");
        assertEquals("$00.00", counter.total(), "Total should be $00.00 after clearing");
    }
}
