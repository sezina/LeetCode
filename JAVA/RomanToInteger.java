public class Solution {
    public int romanToInt(String s) {
        if (s == null || s.equals(""))
            return 0;
        int result = 0;
        Map<Character, Integer> romanIntMap = new HashMap<Character, Integer>();
        romanIntMap.put('M', 1000);
        romanIntMap.put('C', 100);
        romanIntMap.put('D', 500);
        romanIntMap.put('L', 50);
        romanIntMap.put('X', 10);
        romanIntMap.put('V', 5);
        romanIntMap.put('I', 1);
        result += romanIntMap.get(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (romanIntMap.get(s.charAt(i)) > romanIntMap.get(s.charAt(i - 1)))
                result = result - 2 * romanIntMap.get(s.charAt(i - 1)) + romanIntMap.get(s.charAt(i));
            else
                result += romanIntMap.get(s.charAt(i));
        }
        return result;
    }
}