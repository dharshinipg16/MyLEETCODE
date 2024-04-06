import java.util.ArrayList;
import java.util.Iterator;

class Solution {
    public String minRemoveToMakeValid(String s) {
        int count = 0;
        char[] chararray = s.toCharArray();
        ArrayList<Character> charlist = new ArrayList<>();
        for (char i : chararray) {
            charlist.add(i);
        }
        Iterator<Character> iterator = charlist.iterator();
        while (iterator.hasNext()) {
            char ch = iterator.next();
            if (Character.isLowerCase(ch) == false) {
                if (ch == '(') {
                    count++;
                } else if (ch == ')') {
                    count--;
                }
                if (count < 0) {
                    iterator.remove(); // Remove the element using iterator
                    count = 0; // Reset count to avoid continuous removal
                }
            }
        }
        
        for (int rev=charlist.size()-1 ; rev>=0 ; rev--) {
            if (count==0){
                break;
            }
            if (charlist.get(rev)=='('){
                charlist.remove(rev);
                count--;
            }
            
        }
        chararray = new char[charlist.size()];
        for (int i = 0; i < charlist.size(); i++) {
            chararray[i] = charlist.get(i);
        }
        String ans = new String(chararray);
        return ans;
    }
}
