import java.util.*;
class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder s = new StringBuilder();
        
        int index=word.length();
        for (int i=0;i<word.length();i++) {
            if (word.charAt(i)==ch){
                s.append(word.charAt(i));
                index = i;
                break;
            }
            else {
                s.append(word.charAt(i));
            }
        }
        if (index==word.length()) {
            return word;
        }
        s = s.reverse();
        for (int i=index+1;i<word.length();i++){
            s.append(word.charAt(i));
        }
        return s.toString();
        
        
    }
}