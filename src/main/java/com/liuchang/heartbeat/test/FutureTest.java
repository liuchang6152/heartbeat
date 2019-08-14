package com.liuchang.heartbeat.test;

import javax.print.attribute.IntegerSyntax;
import java.util.concurrent.*;

public class FutureTest {
    public static void main(String[] args) {

        ExecutorService executorService= Executors.newSingleThreadExecutor();
            FutureTask<Integer> futureTask =new FutureTask<Integer>(()->{
                FutureTest futureTest = new FutureTest();
                return futureTest.getFine();
            });
        executorService.execute(futureTask);
        try{
            Integer result=futureTask.get(2,TimeUnit.SECONDS);
            System.out.println("result:"+result);
        }
        catch (Exception e){
            System.out.println("超时了!");
        }

    }

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
