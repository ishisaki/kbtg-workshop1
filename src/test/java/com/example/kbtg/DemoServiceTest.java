package com.example.kbtg;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class DemoServiceTest {

    @Test
    @DisplayName("ในการทำงานต้อง random ได้ค่า 5")
    public void random_5() {
        DemoService demoService = new DemoService();
        demoService.setRandom(new Random5());
        String actualResult = demoService.generateData("somkiat");
        assertEquals("somkiat5", actualResult);
    }

    @Test
    @DisplayName("DemoService with RuntimeException")
    public void random_10() {
        DemoService demoService = new DemoService();
        demoService.setRandom(new Random10());
        assertThrows(RuntimeException.class, () -> demoService.generateData("somkiat"));
    }
}

class Random5 extends Random {
    @Override
    public int nextInt(int bound) {
        return 5;
    }
}

class Random10 extends Random {
    @Override
    public int nextInt(int bound) {
        return 10;
    }
}