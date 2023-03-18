package E_Data_Structure_Generic;

import java.util.*;

public class Containers {

    public static void main(String[] args) {

        /**
         * Array List
         */
        /* TODO most important ArrayList methods */
        /*ArrayList<String> names = new ArrayList<String>();
        names.add("Ali Alavi");
        names.size();
        names.isEmpty();
        names.contains("Ali Alavi");
        names.remove("Ali Alavi");
        names.remove(0);
        names.clear();
        names.get(0);
        names.indexOf("Ali Alavi");*/

        /**
         * Linked List
         */
        /*List<String> list = new LinkedList<String>();
        list.add("Ali");
        list.add("Taghi");
        System.out.println(list.get(1));
        list.remove("Taghi");
        for (String string : list) {
            System.out.println(string);
        }*/

        /**
         * Set
         */
        /*Set<String> set = new HashSet<String>();
        set.add("Ali");
        set.add("Taghi");
        set.add("Taghi");
        set.add("Ali");
        set.add("Taghi");
        System.out.println(set.size());
        for (String str : set)
            System.out.println(str);
        set.remove("Ali");
        System.out.println(set.contains("Ali"));
        System.out.println(set.contains("Taghi"));
        set.clear();
        System.out.println(set.size());*/

        /* Todo Convert to Array */
        //Todo 1 do not define size
        /*ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(new Integer(5));
        list.add(new Integer(4));
        list.add(new Integer(3));
        Object[] array = list.toArray();
        for (Object object : array) {
            System.out.println((Integer) object);
        }*/
        //Todo 2 define size
        /*Integer[] array2 = list.toArray(new Integer[list.size()]);*/

        /* Todo use HashSet */
        /*Set<Student> set = new HashSet<Student>();
        set.add(new Student("Ali"));
        System.out.println(set.contains(new Student("Ali")));*/

        /**
         * Hash Map
         */
        /*Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(87300876, "Ali Alavi");
        map.put(87234431, "Taghi Taghavi");
        map.put(87300876, "Naghi Naghavi");
        String name = map.get(87300876);
        System.out.println(name);
        System.out.println(map.get(87234431));*/

        /*Map<String, String> map = new HashMap<String, String>();
        map.put("Laptop", "Computers");
        map.put("Shahnameh", "Books");
        map.put("Tablet", "Books");
        map.put("Tablet", "Computers");
        System.out.println(map.size());
        System.out.println(map.get("Tablet"));
        System.out.println(map.get("GOLESTAN"));
        System.out.println(map.containsKey("TABLET"));
        System.out.println(map.containsValue("Books"));*/


        /* Todo Iterator */
        /*List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++)
            list.add(i);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            System.out.println(value);
        }*/

        /* Todo Fail Fast ConcurrentModificationException */
        /*Collection<String> c = new ArrayList<String>();
        Iterator<String> itr = c.iterator();
        c.add("An object");
        String s = itr.next(); => ConcurrentModificationException*/


        /**
         * Comparable, compareTo, Comparator
         */


    }
}

class Student implements Comparable<Student> {
    String name;
    int age;
    double grade;


    public Student(String name) {
        this.name = name;
    }

    public Student(int age, double grade) {
        this.age = age;
        this.grade = grade;
    }

    /* Todo CompareTo */
    @Override
    public int compareTo(Student s) {
        return (this.grade < s.grade ? -1 : (this.grade == s.grade ? 0 : +1));
        // return (Double.compare(this.grade, s.grade));
    }

    /* Todo equals method */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    /* Todo correct method */
    public static void removeAli(List<String> list) {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String string = iterator.next();
            if (string.startsWith("Ali"))
                iterator.remove();
        }
    }


    /*Todo wrong answer*/
    /*void removeAli(List<String> list){
        for (String string : list)
            if(string.startsWith("Ali"))
                list.remove(string);
    }*/

}

class StudentComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return s1.age < s2.age ? -1 : (s1.age == s2.age ? 0 : +1);
        //return Integer.compare(s1.age, s2.age);
    }
}

