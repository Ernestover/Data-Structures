public class BST{
	//class fields 
	protected Node root; 
	private String result;
	private Node valholder; 
	private Node successor;
	
	public BST(){ //constructor 
		root = null;
		valholder = null;
		successor = null;
		
	}
	
	//Recursive traversal methods 
	private void inorderRecur(Node subroot){
		if (subroot == null){
			return;
		}
		
		inorderRecur(subroot.getLeft());
		result+=subroot.getData()+"";
		inorderRecur(subroot.getRight());
	}
	
	private void preorderRecur(Node subroot){
		if (subroot == null){
			return;
		}
		
		result+=subroot.getData()+"";
		preorderRecur(subroot.getLeft());
		preorderRecur(subroot.getRight());
	}
	
	private void postorderRecur(Node subroot){
		if (subroot == null){
			return;
		}
		
		postorderRecur(subroot.getLeft());
		postorderRecur(subroot.getRight());
		result+=subroot.getData();
	}
//--------------------------------------------------------------
	//recursive methods for insert and search
	private Node insertRecur(Node cur, int value){
		//if tree is empty
		if (cur == null){
			return new Node(value);
		}
		
		//go to left of tree
		if (cur.getData() > value){
			//recursive call
			cur.setLeft(insertRecur(cur.getLeft(), value));
		}
		
		//go to right of tree
		else if (value > cur.getData()){
			//recursive call
			cur.setRight(insertRecur(cur.getRight(), value));
		}
		
		return cur;
	}
	
	private Node searchRecur(Node cur, int value){
		//cur is equal to null
		if(cur == null){
			return cur; 
		}
		
		//value equals root 
		else if(cur.getData() == value){
			return cur; 
		}
		
		else if(cur.getData() > value){
			//recursive call
			cur = (searchRecur(cur.getLeft(), value));
		}
		
		else if (value > cur.getData()){
			//recursive call
			cur = (searchRecur(cur.getRight(), value));
		}
		
		return cur; 
	}
//--------------------------------------------------------------
	//recursive min max methods 
	private Node minRecur(Node cur){
		//base case if Node get left = null return Node
		if(cur.getLeft() == null){
			return cur;
		}
		//recursively go the far most left Node
		else{
			cur = minRecur(cur.getLeft());
		}
		return cur;
	}
	
	private Node maxRecur(Node cur){
		//base case if Node get right = null return Node
		if(cur.getRight() == null){
			return cur;
		}
		//recursively go to the far most right Node
		else{
			cur = maxRecur(cur.getRight());
		}
		return cur;
	}
//--------------------------------------------------------------
	//delete submethods 
	//-> successor
	public Node Successor(Node cur){ //finished
		//visit the right child of the Node
		return(minRecur(root.getRight()));
	}
	
	//-> handles case0
	private void Case0(Node cur, int value){//finished
		//if Node to delete is a leaf 
		
		if(cur.getData() > value){
			//checks to see if left child is equal to value or null
			if (cur.getLeft() == null){
				return;
			}
			
			//checks to see if Left child is equal to value 
			else if (cur.getLeft().getData() == value){
				valholder = cur.getLeft();
				if (valholder.getLeft() == null && valholder.getRight() == null){ 
					//if left child has no children set left child to null
					cur.setLeft(null);
				}
				
				//else break out
				else {return;}
			}
			
			//call the function again with left child
			else{
				
				Case0(cur.getLeft(), value);
				cur = cur.getLeft();
			}
		}
		
		else if(cur.getData() < value){
			//checks to see if right child is equal to value or null
			if (cur.getRight() == null){
				return;
			}
			
			//checks to see if Right child is equal to value 
			else if(cur.getRight().getData()== value){
				valholder = cur.getRight();
				if (valholder.getLeft() == null && valholder.getRight() == null){
					//if is set left child to null
					cur.setRight(null);
				}
				
				//else break out
				else {return;}
			}
			
			//call the function again with right child
			else{
				Case0(cur.getRight(), value);
				cur = cur.getRight();
			}
		}
		
	}
	
	//-> handles case1
	private void Case1(Node cur, int value){// not finished
		//if Node to delete has 1 child
		if (cur == null) {return;} //Base case empty tree 
		
		//if value smaller than root
		if(cur.getData() > value){
			//checks to see if left child is equal to value or null
			if (cur.getLeft() != null && cur.getLeft().getData() == value){
				valholder = cur.getLeft();
				//if node has two children break out
				if (valholder.getLeft() != null && valholder.getRight() != null){
					return;
				}
				
				//checks to see if Node has a left or right child
				else if(valholder.getLeft() == null && valholder.getRight() != null){
					//replace Node with it's right child
					cur.setLeft(valholder.getRight());
				}
				
				else if(valholder.getRight() == null && valholder.getLeft() != null){
					//replace Node with it's left child
					cur.setLeft(valholder.getLeft());
				}
				
				//recursive call
				else {Case1(cur.getLeft(), value);}
			}
		}
		
		//if value greater than root
		else if(cur.getData() < value){
			if (cur.getRight() != null && cur.getRight().getData() ==  value){
				valholder = cur.getRight();
				//if Node to delete has two children break out
				if(valholder.getLeft() != null && valholder.getRight() != null){
					return;
				}
				
				//checks to see if Node has a left or right child
				else if(valholder.getLeft() == null && valholder.getRight() != null){
					//replace Node with it's right child
					cur.setRight(valholder.getRight());
				}
				
				else if(valholder.getRight() == null && valholder.getLeft() != null){
					//replace Node with it's left child
					cur.setRight(valholder.getLeft());
				}
				
				//recursive call 
				else {Case1(cur.getRight(), value);}
			}
		}
	}
	
	//-> handles case2
	private void Case2(Node cur, int value){
		if(cur == null) {return;} //base case 
		
		//if value smaller than root
		if(cur.getData() > value){
			if(cur.getLeft() != null && cur.getLeft().getData() == value){
				valholder = cur.getLeft();
				//Node to delete has two children 
				successor = Successor(valholder);
				cur.setLeft(successor);
				
				//delete Successor Node 
				if (successor != null){
					//if successor Node has no child
					if(successor.getLeft() == null && successor.getRight() == null){
						//Case0(successor, successor.getData());
					}
				
					//if successor Node has a child
						//else if(Successor(valholder).getLeft() != null && Successor(valholder).getRight() == null
						//|| Successor(valholder).getLeft() == null && Successor(valholder).getRight() != null){
					else{
						//Case1(successor, successor.getData());
					}
				}
			}
			
			//recursive call
			else {Case2(cur.getLeft(), value);}
		}
		
		//if value larger than root
		else if(cur.getData() < value){
			if(cur.getRight() != null && cur.getRight().getData() == value){
				valholder = cur.getRight();
				//Node to delete has two children 
				successor = Successor(valholder);
				cur.setRight(successor);
				//delete Successor Node 
				if (successor != null){
					//if successor Node has no child
					if(successor.getLeft() == null && successor.getRight() == null){
						//Case0(successor, successor.getData());
				}
				
					//if successor Node has a child
					//else if(Successor(valholder).getLeft() != null && Successor(valholder).getRight() == null
						//|| Successor(valholder).getLeft() == null && Successor(valholder).getRight() != null){
					else{
						//Case1(Successor(valholder), Successor(valholder).getData());
					}
				}
			}
			
			//recursive call
			else {Case2(cur.getRight(), value);}
		}
	}
	
	
	
//------------------------------------------------------------------------------------------------
	//BST methods
	public void insert(int value){//finished
		//call to insertRecur method
		root = insertRecur(root, value);
		
	}
	
	public boolean search(int value){//finished
		valholder = (searchRecur(root, value));
		//Recur returns Node, if node is null value not in BST
		if(valholder == null){return false;}
		
		return true;
	}
	
	public void delete(int value){//not done
		//case 0 
		//if node has 0 children
		Case0(root, value);
		
		//case 1
		//if node has 1 child
		Case1(root, value);
		
		//Case 2 
		//if node has 2 children
		Case2(root, value);
	}
	
	public int min(){//finished
		//recursive call to get the farthest left node
		valholder = (minRecur(root));
		return(valholder.getData());
	}
	
	public int max(){//finished
		//recursive call to get the farthest right node
		valholder = (maxRecur(root));
		return(valholder.getData());
	}
	
	public String inorder(){//finished
		//if tree empty, return empty
		if(root==null){
			return "tree is empty";
		}
		//call recursive function to print string inorder
		result="";
		inorderRecur(root);
		return result;
	}
	
	public String preorder(){//finished
		//if tree empty, return empty
		if(root==null){
			return "tree is empty";
		}
		//call recursive function to print string preorder
		result="";
		preorderRecur(root);
		return result;
	}
	
	public String postorder(){//finished 
		//if tree empty, return empty
		if(root==null){
			return "";
		}
		//call recursive function to print string postorder
		result="";
		postorderRecur(root);
		return result;
	}
}
