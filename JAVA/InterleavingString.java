// recursive
public class Solution {
    Set<String> visited;
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3 == null || (s1 == null && s2 == null)) return false;
        if ((s1 == null && s2.equals(s3)) || (s2 == null && s1.equals(s3))) return true;
        if (s1.length() + s2.length() != s3.length()) return false;
        String temp = new String(s1);
        temp = temp.concat(s2);
        char[] tempc = temp.toCharArray();
        char[] s3c = s3.toCharArray();
        Arrays.sort(tempc);
        Arrays.sort(s3c);
        if (!Arrays.equals(tempc, s3c)) return false;
        visited = new HashSet<String>();
        return helper(s1, 0, s2, 0, s3, 0);
    }
    
    private boolean helper(String s1, int si, String s2, int sj, String s3, int sk) {
        String s = (("" + si) + sj) + sk;
        if (visited.contains(s)) return false;
        if (si == s1.length())
            return s2.substring(sj).equals(s3.substring(sk));
        if (sj == s2.length())
            return s1.substring(si).equals(s3.substring(sk));
        if ((s1.charAt(si) == s3.charAt(sk) && helper(s1, si + 1, s2, sj, s3, sk + 1)) ||
            (s2.charAt(sj) == s3.charAt(sk) && helper(s1, si, s2, sj + 1, s3, sk + 1)))
            return true;
        visited.add(s);
        return false;
    }
}