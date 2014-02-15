class Solution {
public:
    int removeDuplicates(int A[], int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (n == 0) {
            return 0;
        }
        int new_len = 1;
        for (int i = 1; i < n; i++) {
            if (A[i] != A[new_len - 1]) {
                A[new_len++] = A[i];
            }
        }
        return new_len;
    }
};
