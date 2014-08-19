public class Solution {
    public String reverseWords(String s) {
        if (s == null) return "";
        String[] segs = s.trim().split(" ");
        if (segs.length == 0) return "";
        StringBuffer sb = new StringBuffer("");
        for (int i = segs.length - 1; i > 0; i--) {
            if (!segs[i].trim().isEmpty())
                sb.append(segs[i]).append(" ");
        }
        sb.append(segs[0]);
        return sb.toString();
    }
}