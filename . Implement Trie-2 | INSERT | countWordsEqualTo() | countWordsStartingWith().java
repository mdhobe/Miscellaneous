import java.util.* ;
import java.io.*; 

class Node{
    Node[] links = new Node[26];
    int ew = 0, cp = 0;

    boolean containsKey(char ch){
        return (links[ch - 'a'] != null);
    }

    void put(char ch, Node n){
         links[ch-'a'] = n;
    }

    Node get(char ch){
        return links[ch-'a'];
    }

    void increaseEndWord(){
        ew++;
    }

    void increaseCountPrefix(){
        cp++;
    }

    void endWord(){
        ew--;
    }

    void reduceCountPrefix(){
        cp--;
    }

    int getEndWord(){
        return ew;
    }

    int getCountPrefix(){
        return cp;
    }
}
public class Trie {
    Node root;
    public Trie() {
        // Write your code here.
        root = new Node();
    }

    public void insert(String word) {
        // Write your code here.
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
            node.increaseCountPrefix();
        }
        node.increaseEndWord();
    }

    public int countWordsEqualTo(String word) {
        // Write your code here.
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                return 0;
            }
            node = node.get(word.charAt(i));
        }
        return node.getEndWord();
    }

    public int countWordsStartingWith(String word) {
        // Write your code here.
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                return 0;
            }
            node = node.get(word.charAt(i));
        }
        return node.getCountPrefix();
    }

    public void erase(String word) {
        // Write your code here.
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(node.containsKey(word.charAt(i))){
                node = node.get(word.charAt(i));
                node.reduceCountPrefix();
            }else return;
        }
        node.endWord();
    }

}
