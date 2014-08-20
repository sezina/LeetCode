public class Solution {
    public List<Integer> getRow(int rowIndex) {
        Integer[] result = new Integer[rowIndex + 1];
        result[0] = 1;
        for (int i = 2; i <= rowIndex; i++) {
            if (i % 2 == 0)
                result[i / 2] = result[i / 2 - 1] * 2;
            else
                result[i / 2] = result[i / 2] + result[i / 2 - 1];
            for (int j = i / 2 - 1; j >= 2; j--)
                result[j] = result[j] + result[j - 1];
            result[1] = i;
        }
        int j = rowIndex;
        for (int i = 0; i < j; i++, j--)
            result[j] = result[i];
        return Arrays.asList(result);
    }
}