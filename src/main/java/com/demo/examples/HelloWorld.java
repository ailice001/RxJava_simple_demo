package com.demo.examples;

import io.reactivex.*;


public class HelloWorld {

    public static void main(String[] args) {
        Flowable.just("Hello world").subscribe(System.out::println);
    }
}