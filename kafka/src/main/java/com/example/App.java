package com.example;

import com.example.demo.kafka.Consumer;
import com.example.demo.kafka.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * Hello world!
 *
 */
public class App
{
    private Logger logger = LoggerFactory.getLogger(App.class);
    public static void main( String[] args )
    {
        new Producer("test0518",true).start();
        new Consumer("test0518","group1","1").start();
        new Consumer("test0518","group1","2").start();
    }
}