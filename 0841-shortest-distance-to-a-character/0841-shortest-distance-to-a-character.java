class Solution {
    public int[] shortestToChar(String s, char c) 
    {
        int[] result = new int[s.length()];
        List<Integer> cPositions = new ArrayList<>();

        int currPos = 0;

        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == c) cPositions.add(i);
        }

        int k = 0;
        for (int i = 0; i < s.length(); i++)
        {
        	if (currPos == cPositions.size())
            {
            	result[k++] = i - cPositions.get(currPos - 1);
            }
        	else
        	{
        		int p = cPositions.get(currPos);

                if (i == p) 
                {
                    result[k++] = 0;
                    currPos++;
                }
                else if (currPos == 0) result[k++] = p - i;
                else
                {
                    int p2 = cPositions.get(currPos - 1);
                    result[k++] = Math.min(i - p2, p - i);
                }    
        	}    
        }

        return result;
    }
}