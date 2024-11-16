import java.util.ArrayList;

public class AVLtree {

	public node root;
	private ArrayList<String> success = new ArrayList<String>();

	AVLtree() {}
	
	/*public void Insert (String Line) {
		insert(root,Line);
	}*/

	node Insert(node node, String dracula) {
	    if (node == null) { 
	        node = new node(dracula); 
	    } else if (dracula.compareTo(node.Line) < 0) { 
	        node.left = Insert(node.left, dracula);
	        
	        if (height(node.left) - height(node.right) == 2) { 
	            if (dracula.compareTo(node.left.Line) < 0) { 
	                node = rightRotate(node);  // rotate (left left case)
	                
	            } else {
	                node.left = leftRotate(node.left); // double rotate (left right case)
	                node = rightRotate(node); 
	                
	            }
	        }  
	    } else if (dracula.compareTo(node.Line) > 0) {  
	        node.right = Insert(node.right, dracula);  
	        
	        if (height(node.right) - height(node.left) == 2) { 
	            if (dracula.compareTo(node.right.Line) > 0) { 
	            	
	                node = leftRotate(node); // rotate (right right case)
	                
	            } else {  
	                node.right = rightRotate(node.right); // double rotate (right left case)
	                node = leftRotate(node);
	            } 
	        }
	    } else if (dracula.compareTo(node.Line) == 0) {
	        node.count += 1; // increment the count if the string is already present
	    }
	    
	    // update the height
	    node.height = 1 + max(height(node.left), height(node.right));

	    return node;
	}





	int height (node node) {
		if (node == null) {
			return 0;
		}else 
			return node.height;
	}
	int max (int a, int b) {
		return (a > b) ? a : b;
	}
	int getBalance (node node) {
		if (node == null) {
			return 0;
		}
		return height(node.right) - height(node.left);
	}
	node rightRotate(node y) {
		node x = y.left;
		
		y.left = x.right;
		x.right = y;
		
		
		y.height = max(height(y.left), height(y.right)) + 1;
		x.height = max(height(x.left), height(x.right)) + 1;

		return x;
	}
	node leftRotate(node x) {
		node y = x.right; // root (the highest node), points to the right

		x.right = y.left; //makes y.left (loction of t2) = to the highest node
		y.left = x; //makes the right of (location of y) = to the right node
		
		x.height = max(height(x.left), height(x.right)) + 1;
		y.height = max(height(y.left), height(y.right)) + 1;

		return y;
	}

	//search opperation just to find all the 1st characters
	public ArrayList<String> Search (char compare) {
		Search(compare, root);
		return success;
	}

	private void Search (char compare, node node) { //not sure if this works -update. I need compare it to te first char
		if (node != null) {
			char nodeChar = node.Line.charAt(0);
			if (compare == nodeChar) {
				success.add(node.Line + " " + node.count);
				Search(compare,node.left);
				Search(compare,node.right);
			} else {
				Search(compare,node.left);
				Search(compare,node.right);
			}
		}
	}
	void postOrder(node node) {
		if (node != null) {
			postOrder(node.left);
			postOrder(node.right);
			System.out.println(node.Line + " ");
		}
	}
}