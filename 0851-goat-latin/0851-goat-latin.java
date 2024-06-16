import java.util.StringJoiner;

class Solution {
    public String toGoatLatin(final String sentence) {
        final String[] words = sentence.split("\\s+");
        final StringJoiner sj = new StringJoiner(" ");

        int n = 1;

        for(final String word : words) {
            final char first = word.charAt(0), firstLower = Character.toLowerCase(first);
            final StringBuilder sb = new StringBuilder();

            if(firstLower == 'a' || firstLower == 'e' || firstLower == 'i' || firstLower == 'o' || firstLower == 'u') {
                sb.append(word);
            } else {
                sb.append(word.substring(1));
                sb.append(first);
            }

            sb.append("ma");

            for(int i = 0; i < n; ++i)
                sb.append('a');

            sj.add(sb.toString());

            n++;
        }

        return sj.toString();
    }
}