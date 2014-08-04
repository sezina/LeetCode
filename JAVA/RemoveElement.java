public class Solution {
    public int removeElement(int[] A, int elem) {
        int size = A.length;
        int removeCount = 0;
        for (int i = 0; i < size - removeCount; i++) {
            if (A[i] == elem) {
                int temp = A[i];
                A[i] = A[size - removeCount - 1];
                A[size - removeCount - 1] = temp;
                removeCount++;
                i--;
            }
        }
        return size - removeCount;
    }
}
