/** Queue abstract data type */
public class Queue<T> {
  /** List objects to hold our queue items.
      Use List operations to implement the methods below */
	private List<T> list;
	private Stack<T> stack;
  
	public Queue() {
		// instantiate list here
		list = new List<T>();
		stack = new Stack<T>();
	}
  
	public void enqueue(T value) {
		list.append(value);
	}
  
	// removes the item at the front of the queue
	public T dequeue() {
		if(isEmpty()!=true) {
			T frontValue = list.getValueAt(0);
			list.deleteAt(0);
			return frontValue;
		}
		
		else {return null;}
	}

	// returns what is at the front of queue
	public T front() {
		if(isEmpty()!=true) {return list.getValueAt(0);}
		
		else {return null;}
	}

	// checks if queue is empty 
	public boolean isEmpty() {return (list.size()==0);}
	
	
	// bonus
	public void reverse(){
			stack.push(dequeue());
	}
}
