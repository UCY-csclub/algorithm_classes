public class Node {
	
	//	array so we know this node has sons
	boolean[] has = new boolean[26];
	//	array that is created (gets memory) along with the construction
	//	of the Node and keeps this node's sons
	Node[] sons;
	
	//	the constructor that just binds memory for array sons
	public Node(){
		this.sons = new Node[26];
	}
	
	//	this method is used to add a son to this node
	public void add(char t){
		//	we just make the boolean value of the corresponding character true
		has[(int)(t)-'a'] = true;
		//	an create a node for him
		sons[(int)(t)-'a'] = new Node();
	}
	
	//	this method returns the Node that contains the i-th son of this Node
	private Node getSon(int i){
		return sons[i];
	}

	//	this method does the same as the one before using character t to find the index
	private Node getSon(char t){
		return sons[(int)(t)-'a'];
	}
	
	
}