package B_Object_Orientation;

/* imports all class of package*/

import java.util.*;
import java.io.*;
import java.sql.*;

//import static ir.javacup.oop.Pride.length;

public class ObjectOrientedFeatures {

    public static void main(String[] args) {

        // syntax error
        // Singleton singleton = new Singleton();

        /* TODO Singleton*/
        /*Singleton singleton = Singleton.getInstance();
        singleton.run();
        Singleton singleton1 = Singleton.getInstance();
        singleton1.run();*/

        /* TODO cascade call with this*/
        Leaf x = new Leaf();
        x.increments().increments().increments().print();

    }
}

/* TODO private properties is accessible whole class */
class Access {
    private String name;

    public Access(String n) {
        name = n;
    }

    public void check(Access access) {
        access.name = name;
    }

    public static void main(String[] args) {
        Access a = new Access("Ali");
        Access b = new Access("Taghi");
        a.check(b);
        System.out.println(a.name);
        System.out.println(b.name);
    }
}

class Person {
    private String name;
    private int age;
    public static int MAX_AGE;

    public void setAge(int a) {
        if (a < MAX_AGE)
            age = a;
    }

    public static int getMAX_AGE() {
        //no access to age and name
        /* TODO syntax error*/
        //System.out.println(name);
        return MAX_AGE;
    }

    /* TODO static block for initialize static var*/
    static {
        MAX_AGE = 150;
    }
}

class LiveObjects {
    private static int liveInstances = 0;

    {
        liveInstances++;
    }

    public static int getLiveInstances() {
        return liveInstances;
    }

    public void finalize() {
        liveInstances--;
    }
}

class Singleton {
    private static Singleton instance;

    public void run() {
        System.out.println("singleton is running...");
    }

    private Singleton() {
    }

    {
        System.out.println("singleton created");
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

class Leaf {
    int i = 0;

    Leaf increments() {
        i++;
        return this;
    }

    void print() {
        System.out.println("i = " + i);
    }
}


