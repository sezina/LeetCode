public class Solution {
    StringBuffer sb;
    List<String> results;
    String phone;
    public List<String> letterCombinations(String digits) {
        results = new ArrayList<String>();
        sb = new StringBuffer();
        phone = digits;
        combination(0);
        return results;
    }
    
    public void combination(int index) {
        if (index == phone.length()) {
            results.add(sb.toString());
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            if (phone.charAt(index) != '7' && phone.charAt(index) != '9' && i == 3)
                continue;
            sb.append(getChar(phone.charAt(index) - '0', i));
            combination(index + 1);
            sb.setLength(sb.length() - 1);
        }
    }
    
    private char getChar(int c, int i) {
        if (c == 2) return (char)('a' + i);
        if (c == 3) return (char)('d' + i);
        if (c == 4) return (char)('g' + i);
        if (c == 5) return (char)('j' + i);
        if (c == 6) return (char)('m' + i);
        if (c == 7) return (char)('p' + i);
        if (c == 8) return (char)('t' + i);
        if (c == 9) return (char)('w' + i);
        return ' ';
    }
}