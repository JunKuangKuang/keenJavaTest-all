package xyz.clzly.keen;

import xyz.clzly.keen.service.KeenLog4j1Service;
import xyz.clzly.keen.service.KeenSlf4jService;


public class KeenMain {

    public static void main(String[] args) {
        new KeenSlf4jService().print();
        new KeenLog4j1Service().print();
    }
}