//	libraries we will use for input/output
import java.util.*;
import java.io.*;

public class Trie {

	//	for the trie we need a root (an initially empty Node)
	Node root = new Node();
	
	//	this method adds a word in the trie
	public void addWord(String s, int i, Node curr){
		//	if we are past the words last index it is mission accomplished 
		if(i>=s.length()){
			//	so we return 
			return;
		}
		//	we get the character for the corresponding index
		char t = s.charAt(i);
		//	if the character already exists as a son of the current node
		if(curr.has[t-'a']){
			//	we just keep doing the same for the next index and for the son - Node
			this.addWord(s,i+1,curr.sons[t-'a']);
		}
		else{
			//	otherwise we add the new Node firstly
			curr.has[t-'a'] = true;
			curr.sons[t-'a'] = new Node();
			//	and then we do the same thing (see line 21)
			this.addWord(s,i+1,curr.sons[t-'a']);
		}
	}
	
	//	this is the same method as before
	//	it just assumes that the current Node is the root of the Trie
	//	and the index is 0 (i.e the first character of the Word)
	public void addWord(String s){
		int i = 0;
		Node curr = this.root;
		if(i>=s.length()){
			return;
		}
		char t = s.charAt(i);
		if(curr.has[t-'a']){
			this.addWord(s,i+1,curr.sons[t-'a']);
		}
		else{
			curr.has[t-'a'] = true;
			curr.sons[t-'a'] = new Node();
			this.addWord(s,i+1,curr.sons[t-'a']);
		}
	}
	
	//	this method is used to check if a word exists in our vocabulary
	public boolean searchWord(String s, int i, Node curr){
		//	if we are past the last index then we can say that the word does exist
		//	and thus we return true
		if(i>=s.length()){
			return true;
		}
		//	otherwise it means we keep searching and we get the corresponding
		//	character for this index
		char t = s.charAt(i);
		//	we check if the character exists as a son of the current Node
		//	thus the path can continue
		if(curr.has[t-'a']){
			//	so we search further to the next index to the corresponding son - Node
			return searchWord(s,i+1,curr.sons[t-'a']);
		}
		else{//it the letter thought does not exists as a son then neither the word
			return false;
		}
	}
	
	//	this method is the same as the one before only it is used for the first call
	//	so it assumes as current node the root of the trie
	//	and as the character's index 0 (the first character).
	public boolean searchWord(String s){
		int i = 0;
		Node curr = this.root;
		if(i>=s.length()){
			return true;
		}
		char t = s.charAt(i);		
		if(curr.has[t-'a']){
			return searchWord(s,i+1,curr.sons[t-'a']);
		}
		else{
			return false;
		}
	}
	
	//	we put the exception for the file so the program will run
	public static void main(String[] args) throws FileNotFoundException{
		//	we declare the trie (the vocabulary we will use)
		Trie mytrie = new Trie();
		//	the file that contains our words
		File file = new File("english.txt");
		//	a scanner to read from the file
		Scanner stdin = new Scanner(file);
		//	and a string s to help us read the data
		String s;
		//	so we move on until all the lines (words) are gone
		while(stdin.hasNextLine()){
			//	we get the line
			s = stdin.nextLine();
			//	and we add the word in the trie
			mytrie.addWord(s);
		}
		//	these lines are used to test that the trie does work
		System.out.println(mytrie.searchWord("fries")); // should give true
		System.out.println(mytrie.searchWord("aarp"));	// should give false (no such word)
		//	we add the word that doesn't exist
		mytrie.addWord("aarp");
		//	and when we search for it, it
		System.out.println(mytrie.searchWord("aarp")); // should give true
		//	at the end we close the file
		stdin.close();
	}

}
