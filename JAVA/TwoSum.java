public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int index1 = 0, index2 = 0;
        int size = numbers.length;
        for (int i = 0; i < size && index2 == 0; i++) {
            for (int j = i + 1; j < size; j++) {
                if (numbers[i] + numbers[j] == target) {
                    index1 = i + 1;
                    index2 = j + 1;
                    break;
                }
            }
        }
        int[] result = {index1, index2};
        return result;
    }
}