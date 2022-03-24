package assignment2;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * ICSI 311 Principles of Programming Languages
 * Fall 2021
 * TA Phipps
 * Student ID: 001440162
 * 
 * Displays and tests the ADT People Database using the helper methods by
 * reading in a file of people's data.
 * 
 * @author Kiran Aziz
 * @version 1.0
 */
public class Test{
	/**
	 * Tests the ADTPeopleDatabase implementation by reading in a file of people and other tests.
	 * @param args A reference to a String array of arguments.
	 * @throws FileNotFoundException If a file cannot be found, a FileNotFoundException will be thrown.
	 * @throws BinarySearchTreeException If an operation on the ADTPeopleDatabase's binary search tree fails, 
	 * 		   a BinarySearchTreeException will be thrown.
     */
	public static void main(String[] args) throws FileNotFoundException, BinarySearchTreeException{
		
		ADTPeopleDatabase database = new ADTPeopleDatabase();
		
		fill(database);
        test(database);
    }
	
	/**
     * Displays and tests the ADTPeopleDatabase.
     * @param testDB A reference to a database of people.
     * @throws FileNotFoundException If file is not found
     */
    public static void test(ADTPeopleDatabase testDB) throws FileNotFoundException {
    	System.out.println("\n------------------------DISPLAYING------------------------");
    	
    	ArrayList<Person> people1 = new ArrayList<Person>();
    	people1 = testDB.displayAll(); //Returns list of all people.
    	int i = 0;
        
    	//Displays all people in the ADT People Database.
        while(people1.size() > i){
        	System.out.println(people1.get(i));
            i++;
        }
        
        System.out.println("\n-------------------------------------------------------");
        
        String month = "12";  //Specified month to search database. 
        ArrayList<Person> people2 = new ArrayList<Person>();
        people2 = testDB.displaySameMonth(month); //Returns a list of people with specified month. Should return 2 people.
        
        i = 0;
        //Displays all people in the ADT People Database with birth month of 12.
        while(people2.size() > i){
        	System.out.println(people2.get(i));
            i++;
        }
        
        System.out.println("\n-------------------------------------------------------");
        
        String day = "21";  //Specified day to search database.
        ArrayList<Person> people3 = new ArrayList<Person>();
        people3 = testDB.displaySameDay(day); //Returns a list of people with specified day. Should return 5 people.
        
        i = 0;
        //Displays all people in the ADT People Database with birth day of 21. Should return 2 people.
        while(people3.size() > i){
        	System.out.println(people3.get(i));
            i++;
        }
    	
        System.out.println("\n-------------------------------------------------------");
        
        String year = "1977";  //Specified day to search database.
        ArrayList<Person> people4 = new ArrayList<Person>();
        people4 = testDB.displaySameYear(year); //Returns list of people with specified year. Should return 4 people.
        
        i = 0;
        //Displays all people in the ADT People Database with birth year of 1977. 
        while(people4.size() > i){
        	System.out.println(people4.get(i));
            i++;
        }
    	
    	System.out.println("\n------------------------TESTING------------------------");
    	
    	System.out.println("Size: " + testDB.size()); 						//Tests size() method.
        System.out.println("Search/Contains: " + testDB.search("James Butt")); 	//Tests contains() method.
        System.out.println("Get: " + testDB.get("James Butt")); 			//Tests get() method.
        System.out.println("Remove: Akira Green");
        
        testDB.remove("Akira Green");		//Tests remove() method.
        testDB.remove("Aliyah Spears");		//Tests remove() method.
        
        System.out.println("New size: " + testDB.size()); 	//Tests size() method.
        
        Person me = new Person("Kiran Aziz", "01/01/2000");
        testDB.insert(me);		//Tests insert() method with new person.
        System.out.println("Final Size: " + testDB.size());
        
        System.out.println("Is the database empty?: " + testDB.isEmpty()); 	//Tests isEmpty() method.
        testDB.makeEmpty(); 					//Tests makeEmpty() method.
        System.out.println("Is the database empty?: " + testDB.isEmpty()); 	//isEmpty() method after database becomes empty.
    }
	
	
	/**
     * Inserts people from a text file into the ADTPeopleDatabase.
     * @param testDB A reference to a database of people.
     * @throws FileNotFoundException thrown if the file is not found
     */
    public static void fill(ADTPeopleDatabase testDB) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("People.txt")); //Reading from text file.
	    
	    while(scanner.hasNext()) {
	    	String[] tokens = scanner.nextLine().split(","); //Splits line by comma
	        
	        String name = tokens[0]; //Name is the first token in the line.
	        String birthDate = tokens[1]; //Birthday is the second token in the line.
	        
	        Person person = new Person(name, birthDate); //Creates a person with the above info.         
	        testDB.insert(person); //Adds the person to the ADTPeopleDatabase.
	    }
	    
	    scanner.close(); //Closes scanner.
    }
}
