import java.util.ArrayList;

class Solution {
    public int compareVersion(String version1, String version2) {
        StringBuilder s = new StringBuilder();
        ArrayList<Integer> part1 = new ArrayList<>();
        ArrayList<Integer> part2 = new ArrayList<>();
        
        for (int i = 0; i < version1.length(); i++) {
            if (version1.charAt(i) == '.') {
                String num = s.toString();
                int number = Integer.parseInt(num);
                part1.add(number); 
                s = new StringBuilder();                
            } else {
                s.append(version1.charAt(i));
            }
        }
        String num = s.toString();
        int number = Integer.parseInt(num);
        part1.add(number);
        
        s = new StringBuilder();
        for (int i = 0; i < version2.length(); i++) {
            if (version2.charAt(i) == '.') {
                num = s.toString();
                number = Integer.parseInt(num);
                part2.add(number); 
                s = new StringBuilder();                
            } else {
                s.append(version2.charAt(i));
            }
        }
        num = s.toString();
        number = Integer.parseInt(num);
        part2.add(number);
        
        for (int i:part1) {
            System.out.print(i+" ");
        }
        System.out.println();
        for (int i:part2) {
            System.out.print(i+" ");
        }
        System.out.println();
        
        int index=(part1.size()<part2.size())?part1.size() : part2.size();
        for (int i=0;i<index;i++) {
            if (part1.get(i)>part2.get(i)){
                return 1;
            }
            else if (part1.get(i)<part2.get(i)) {
                return -1;
            }
        }
        
        if (part1.size()>index) {
            for (int i=index;i<part1.size();i++) {
                if (part1.get(i)>0) return 1;
            }
            return 0;
        }
        if (part2.size()>index) {
            for (int i=index;i<part2.size();i++) {
                if (part2.get(i)>0) return -1;
            }
            return 0;
        }
        
        // You need to return an integer value here.
        return 0; // Placeholder value, you need to implement the comparison logic.
    }
}
