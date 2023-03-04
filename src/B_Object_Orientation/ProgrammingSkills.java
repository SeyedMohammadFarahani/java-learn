package B_Object_Orientation;

/**
 * This class represents a Programming Skills for Java
 */
public class ProgrammingSkills {
    /* یک JAR شامل کلاس‌های ترجمه شده (class.) است */
    /* jar cf jar-file input-files */

    /* Class path */
    /* این پارامتر به java یا javac پاس می‌شود */

    /* تعیین چند فولدر یا JAR در classpath */
    /* java -cp D:\prog;D:\lib\support.jar org.HelloWorld */

    /* تولید مستندات با کمک javadoc */
    /* javadoc Rectangle.java */

}

class Human {
    /**
     * national ID (SSN)
     */
    private String ID;
    private String name; //No javadoc

    /**
     * The only constructor of the class
     *
     * @param id   The social security number (national ID)
     * @param name The full-name, including first-name and last-name
     */
    public Human(String id, String name) {
        ID = id;
        this.name = name;
    }

    /**
     * This method should be called to ask the person run
     *
     * @param speed The speed of running
     * @return returns true if he/she can run with that speed
     */
    public boolean run(double speed) {
        return true;
    }
}


