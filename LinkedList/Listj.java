/** Linked List implementation of our List abstract data type in java*/
public class Listj<T>{
	// put all fields from ListAsLinkedList class here
	public Node<T> head;
	private Node<T> tail;
	private int count;
	
	public Listj(){ //constructor
		head = tail = null;
		count = 0;
	}
  
	// LINKED LIST
	public void append(T data){ 
		Node<T> node = new Node<>(data); 
		
		if (count==0){
			head = node;
		}
		
		else {
			tail.setNext(node);
		}
		
		tail = node; 
		count++;  
	}
	
	public void prepend(T data){ 
		Node<T> node = new Node<>(data);
		
		if (count==0){
			head = node;
		}
	
		else {
			node.setNext(head);
		}
		
		head = tail;
		head = node;
		count++;
	}
	
	public void deleteAt(int position){ 
		Node<T> cur = head;
		Node<T> after = cur.getNext();
		
		if (position<count){
		
			if (position==0){
				head = cur.getNext();
				cur.setNext(null);
				count--;
			}
		
			for(int i=0; position>i; i++){
				if (i==position-1){
					Node<T> prev = cur;
					cur = cur.getNext();
					after = cur.getNext();
			
					cur.setNext(null);
					prev.setNext(after);
					count--;
				}
				
				//iterate to the next node
				cur = cur.getNext();
			}
		
		}
	}
	
	public int size(){return count;} 
	
	public T getValueAt(int position){ 
		Node<T> cur = head;
		if (position < count){
			T value = cur.getData();
			for(int i=0; position>=i; i++){
				value = cur.getData();
				cur=cur.getNext();
			}
			return value;
		} 
		
		return null;
			
	}
	
	public int positionOf(T value){ 
		Node<T> cur = head;
		
		for(int position=0; position<count; position++){
			if(cur.getData()==value){
				return position;
			}
			
			else{
				cur=cur.getNext();
			}
		}
		
		return -1;
		
	}
  
}

/** A linked list node for our linked list */
class Node<T> {
	private T data;
	private Node<T> next;
  
	//constructor 
	public Node(T data){
		this.data = data;
		this.next = null;
	}
	
	//accessors
	public T getData(){
		return data;
	}
	public Node<T> getNext(){
		return next;
	}
	
	//mutators 
	public void setNext(Node<T> next){
		this.next=next;
	}
  
}
