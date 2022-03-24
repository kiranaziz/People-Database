package assignment2;

/**
 * ICSI 311 Principles of Programming Languages
 * Fall 2021
 * TA Phipps
 * Student ID: 001440162
 * 
 * Represents a Person in the ADT - People Database.
 * @author Kiran Aziz
 * @version 1.0
 */
public class Person implements Comparable<Person>{
    /**
    * The name of the person.
    */
    private String name;

    /**
    * The birth date of the person.
    */
    private String dateOfBirth;

    /**
     * Constructs a new Person.
     * @param name:			A reference to the person's name.
     * @param dateOfBirth:	A reference to the person's date of birth.
     */
    public Person(String name, String dateOfBirth) {
        this.setName(name);
        this.setDateOfBirth(dateOfBirth);
    }

    /**
     * Returns the value of the person's name.
     * @return String value of the person's name.
     */
    public String getName() {
        return name;
    }
    
   /**
     * Sets the value of the person's name.
     * @param name: String value of the person's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the value of the person's birth date.
     * @param dateOfBirth: String value of the person's birth date.
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Returns the value of the person's birth date.
     * @return String value of the person's birth date.
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Compares two people's names.
     * @param p: Person to be compared with someone else.
     * @return Integer representing the comparison.
     */
    @Override
    public int compareTo(Person p) {
        return this.name.compareTo(p.name); // compares by the name
    }

    /**
     * Returns the String value of the Person.
     * @return String value of the Person.
     */
    @Override
    public String toString() {
        return ("Name: " + this.getName() + "\t" + "Birthday: " + this.getDateOfBirth());
    }
}
