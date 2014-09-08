public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        if (matrix.length == 0 || matrix[0].length == 0) return res;
        int br = 0, bc = 0, 
            er = matrix.length - 1, ec = matrix[0].length - 1,
            i = 0, j = 0;
        while (br < er && bc < ec) {
            i = bc;
            j = br;
            while (i < ec) res.add(matrix[j][i++]);
            while (j < er) res.add(matrix[j++][i]);
            while (i > bc) res.add(matrix[j][i--]);
            while (j > br) res.add(matrix[j--][i]);
            br++;
            bc++;
            er--;
            ec--;
        }
        
        if (bc == ec && br <= er)
            while (br <= er) res.add(matrix[br++][bc]);
        else if (bc <= ec && br == er)
            while (bc <= ec) res.add(matrix[br][bc++]);
        return res;
    }
}