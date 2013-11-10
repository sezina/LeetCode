class Solution {
public:
    int removeElement(int A[], int n, int elem) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int del_count = 0;
        for (int i = 0; i < n; ++i)
        {
        	if (A[i] == elem)
        	{
        		del_count++;
        	} else {
        		A[i - del_count] = A[i];
        	}
        }
        return n - del_count;
    }
};