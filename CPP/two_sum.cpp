class Solution {
    public:
        vector<int> twoSum(vector<int> &numbers, int target) {
            // IMPORTANT: Please reset any member data you declared, as
            // the same Solution instance will be reused for each test case.
            vector<int> result;
            for (int i = 0; i < numbers.size(); i++) {
                for (int j = i + 1; numbers[i] <= target && j < numbers.size(); j++) {
                    if (numbers[j] <= target && numbers[i] + numbers[j] == target) {
                        result.push_back(i + 1);
                        result.push_back(j + 1);
                        break;
                    }
                }
            }
            return result;
        }
};
