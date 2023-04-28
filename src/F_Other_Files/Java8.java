package F_Other_Files;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Java8 {

    public static void main(String[] args) {

        /* Todo Lambda Expression */
        Comparator<Person> comp = (a, b) -> a.age().compareTo(b.age());

        /* Example */
        // Collections.sort(people, (a, b) -> a.age().compareTo(b.age()));

        /* Todo Method Reference */
        Str str = new Str();
        Converter<String, Character> conv = str::startsWith;
        Character converted = conv.convert("Java");
        // Static method reference
        Converter<String, Integer> converter = Integer::valueOf;
        // Reference to the Constructor
        Factory<Car> factory1 = Car::new;
        Car car1 = factory1.create();

        /* Todo Built-in functional interfaces in Java 8 */
        Comparator<Human> comparator = (p1, p2) -> p1.getName().compareTo(p2.getName());
        Human p1 = new Human("Ali");
        Human p2 = new Human("Taghi");

        comparator.compare(p1, p2);
        comparator.reversed().compare(p1, p2);

        /* Todo Predicate */
        String st = "ok";
        boolean b;
        Predicate<String> notEmpty = (x) -> x.length() > 0;
        b = notEmpty.test(st);              // true
        b = notEmpty.negate().test(st);     // false

        Predicate<String> notNull = x -> x != null;
        b = notNull.and(notEmpty).test(st); // true

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();

        /* Todo Function */
        Function<String, Integer> toInteger =
                Integer::valueOf;
        Function<String, String> backToString =
                toInteger.andThen(String::valueOf);

        backToString.apply("123");     // "123"

        /* Todo Supplier */
        Supplier<Human> humanSupplier = Human::new;
        Supplier<Human> humanSupplier2 = () -> new Human();
        Human human = humanSupplier.get();   // new Human

        /* Todo Consumer */
        Consumer<Human> greeter =
                p -> System.out.println("Hi " + p.getName());
        greeter.accept(new Human("Ali"));

    }

}

@FunctionalInterface
interface Person {


    Date getBirthDate();

    /* TODO Default Method */
    default Integer age() {
        long diff = new Date().getTime() - getBirthDate().getTime();
        return (int) (diff / (1000L * 60 * 60 * 24 * 365));
    }
}

class Teacher implements Person {
    private Date birthDate;


    @Override
    public Date getBirthDate() {
        return birthDate;
    }
}

@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}

class Str {
    Character startsWith(String s) {
        return s.charAt(0);
    }
}

interface Factory<T> {
    T create();
}

class Car {
}

class Human {
    private String name;

    public Human(String name) {
        this.name = name;
    }

    public Human() {

    }

    public String getName() {
        return name;
    }
}




