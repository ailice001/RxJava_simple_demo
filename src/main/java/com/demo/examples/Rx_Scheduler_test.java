package com.demo.examples;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class Rx_Scheduler_test {


    public static void main(String...args){
        long  temp = 0;
        for (int i = 0; i < 10; i++) {
//            temp += Parallel_processing(); // method for Parallel processing
            temp += Concurrency_flow();      // method for Concurrency processing
        }
        System.out.println("all used : "+(temp/10));
    }

    private static long Parallel_processing(){
        long start = System.currentTimeMillis();
        Flowable.range(1, 10000)
                .flatMap(v ->
                        Flowable.just(v)
                                .subscribeOn(Schedulers.computation())
                                .map(w -> w * w)
                )
                .blockingSubscribe(System.out::println);
        return System.currentTimeMillis()-start;
    }

    private static long Concurrency_flow(){
        long start = System.currentTimeMillis();
        Flowable.range(1, 10000)
                .observeOn(Schedulers.computation())
                .map(v -> v * v)
                .blockingSubscribe(System.out::println);
        return System.currentTimeMillis()-start;
    }
}
