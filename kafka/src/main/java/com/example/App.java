package com.example;

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
        new Producer("test0516",true).start();
    }
}
