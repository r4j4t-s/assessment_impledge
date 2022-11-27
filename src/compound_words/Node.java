package compund_words;

public class Node {
	public char c;
	public boolean isWord;
	public Node[] children;
	public Node(char c) {
		this.c = c;
		isWord = false;
		children = new Node[26];
	}
}
