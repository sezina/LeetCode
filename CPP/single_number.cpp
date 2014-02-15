class Solution {
public:
    int singleNumber(int A[], int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        for (int i = 1; i < n; i++) {
            A[0] ^= A[i];
        }
        return A[0];
    }
};
