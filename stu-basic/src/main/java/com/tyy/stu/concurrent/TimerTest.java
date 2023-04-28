package com.tyy.stu.concurrent;

import org.junit.jupiter.api.Test;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {


    @Test
    public void timmmer() throws InterruptedException {

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("timer!!!");
            }
        }, 3000);


        Thread.sleep(5000);
    }

    @Test
    public void timmmer2() {


        System.out.println(((null instanceof Timer)));
    }


}
