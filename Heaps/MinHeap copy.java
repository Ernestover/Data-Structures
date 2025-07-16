

public class MinHeap {
	private int[] heap; 
	private int lastin;
	
	//constructor 
	public MinHeap(){
		this.heap = new int[8]; //create a array with a size of 8
		this.lastin = 0; //stores the last inserted value's index 
	}
	
	private void minHeapifyUp(int cindex){
		// gets the parent index from the child
		int pindex = (int) Math.floor((cindex-1) / 2);
		
		//base case
		if (pindex == 0){
			//checks if parent is greater than child then returns
			if (heap[pindex] > heap[cindex]){
				//swap the values 
				int storeval = heap[pindex];
				heap[pindex] = heap[cindex];
				heap[cindex] = storeval;
			}
			return;
		}
		
		else {
			// if parent is greater than child
			if (heap[pindex] > heap[cindex]){
				//swap the values 
				int storeval = heap[pindex];
				heap[pindex] = heap[cindex];
				heap[cindex] = storeval;
			}
			
		}
		//recursive call
		minHeapifyUp(pindex);
	}
	
	private void minHeapifyDown(int pindex){
		
		//gets the left and right children from parent
		int lcindex = 2 * pindex + 1;
		int rcindex = 2 * pindex + 2;
		
		if (lcindex >= lastin || rcindex >= lastin){// reached the last inserted value
			return; 
		}
		
		//checks if parent is less the right child
		if (heap[pindex] > heap[lcindex]){
			//System.out.println("**********");
			//swap the values
			int storeval = heap[pindex];
			heap[pindex] = heap[lcindex];
			heap[lcindex] = storeval;
				
		}
		
		//checks if parent is less than right child
		if (heap[pindex] > heap[rcindex]){
			//System.out.println("**********");
			//swap the values
			int storeval = heap[pindex];
			heap[pindex] = heap[rcindex];
			heap[rcindex] = storeval;
		}
		
		//recursive call
		minHeapifyDown(lcindex);
		minHeapifyDown(rcindex);
	}
		
	public void insert(int key){
		heap[lastin] = key;
		//minHeapifyUp make sure maxHeap still inorder
		minHeapifyUp(lastin);
		
		//debugging
		// for (int j = 0; j < heap.length; j++) {
			// System.out.print(heap[j] + " ");
		// }
		// System.out.println();
		//increase last in
		lastin++;
	}
		
	public int findMin(){
		//checks to see if list is empty
		if (isEmpty()){
			return -1;
		}
		
		//else return min value 
		else{
			int index = 0;
			return heap[index];
		}
	}

	public int extractMin(){
		int index = 0;
		//storing min value
		int valholder = heap[index];
		//swapping values
		heap[index] = heap[lastin];
		heap[lastin] = 0;
		lastin--;
		
		//minHeapifyDown to preserve MinHeap properties
		minHeapifyDown(index);
		
		//debugging
		// for (int j = 0; j < heap.length; j++){
			// System.out.print(heap[j] + " ");
		// }
		// System.out.println();
		
		return valholder;
	}
	
	//is MinHeap empty
	public boolean isEmpty(){
		//iterate through heap
		boolean check = false;
		for(int i=1; i<heap.length; i++){
			if (heap[i] == 0){
				check = true;
			}
			
			else {check = false;}
		}
		
		return check;
	}
	
	
	
}