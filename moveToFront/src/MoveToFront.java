/*************************************************************************
 *
 *  Pace University
 *  Fall 2021
 *  Data Structures and Algorithms
 *
 *  Course: CS 241
 *  Team authors: Maddy Zambrano & Michael Del Vechio 
 *  External Collaborators: none
 *  References: Set Class from Programming Assignment 1, ChatGPT for extra credit 
 *
 *  Assignment: 2
 *  Problem: Create a class, MoveToFront that is able to manipulate a Stack using LinkedLists. Then, create a class that tests all the methods created in the first class. 
 *  Description: Our MoveToFront class uses a LinkedList objects to alter a stack. The linked list is initialized in the constructor. Then, we created
 * methods push, pop, contains, and isEmpty, the descriptions of these methods can be found in our comments. The other class in the file is the testMTF class, 
 * which has a main methods where the methods from MoveToFront can be tested.
 *
 *  Input: Items added, removed, or checked for contains in list.
 *  Output: Results of opperations, such as the toString methods that provides a display of all items in the set. 
 *
 *  Visible data fields:
 *  private LinkedList<T> move; 
 *  Visible methods:
 *  public void push(T item)
 *  public void pop(T item) 
 *  public boolean contains(T item)
 *  public boolean isEmpty()
 *  public String toString()
 * 
 *  
 * 
 *
 *
 *   Remarks
 *   -------
 *
 *   Question 3 
 *                ArrayList    LinkedList 
 *   push()          O(n)          O(1)
 *   pop()           O(n)          O(1)
 *   contains()      O(n)          O(n)
 *   isEmpty()       O(1)          O(1)
 *   toString()      O(n)          O(n)
 * 
 *   Question 4 
 *  1. The push method of MoveToFront is implemented with a method call to contains to check if item is in the list, then to either remove or addFirst. addFirst of ArrayList is in O(n) in the worst case, so same bound applies to push.
 *  2. The push method of MoveToFront is implemented with a method call to contains to check if item is in the list, then to either remove or addFirst. addFirst of LinkedList is inO(1) in the worst case because it does not have to transverse through the stack.
 *  3. The pop method of MoveToFront is implemented with one method call to removeLast of ArrayList. removeLast of ArrayList is in O(n) in the worst case, so the same bound on running time applies to pop. 
 *  4. The pop method of MoveToFront is implemented with one method call to removeLast of LinkedList. removeLast of LinkedList is in O(1) in the worst case because it doesn't have to ranscers the list to get to the last node.
 *  5. The contains method of MoveToFront is implemented with a method call to contains to check it the item is in the list. contains of ArrayList is in O(n) in the worst case because it would have to transverse the ArrayList. 
 *  6. The contains method of MoveToFront is implemented with a method call to contains to check it the item is in the list. contains of LinkedList is in O(n) in the worst case because it would have to transverse the ArrayList.
 *  7. The isEmpty method of MoveToFront is implemented with the method call isEmpty to check if the stack is empty or not. isEmpty of ArrayList is O(1) because it is a standard stack operation.
 *  8. The isEmpty method of MoveToFront is implemented with the method call isEmpty to check if the stack is empty or not. isEmpty of LinkedList is O(1) because it is a standard stack operation.
 *  9. The toSting method of MoveToFront is implemented with the method call toString to display all items in stack. toString of ArrayList is O(n) because it has to transverse though item to list them all. 
 *  10. The toSting method of MoveToFront is implemented with the method call toString to display all items in stack. toString of LinkedList is O(n) because it has to transverse though item to list them all.
 *************************************************************************/

import java.util.*;

public class MoveToFront<T> {
    //data feilds
    private LinkedList<T> move; //LinkedList that is being manipulated

    private LinkedList<Integer> reps; //Linked List to store the number of repetitions of each item in the list

    public MoveToFront(){ //constructor that initialized new LinkedLists
        move = new LinkedList<T>(); 
        reps = new LinkedList<Integer>(); 

    }

    //push adds an item to the stack 
    public void push(T item){ 
        int numReps = 0; //initializing count to 0
        if(move.contains(item)){  //checks to see if item is in the list
            
            int index = move.indexOf(item); //gets index of itwm 
            int num = reps.remove(index); //removes item from reps LinkedList 
            reps.addFirst(numReps + 1); //increments rep count 

            move.remove(item); 
        }

        else {
            move.addFirst(item); //add item
            reps.addFirst(1); //add to reps list 
        }
        
    }

    //pop removes and item added to the latest collection
    public void pop(T item){
        if(!move.isEmpty()){  //checks to make sure list is not empty
            int count = reps.removeFirst(); //
            if(count > 1){
                reps.addFirst(count - 1);  //decrease the repetition count and added it back to repetions list 
            }
        }
        move.removeLast();
    }

    //contains returns trie if a given item is in the collection, or false otherwise
    public boolean contains(T item){
        if(move.contains(item)){
            return true; 
        }
        else {
            return false; 
        }
    }
    
    //isEmpty returns triw if the collection is empty, or false otherwise
    public boolean isEmpty(){
        return move.isEmpty(); 
    }

    //toString displays all items in the stack
    @Override 
    public String toString(){
        return move.toString(); 
    }

    //Displays repetition for each item in the list 
    public void listRepetitions() {
        for (int i = 0; i < reps.size(); i++){
            System.out.print(reps.get(i) + " ");
        }
    }

}

//testMTF class is used to test MoveToFront class 
class testMTF{
    
    public static void main(String [] args){ 

        //creates an object of MoveToFront class
        MoveToFront<Integer> list = new MoveToFront<Integer>(); 

        //using push method to add elements to the list
        list.push(1);
        list.push(2);
        list.push(3);
        list.push(4);
        list.push(5);
        list.push(6);

        //using pop to remove 2 from the list 
        list.pop(2); 

        //using contains method to see if the number 1 is in the list 
        System.out.print("Is 3 in the list? ");
        System.out.println(list.contains(3)); 

        //using isEmpty to test if the list is empty
        System.out.print("Is the list empty? "); 
        System.out.println(list.isEmpty());         

        //Using to string to display items in list 
        System.out.print("Display of elements in the list: "); 
        System.out.println(list.toString()); 

        //List the number of repetions of numbers 
        System.out.print("Repetitions: "); 
        list.listRepetitions(); 
    
    

    }
}

