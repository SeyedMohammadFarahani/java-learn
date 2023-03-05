package C_Advanced_Object_Oriented_Concepts;

public class Polymorphism {

    /* TODO final class => Inheritance X */
    /* TODO final method => Override X */

    /* TODO Binding in compile => call private method */

    /* TODO Binding in runtime => */

    /**
     * Animal a ;
     * if(X) a = new Cat();
     * else  a = new Fish();
     * a.move("right", 3.0);
     */

    public static void main(String[] args) {
        /*Parent parent = new Parent();
        parent.f();
        Child child = new Child();
        child.f();
        parent = child;
        parent.f();*/

        /* TODO instanceof */
        Animal x = new Cat();
        if (x instanceof Cat) {
            Cat c = (Cat) x;
        }
        /* TODO getClass */
        String className = x.getClass().getSimpleName();
    }
}

class Parent {
    public void f() {
        System.out.println("f() in parent");
    }
}

class Child extends Parent {
    public void f() {
        System.out.println("f() in child");
    }

}

abstract class Animal {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void talk();
}

class Cat extends Animal {
    public void talk() {
        System.out.println("Meww!!");
    }
}
