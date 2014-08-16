public class Solution {
    public int candy(int[] ratings) {
        int result = 0;
        int candy = 1;
        int[] candys = new int[ratings.length];
        if (ratings.length != 0) {
            result += candy;
            candys[0] = candy;
        }
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                ++candy;
            } else if (ratings[i] <= ratings[i - 1]) {
                if (candy == 1) {
                    int count = 0;
                    candys[i] = candy;
                    for (int j = i; j > 0 && ratings[j - 1] > ratings[j] && candys[j] + 1 > candys[j - 1]; j--, count++) {
                        candys[j - 1]++;
                    }
                    result += count;
                } else {
                    candy = 1;
                }
            }
            candys[i] = candy;
            result += candy;
        }
        return result;
    }
}

public class Solution2 {
    public int candy(int[] ratings) {
        int[] candy = new int[ ratings.length ];
        candy[0] = 1;
        for(int i = 1; i < ratings.length; i++){
            candy[i] = ratings[i] > ratings[i-1] ? candy[i-1]+1 : 1;
        }
        int totalCandy = candy[ratings.length-1];
        for(int i = ratings.length-2; i >= 0; i--){
            candy[i] = (ratings[i] > ratings[i+1] && candy[i+1]+1 > candy[i]) ? candy[i+1]+1 : candy[i];
            totalCandy += candy[i];
        }
        return totalCandy;
    }
}