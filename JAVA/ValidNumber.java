// a hack
public class Solution {
    public boolean isNumber(String s) {
        if (s == null) return false;
        s = s.trim();
        if (s.isEmpty() || s.indexOf(' ') >-1) return false;
        int len = s.length();
        if (s.charAt(len -1) != '.' && !Character.isDigit(s.charAt(len -1))) return false;
        try {
            double d = Double.parseDouble(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

// O(n)
public class Solution {
    public boolean isNumber(String s) {
        if (s == null) return false;
        s = s.trim();
        if (s.isEmpty() || s.indexOf(' ') >-1) return false;
        int i = 0;
        char[] sc = s.toCharArray();
        if (sc[i] == '-' || sc[i] == '+') i++;
        boolean flag = Character.isDigit(sc[i]);
        while (i < sc.length && Character.isDigit(sc[i])) i++;
        
        if (i < sc.length && sc[i] == '.') {
            i++;
            if (i < sc.length)
                flag = Character.isDigit(sc[i]) || flag;
            while (i < sc.length && Character.isDigit(sc[i])) i++;
        }
        if (!flag) return false;
        
        if (i < sc.length && sc[i] == 'e') {
            i++;
            if (i < sc.length && (sc[i] == '-' || sc[i] == '+')) i++;
            if (i == sc.length || !Character.isDigit(sc[i])) return false;
            while (i < sc.length && Character.isDigit(sc[i])) i++;
        }
        
        return i == sc.length;
    }
}