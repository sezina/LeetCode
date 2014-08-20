// using split method
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

// treat string as a char array
public class Solution2 {
    public String reverseWords(String s) {
        if (s == null) return "";
        List<String> words = new ArrayList<String>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                words.add(sb.toString());
                sb = new StringBuffer();
            }
            else
                sb.append(s.charAt(i));
        }
        words.add(sb.toString());
        sb = new StringBuffer();
        for (int i = words.size() - 1; i >= 0; i--) {
            if (!words.get(i).isEmpty())
                sb.append(words.get(i)).append(' ');
        }
        return sb.toString().trim();
    }
}