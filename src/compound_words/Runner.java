package compund_words;
import java.util.*;
import java.io.*;
public class Runner {
	
	Trie t = new Trie();
	TreeMap<Integer, ArrayList<String>> m = new TreeMap<>();
	
	public static void main(String[] Args)throws Exception {
		String fileName = "input_1.txt";
		Scanner input = new Scanner(new File (fileName));
		String curr;
		Runner obj = new Runner();
		while(input.hasNext()) {
			curr = input.next();
			obj.t.insert(curr);
			
			int len = curr.length();
			ArrayList<String> ls = obj.m.get(len);
			if(ls == null) {
				ls = new ArrayList<String>();
				ls.add(curr);
				obj.m.put(len, ls);
			}
			else {
				ls.add(curr);
			}
		}
		long start = System.currentTimeMillis();
		obj.findCompound();
		long end = System.currentTimeMillis();
		System.out.println("RunTime : "+ (end-start)+"ms");
	}
	
	public void findCompound() {
		Iterator<Integer> itr = m.descendingKeySet().iterator();
		int countCompound =0;
		while(itr.hasNext()) {
			ArrayList<String> wordList = m.get(itr.next());
			for(String word: wordList) {
				if(isCompound(word, true)) {
					countCompound++;
					if(countCompound<3)
						System.out.println(word);
					else
						break;
				}
			}
		}
	}
	
	public boolean isCompound(String word, boolean b) {
		
		if(t.search(word)==true && b ==false)
			return true;
		
		for(int i=0; i<word.length(); i++) {
			String left = word.substring(0, i);
			String right = word.substring(i);
			if(t.search(left)==true && isCompound(right, false)==true)
				return true;
		}
		return false;
		
	}
}
