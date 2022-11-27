package compund_words;

public class Trie {
	Node root;
	public Trie() {
		root = new Node(' ');
	}
	public void insert(String word) {
		Node temp = root;
		for(int i =0; i < word.length(); i++) {
			char c = word.charAt(i);
			if(temp.children[c-'a'] == null) {
				temp.children[c-'a'] = new Node(c);
			}
			temp = temp.children[c-'a'];
		}
		temp.isWord = true;
	}
	
	public boolean search(String word) {
		Node temp = root;
		for(int i=0; i<word.length(); i++) {
			char c = word.charAt(i);
			if(temp.children[c-'a']==null) {
				return false;
			}
			temp=temp.children[c-'a'];
		}
		if(temp.isWord==true && temp!=null) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
