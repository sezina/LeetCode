class Solution {
public:
    int reverse(int x)
    {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test c
        long long result = 0;
        while (x) {
            result = result * 10 + (x % 10);
            x /= 10;
        }
        
        return result;
    }
};
