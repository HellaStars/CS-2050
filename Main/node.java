public class node {
	public int height, count;  //for better secutiry you should not make these public. But it makes it easier
	public node left,right;
	String Line = "";
	
	node(String dracula){
		this.Line = dracula;
		this.height = 1;
		this.count = 1;
		left = null;
		right = null;
		
	}
}
