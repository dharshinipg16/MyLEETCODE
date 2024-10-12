class Solution:
    def findLongestWord(self, s: str, dictionary: List[str]) -> str:
        dictionary.sort(key=lambda x: (-len(x),x))

        for word in dictionary :
            i=0
            for char in s :
                if i<len(word) and char == word[i]:
                    i+=1
                if i == len(word):
                    break
            if i==len(word):
                return word
        return ""

        ''' sorts dic in large-> small len of word, iterates the s, matching the letters with that of the word in dictionary, if the word matches completely obviously it is the largest word possible, so just return that, else move to the next smaller words'''