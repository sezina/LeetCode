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

public class Solution2 {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int last = s.lastIndexOf(" ");
        return s.length() - last - 1;
    }
}

public class Solution3 {
    public int lengthOfLastWord(String s) {
        String str[] = s.split(" ");
        int n = str.length;
        return (n == 0)? 0 : str[n - 1].length();
    }
}
