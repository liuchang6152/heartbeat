package com.liuchang.heartbeat.test;

import javax.print.attribute.IntegerSyntax;
import java.util.concurrent.*;

public class FutureTest {


    public Integer getFine(){
        Integer a = 33;
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return a;

    }
}
