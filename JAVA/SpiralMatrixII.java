public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int br = 0, bc = 0, er = n - 1, ec = n - 1, i, j, num = 1;
        while (br < er && bc < er) {
            i = bc;
            j = br;
            while (i < ec) res[j][i++] = num++;
            while (j < er) res[j++][i] = num++;
            while (i > bc) res[j][i--] = num++;
            while (j > br) res[j--][i] = num++;
            br++;
            bc++;
            er--;
            ec--;
        }
        if (br == er && bc <= ec)
            while (bc <= ec) res[br][bc++] = num++;
        else if (br <= er && bc == ec)
            while (br <= er) res[br++][bc] = num++;
        return res;
    }
}