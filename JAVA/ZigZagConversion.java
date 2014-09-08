// naive solution
public class Solution {
    public String convert(String s, int nRows) {
        StringBuffer[] sbs = new StringBuffer[nRows];
        for (int i = 0; i < nRows; i++)
            sbs[i] = new StringBuffer();
        int i = 0, n = s.length();
        while (i < n) {
            for (int j = 0; j < nRows && i < n; j++, i++)
                sbs[j].append(s.charAt(i));
            for (int j = nRows - 2; j > 0 && i < n; j--, i++)
                sbs[j].append(s.charAt(i));
        }
        for (i = 1; i < nRows; i++)
            sbs[0].append(sbs[i]);
        return sbs[0].toString();
    }
}