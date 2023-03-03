
import java.util.ArrayList;

class Node {
	Node[] links;

	Node(){
		links = new Node[26];
	}

	boolean containsKey(char ch){
		return (links[ch - 'a'] != null);
	}

	void put(char ch, Node n){
		links[ch - 'a'] = n;
	}

	Node get(char ch){
		return links[ch - 'a'];
	}
}

class Trie {
	Node root ;
	int total = 0;
	Trie(){
		root = new Node();
	}

	void insert(String word, int index){
		Node node = root;
		for(int i=index;i<word.length();i++){
			if(!node.containsKey(word.charAt(i))){
				node.put(word.charAt(i), new Node());
				total ++ ;
			}
			node = node.get(word.charAt(i));
		}
	}
}
public class Solution 
{

	public static int countDistinctSubstrings(String s) 
	{
		//	  Write your code here.
		Trie trie = new Trie();

		for(int i=0;i<s.length();i++){
			trie.insert(s, i);
		}

		return trie.total + 1;
	}
}
