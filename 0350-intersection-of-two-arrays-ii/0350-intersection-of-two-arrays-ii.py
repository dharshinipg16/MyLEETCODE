class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        element_count_a = {}
        element_count_b = {}
        
        for num in nums1:
            element_count_a[num] = element_count_a.get(num, 0) + 1
        
        for num in nums2:
            element_count_b[num] = element_count_b.get(num, 0) + 1
        
        intersection = []
        for num in element_count_a:
            if num in element_count_b:
                min_occurrences = min(element_count_a[num], element_count_b[num])
                intersection.extend([num] * min_occurrences)
        
        return intersection
                