class Solution(object):
    def customSortString(self, order, s):
        order_count = {char: 0 for char in order}
        for char in s:
            if char in order_count:
                order_count[char] += 1
    
        sorted_s = ''
        for char in order:
            sorted_s += char * order_count[char]
    
        for char in s:
            if char not in order:
                sorted_s += char

        return sorted_s
