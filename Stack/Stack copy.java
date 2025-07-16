/** Stack abstract data type */
public class Stack<T> {
  /** List objects to hold our stack items.
      Use List operations to implement the methods below */
	private List<T> list;
	
	public Stack() {
		// instantiate list here
		list = new List<T>();
	}

	// pushes new item to the top of the stack
	public void push(T value) {
		list.prepend(value);
	}

	// takes the topValue of the stack and deletes it + returns it 
	public T pop() {
		if (isEmpty()!=true){
			T topValue = list.getValueAt(0);
			list.deleteAt(0);
			return topValue;
		}
		
		else {return null;}
	}

	// seeing what is at the top of the stack
	public T peek() {
		if (isEmpty()!=true) {return list.getValueAt(0);}
		
		else {return null;}
	}
	
	// checking to see if stack is empty 
	public boolean isEmpty() {return (list.size()==0);}
	
		
	
}
