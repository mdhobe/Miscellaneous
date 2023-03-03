import java.util.* ;
import java.io.*; 

class Node{
  Node[] links = new Node[26];
  boolean flag = false;

  public Node(){

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

  void setEnd(){
    flag = true;
  }

  boolean getEnd(){
    return flag;
  }
}

class Trie{
  Node root;
  public Trie(){
    root = new Node();
  }

  void insert(String words){
    Node node = root;
    for(int i=0;i<words.length();i++){
      if(!node.containsKey(words.charAt(i))){
        node.put(words.charAt(i), new Node());
      }
      node = node.get(words.charAt(i));
    }
    node.setEnd();
  }

  boolean checkIfPrefixExists(String words){
    Node node = root;
    for(int i=0;i<words.length();i++){
      if(node.containsKey(words.charAt(i))){
        node = node.get(words.charAt(i));
        if(!node.getEnd()) return false;
      } else return false;
    }
    return true;
  }

}
class Solution {

  public static String completeString(int n, String[] a) {
    // Write your code here.
    Trie trie = new Trie();

    for(String words : a){
      trie.insert(words);
    }

    StringBuilder ans = new StringBuilder();

    for(String words : a){
      if(trie.checkIfPrefixExists(words)){
        if(words.length() > ans.length()){
          ans = new StringBuilder(words);
        } else if(words.length() == ans.length() && words.compareTo(ans.toString()) < 0) {
          ans = new StringBuilder(words);
        }
      }
    }

    if(ans.length() == 0) return "None";
    return ans.toString();
  }
}
