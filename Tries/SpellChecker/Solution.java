public class Solution {
    public int[] solve(String[] A, String[] B) {
        Trie tri = new Trie();
        for(String word : A){
            tri.insert(word);
        }
        int [] ans = new int[B.length];
        int indx=0;
        for(String word : B){
            if(tri.search(word))
               ans[indx++]=1;
            else
               ans[indx++]=0;
        }
        return ans;
    }
}   

class Trie{
    Node root;
    Trie(){
        root = new Node();
    }
    class Node {
        char data;
        Node child[];
        boolean eow;
        Node(char ch){
            data = ch;
            child = new Node[26];
            eow = false;
        }
        Node(){
            data='*';
            child = new Node[26];
            eow = false;
        }
    }
    void insert(String word){
        Node curr = root; int l = word.length();
        for(int i=0;i<l;i++){
            char ch = word.charAt(i);
            if(curr.child[ch-'a'] == null){
                curr.child[ch-'a'] = new Node(ch);
            }
            curr = curr.child[ch-'a'];
        }
        curr.eow = true;
    }
    boolean search(String word){
        Node curr =root;int l = word.length();
        for(int i=0;i<l;i++){
            char ch = word.charAt(i);
            if(curr.child[ch-'a'] == null){
                return false;
            }
             curr = curr.child[ch-'a'];
        }
        return curr.eow;
    }
}