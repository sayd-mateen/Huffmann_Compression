/* Name: Sayd Mateen */ 


import java.util.*;
import java.io.*;


public class Huffmann{
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);		
		String text = console.nextLine();
		text = text.toUpperCase();
		NodeList list = new NodeList();
      	list.add(text.charAt(0));
      	// This for loop will get each character and add it in the list
		for (int i = 1; i < text.length(); i++) {
			if (list.search(text.charAt(i))) {	
			}else{
				list.add(text.charAt(i));
			}	
		}
		// This toString will output the chars and their frequency 
		System.out.println(list.toString());
      	boolean first = true;
      	// This while loop will create a tree by removing smallest one at a time 
      	while(list.listCount > 1){
         	Node temp = new Node(null);
         	Node getRight;
         	Node getLeft;
         	if(first){ 
            	getRight =  list.removeSmallest(list);
            	getLeft = list.removeSmallest(list);
            	first = false;
         	}else{
            	getLeft =  list.removeSmallest(list);
            	getRight = list.removeSmallest(list);
         	}   
         	temp.right = getRight;
         	temp.left = getLeft;
         	temp.count = getRight.count + getLeft.count;
         	list.addNode(temp);
      	}
      	Node holder = list.removeSmallest(list);
      	String str = "";
      	String finalStr = ""; 
      	// we need a new nodelist to hold the chars and their binary values so we can easily loop and get the binary values from the nodes 
      	NodeList key = new NodeList();
      	// This while loop will go through the list of nodes in the tree and calcualte the binary values for each char
      	while(holder.left != null || holder.right != null){
         	holder.left.binary = str + "0";
         	holder.right.binary = str + "1";
         	System.out.println(holder.left.data + " " + holder.left.binary);
         	Node add = new Node(holder.left.data);
         	add.binary = holder.left.binary;
         	key.addNode(add);
         	if(holder.right.data != null){
            	System.out.println(holder.right.data + " " + holder.right.binary);
            	add = new Node(holder.right.data);
            	add.binary = holder.right.binary;
            	key.addNode(add);
         	}
         	holder = holder.right;
         	str = str + "1";
      	}
      	// This for loop will output the binary values for each char in the string 
      	for (int i = 0; i < text.length(); i++) {
		   System.out.print(key.getBinary(text.charAt(i)));
		}
    }
}	
  
//Node class will create a new node with the following attributes for the tree and linked list 
class Node {
    Node next = null;
    String binary = "";
    Object data = null;
    int count; 
    Node left = null;
	Node right = null;
    public Node getNext() {
        return next;
    }
    public void setNext(Node nextValue) {
        next = nextValue;
        }             
        // Node constructor
    public Node(Object value) {
        next = null;
        data = value;
        count = 1;
    }
}

// This node list will help create a liked list of nodes 
class NodeList {
    Node head;
    int listCount;
 	//constructor for the node list
    public NodeList() {
        
        head = new Node(null);
        listCount = 0;
    }
    // adds the node to the list
    public void add(Object data)
    // appends the specified element to the end of this list.
    {
        Node temp = new Node(data);
        Node current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(temp);
        listCount++;
    }
    // add node to the list
    public void addNode(Node temp){
         Node current = head;
         while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(temp);
        listCount++;
    }
    // removes smallest node 
    public Node removeSmallest(NodeList list)
    { 
        Node current = head;
        current = current.getNext();
        int count = 1;
        int minCount = count;
        Node min = current;
        while (current.getNext() != null){
           current = current.getNext();
           count++;
           if(min.count > current.count){
              min = current;  
              minCount = count;
           }
        }
        list.remove(minCount);
        return min;
    }
    // removes specificed node 
    public void remove(int index)
    {
        Node current = head;
        for (int i = 1; i < index; i++) {
            current = current.getNext();
        }
        current.setNext(current.getNext().getNext());
        listCount--; 
    }

    // returns binary of char that is sent in
    public String getBinary(char c){
         Node current = head;
         while (current.getNext() != null) {
         	current = current.getNext();
        	if((char)current.data == c) {
        		return current.binary;
         	}
      	}
      	return "";
    }
    // searches list for a char
    public boolean search(char c){
    	Node current = head;
        while (current.getNext() != null) {
        current = current.getNext();
        	if((char)current.data == c) {
        		current.count= current.count + 1;
        		return true;
         	}
        }
        return false;
    }
 	// returns string of the list contents 
    public String toString() {
        Node current = head.getNext();
        String output = "";
        while (current != null) {
            output += "(" + (char)current.data + " " + current.binary+ " )";
            current = current.getNext();
        }
        return output;
    }
}
