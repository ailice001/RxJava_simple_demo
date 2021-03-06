package com.demo.examples;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class Work {

    public static void main(String...args) throws InterruptedException {
        Background_computation();
    }

    private static void Background_computation() throws InterruptedException {
       // method 1
        Flowable.fromCallable(() -> {
        Thread.sleep(1000); //  imitate expensive computation
        return "do over";
    })
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.single())
            .subscribe(System.out::println, Throwable::printStackTrace);
    // aysnc to get data
        Thread.sleep(2000); // <--- wait for the flow to finish


        // same as up
/*        Flowable<String> source = Flowable.fromCallable(() -> {
            Thread.sleep(1000); //  imitate expensive computation
            return "Done";
        });

        Flowable<String> runBackground = source.subscribeOn(Schedulers.io());

        Flowable<String> showForeground = runBackground.observeOn(Schedulers.single());

        showForeground.subscribe(System.out::println, Throwable::printStackTrace);

        Thread.sleep(2000); // <--- wait for the flow to finish*/
    }

}
