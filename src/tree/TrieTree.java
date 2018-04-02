package tree;

import java.util.HashMap;

public class TrieTree {
    public static class TrieNode{
        public int path;
        public int end;
        public HashMap<Character, TrieNode> nexts;

        public TrieNode() {
            path = 0;
            end = 0;
            nexts = new HashMap<>();
        }
    }

    private TrieNode root;

    public TrieTree() {
        root = new TrieNode();
    }

    public void insert(String word){
        if (word == null){
            return;
        }
        char[] chs = word.toCharArray();
        TrieNode node = root;
        for (char ch : chs){
            if (!node.nexts.containsKey(ch)){
                node.nexts.put(ch, new TrieNode());
            }
            node = node.nexts.get(ch);
            node.path++;
        }
        node.end++;
    }

    public int search(String word){
        if (word == null){
            return 0;
        }
        char[] chs = word.toCharArray();
        TrieNode node = root;
        for (char ch : chs){
            if (!node.nexts.containsKey(ch)){
                return 0;
            }
            node = node.nexts.get(ch);
        }
        return node.end;
    }

    public void delete(String word) {
        if (search(word) != 0) {
            char[] chs = word.toCharArray();
            TrieNode node = root;
            for (char ch : chs) {
                node = node.nexts.get(ch);
                if (--node.path == 0) {
                    node.nexts.remove(ch);
                    return;
                }
            }
            node.end--;
        }
    }

    public int prefixNum(String pre){
        if (pre == null){
            return 0;
        }
        char[] chs = pre.toCharArray();
        TrieNode node = root;
        for (char ch : chs){
            if (!node.nexts.containsKey(ch)){
                return 0;
            }
            node = node.nexts.get(ch);
        }
        return node.path;
    }

    public static void main(String[] args) {
        TrieTree trieTree = new TrieTree();
        trieTree.insert("请问");
        trieTree.insert("请问您");
        System.out.println(trieTree.prefixNum("请问"));
        trieTree.insert("请问您怎么了");
        System.out.println(trieTree.search("请问您怎么了"));
        trieTree.delete("请问");
        System.out.println(trieTree.search("请问"));
        System.out.println(trieTree.prefixNum("请问"));
        trieTree.insert("请便把");
        System.out.println(trieTree.prefixNum("请"));
    }
}
