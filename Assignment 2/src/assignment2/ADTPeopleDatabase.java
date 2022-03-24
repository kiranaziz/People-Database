package assignment2;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * ICSI 311 Principles of Programming Languages
 * Fall 2021
 * TA Phipps
 * Student ID: 001440162
 * 
 * Abstract data type, or ADT, that maintains a database containing data, such as name and birthday.
 * @author Kiran Aziz
 * @version 1.0
 */
public class ADTPeopleDatabase{
    /**
     * A binary search tree to be the structure of the ADTPeopleDatabase,
     * which is used to store the people and their information.
     */
    private BinarySearchTree<Person> tree;

    /**
     * Keeps track of the number of people added to the ADTPeopleDatabase.
     */
    private int count;

    /**
     * Constructs an empty ADTPeopleDatabase.
     */
    public ADTPeopleDatabase() {
        this.tree = new BinarySearchTree<Person>();
    }

    /**
     * Returns the number of people in the ADTPeopleDatabase.
     * @return Integer value representing the number of people.
     */
    public int getCount() {
        return count;
    }

    /**
     * Sets the number of people in the ADTPeopleDatabase.
     * @param count The new number of people.
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * Returns the ADTPeopleDatabase's binary search tree.
     * @return A reference to the binary search tree.
     */
    public BinarySearchTree<Person> getTree(){
        return this.tree;
    }

    /**
     * Sets the ADTPeopleDatabase's binary search tree to the given binary search tree.
     * @param tree A reference to the new binary search tree.
     */
    public void setTree(BinarySearchTree<Person> tree){
        this.tree = tree;
    }
    
	/**
	 * Traverses the ADTPeopleDatabase's binary search tree in inorder, 
	 * with the left child first, then the root, and finally the right child of every Node.
	 * @param node A reference to the root Node of the ADTPeopleDatabase's binary search tree.
	 * @param list A list to contain all of the people in inorder.
	 * @return A list to contain all of the people in inorder.
	 */
	public ArrayList<Person> inorder(Node<Person> node, ArrayList<Person> list){
		if(node != null){
			inorder(node.getLeft(), list); 
			list.add(node.getElement());
			inorder(node.getRight(), list);	
		}
		return list;
	}
    
    /**
     * Inserts a new Person into the ADTPeopleDatabase.
     * @param person Reference to the Person to be inserted.
     */
    public void insert(Person person) {
        this.tree.insert(person);
        this.setCount(this.getCount() + 1); //Updates the count of people.

    }
    
    /**
     * Removes a person from the ADTPeopleDatabase.
     * @param name A reference to the Person's name.
     */
    public void remove(String name){
    	//List of all people in the database.
    	ArrayList<Person> people = new ArrayList<Person>();
    	inorder(this.tree.root, people);
		int i = 0;
    	
        while (people.size() > i) {
            //Temporary placeholder to hold each person, and then checks name.
        	Person temp = people.get(i);
            i++;
            if (temp.getName().equals(name)) {
                this.tree.remove(temp);
                this.setCount(this.getCount() - 1); //Decrements the count
                return;
            } else {
                continue; //Continues traversing through the database.
            }
        }
        people.clear();
    }

    /**
     * Returns whether the Person exists in the ADTPeopleDatabase.
     * @param name A reference to the Person's name
     * @return A boolean value of whether the Person exists in the ADTPeopleDatabase.
     */
    public boolean search(String name){
    	//List of all people in the database.
    	ArrayList<Person> people = new ArrayList<Person>();
    	inorder(this.tree.root, people);
		int i = 0;
        
        while(people.size() > i){
        	//Temporary placeholder to hold each person, and then checks name.
        	Person temp = people.get(i);
            i++;
            if(temp.getName().equals(name)){
                return true; // Returns true if person matches
            }else{
                continue; //Continues traversing
            }
        }
        people.clear();
        return false; //Person not found
    }

    /**
     * Returns a reference to a Person with the given name, if found.
     * @param name A reference to the Person's name to be found in the database.
     * @return A Person of the given name.
     */
    public Person get(String name) {
    	//List of all people in the database.
    	ArrayList<Person> people = new ArrayList<Person>();
    	inorder(this.tree.root, people);
		int i = 0;
        
        while(people.size() > i){
        	//Temporary placeholder to hold each person, and then checks name.
            Person temp = people.get(i);
            i++;
            if(temp.getName().equals(name)){
                return temp; //If the two names match.
            }else{
                continue; //Continues traversing.
            }
        }
        people.clear();
        return null; //If no person matches. 
    }

    /**
     * Returns whether an ADTPeopleDatabase is empty.
     * @return A boolean value of whether the ADTPeopleDatabase is empty.
     */
    public boolean isEmpty() {
        return this.tree.isEmpty();
    }

    /**
     * Removes all the people in an ADTPeopleDatabase.
     */
    public void makeEmpty() {
        this.tree.makeEmpty();

    }

    /**
     * Returns the number of people in the ADTPeopleDatabase
     * @return An Integer value representing the number of people present.
     */
    public int size() {
        return this.getCount();
    }
    
    /**
     * Lists all people in the ADTPeopleDatabase.
     * @return ArrayList<Person> A list of all people present.
     */
    public ArrayList<Person> displayAll(){
    	ArrayList<Person> people = new ArrayList<Person>();
    	inorder(this.tree.root, people);
    	
    	return people;
    }
    
    /**
     * Helps make a list of people in the ADT People Database that share the same birth month.
     * @param month A reference to the specified month.
     * @return ArrayList<Person> A list of all people with the same birth month.
     */
    public ArrayList<Person> displaySameMonth(String month){
    	//List of all people in the database.
    	ArrayList<Person> people = new ArrayList<Person>();
    	ArrayList<Person> peopleSameMonth = new ArrayList<Person>();
    	inorder(this.tree.root, people);
		int i = 0;
        
        while(people.size() > i){
        	//Temporary placeholder to hold each person, and then checks name.
        	Person temp = people.get(i);
            
        	//If the birth month of the person matches to the desired month, it is
        	//added to the list of people with the same birth month.
            if(temp.getDateOfBirth().substring(0,2).equals(month) == true){
            	peopleSameMonth.add(temp);
            }
            i++;
        }
        
        return peopleSameMonth; 
    }
    
    /**
     * Helps make a list of people in the ADT People Database that share the same birth day.
     * @param day A reference to the specified day.
     * @return ArrayList<Person> A list of all people with same birth day.
     */
    public ArrayList<Person> displaySameDay(String day){
    	//List of all people in the database.
    	ArrayList<Person> people = new ArrayList<Person>();
    	ArrayList<Person> peopleSameDay = new ArrayList<Person>();
    	inorder(this.tree.root, people);
		int i = 0;
        
        while(people.size() > i){
        	//Temporary placeholder to hold each person, and then checks name.
        	Person temp = people.get(i);
            
        	//If the birth day of the person matches to the desired day, it is
        	//added to the list of people with the same birth day.
            if(temp.getDateOfBirth().substring(3,5).equals(day) == true){
            	peopleSameDay.add(temp);
            }
            i++;
        }
        
        return peopleSameDay; 
    }
    
    /**
     * Helps make a list of people in the ADT People Database that share the same birth year.
     * @param year A reference to the specified year.
     * @return ArrayList<Person> A list of all people with same birth year.
     */
    public ArrayList<Person> displaySameYear(String year){
    	//List of all people in the database.
    	ArrayList<Person> people = new ArrayList<Person>();
    	ArrayList<Person> peopleSameYear = new ArrayList<Person>();
    	inorder(this.tree.root, people);
		int i = 0;
        
        while(people.size() > i){
        	//Temporary placeholder to hold each person, and then checks name.
        	Person temp = people.get(i);
            
        	//If the birth year of the person matches to the desired year, it is
        	//added to the list of people with the same birth year.
            if(temp.getDateOfBirth().substring(6,10).equals(year) == true){
            	peopleSameYear.add(temp);
            }
            i++;
        }
        
        return peopleSameYear; 
    }
    
}