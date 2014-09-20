public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        if (s == null || s.length() < 4 || s.length() > 12) return res;
        restoreHelper(res, s, 0, new StringBuffer(), 0);
        return res;
    }
    
    private void restoreHelper(List<String> res, String s, int preLen, StringBuffer sb, int segCount) {
        if (segCount == 4) {
            if (preLen == s.length())
                res.add(sb.toString().substring(0, sb.length() - 1));
            return;
        }
        
        for (int i = 1; i <= 3; i++) {
            int sum = 0;
            for (int j = 0; j < i && j + preLen < s.length(); j++)
                sum = sum * 10 + (s.charAt(j + preLen) - '0');
            if ((i == 2 && sum < 10) || (i == 3 && sum < 100)) continue;
            if (i == 3 && sum > 255) continue;
            sb.append(sum).append(".");
            restoreHelper(res, s, preLen + i, sb, segCount + 1);
            sb.setLength(sb.length() - 1 - i);
        }
    }
}