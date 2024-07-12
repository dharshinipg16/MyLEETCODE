class Solution {
    class TrieNode {
        int counter;
        int wordend;
        TrieNode[] children;

        public TrieNode() {
            counter = 1;
            wordend = 0;
            children = new TrieNode[26];
            for (int i=0;i<26;i++) {
                children[i]=null;
            }
        }
    }

    public void insert(TrieNode root,String s) {
        TrieNode curr = root;

        for (char c:s.toCharArray()) {
            if (curr.children[(int)(c-'a')]==null) {
                TrieNode newnode = new TrieNode();
                curr.children[(int)(c-'a')] = newnode; //auto counter init to 1
            }else {
                //already present - inc counter
                curr.children[(int)(c-'a')].counter+=1;
            }
            curr = curr.children[(int)(c-'a')];
        }
        curr.wordend=1;
    }

    public int svalcounter(TrieNode root, String s) {
        TrieNode curr = root;
        int sum = 0;
        for (char c:s.toCharArray()) {
            if (curr.children[(int)(c-'a')]==null) {
                return 0;
            }else {
                sum+= curr.children[(int)(c-'a')].counter;
            }
            curr = curr.children[(int)(c-'a')];
        }
        return (curr.wordend==1)?sum:0;
    }

    public int[] sumPrefixScores(String[] words) {
        TrieNode root = new TrieNode();
        for (String s:words) {
            insert (root,s);
        }
        int[] arr = new int[words.length];
        for (int i=0;i<words.length;i++) {
            arr[i] = svalcounter(root,words[i]);
        }
        return arr;

    }
}