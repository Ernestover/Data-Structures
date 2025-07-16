public class MaxHeap {
	private int[] heap;
	private int lastin; 
	
	public MaxHeap(){
		this.heap = new int[8]; //creates an array with a size of 8
		this.lastin = 0; //stores the last inserted value's index 
	}
	
	private void maxHeapifyUp(int cindex){
		// gets the parent index from the child
		int pindex = (int) Math.floor((cindex-1) / 2);
		
		//base case
		if (pindex == 0){
			//checks if parent is less than child then returns
			if (heap[pindex] < heap[cindex]){
				//swap the values 
				int storeval = heap[pindex];
				heap[pindex] = heap[cindex];
				heap[cindex] = storeval;
			}
			return;
		}
		
		else {
			// if parent is less than child
			if (heap[pindex] < heap[cindex]){
				//swap the values 
				int storeval = heap[pindex];
				heap[pindex] = heap[cindex];
				heap[cindex] = storeval;
			}
			
		}
		//recursive call
		maxHeapifyUp(pindex);
		
	}
	
	private void maxHeapifyDown(int pindex){
		//gets the left and right children from parent
		int lcindex = 2 * pindex + 1;
		int rcindex = 2 * pindex + 2;
		
		if (lcindex >= lastin || rcindex >= lastin){// reached the last inserted value
			return; 
		}
		
		//checks if parent is less the right child
		if (heap[pindex] < heap[lcindex]){
			//System.out.println("**********");
			//swap the values
			int storeval = heap[pindex];
			heap[pindex] = heap[lcindex];
			heap[lcindex] = storeval;
				
		}
		
		//checks if parent is less than right child
		if (heap[pindex] < heap[rcindex]){
			//System.out.println("**********");
			//swap the values
			int storeval = heap[pindex];
			heap[pindex] = heap[rcindex];
			heap[rcindex] = storeval;
		}
		
		//recursive call
		maxHeapifyDown(lcindex);
		maxHeapifyDown(rcindex);
		
		
	}
	
	public void insert(int key){
		heap[lastin] = key;
		//maxHeapifyUp make sure maxHeap still inorder
		maxHeapifyUp(lastin);
		//increase last in
		lastin++;
		
		
		
		//debugging
		//for (int j = 0; j < heap.length; j++) {
			//System.out.print(heap[j] + " ");
		//}
		//System.out.println();
	}
	
	public int findMax(){
		if (isEmpty()){
			return -1;
		}
		else {
			int index = 0;
			return heap[index];
		}
		
	}
	
	public int extractMax(){
		int index = 0;
		//storing max value
		int valholder = heap[index];
		//swapping values
		heap[index] = heap[lastin];
		heap[lastin] = valholder;
		// way of deleting the max value 
		heap[lastin] = 0;
		
		
		
		// maxHeapifyDown makes sure maxHeap still inorder
		maxHeapifyDown(index);
		lastin--;
		
		//debugging
		//for (int j = 0; j < heap.length; j++){
			//System.out.print(heap[j] + " ");
		//}
		
		return valholder;
	}
	
	public boolean isEmpty(){
		//iterate through heap to see if any value is not equal to zero
		boolean check = false;
		for(int i=0; i<heap.length; i++){
			if (heap[i] == 0){
				check = true;
			}
			
			else {return false;}
		}
		
		return check;
	}
	
}