public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null) return 0;
        String[] segs = s.trim().split(" ");
        if (segs.length == 0) return 0;
        String lastWord = segs[segs.length - 1];
        for (int i = 0; i < lastWord.length(); i++) {
            char c = lastWord.charAt(i);
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')))
                return 0;
        }
        return lastWord.length();
    }
}