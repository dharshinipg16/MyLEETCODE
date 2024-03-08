class Solution {
    fun maxFrequencyElements(numbers: IntArray): Int {
        val frequencyMap = mutableMapOf<Int, Int>()
        for (number in numbers) {
            frequencyMap[number] = frequencyMap.getOrDefault(number, 0) + 1
        }

        var totalCount = 0
        var maxFrequency = Int.MIN_VALUE
        for (frequency in frequencyMap.values) {
            maxFrequency = maxOf(maxFrequency, frequency)
        }

        for (frequency in frequencyMap.values) {
            if (frequency == maxFrequency) {
                totalCount += maxFrequency
            }
        }
        return totalCount
    }
}
//Dgp
