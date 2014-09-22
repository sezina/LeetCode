public class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<List<String>>();
        if (s.isEmpty()) return res;
        Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
        List<String> list = new ArrayList<String>();
        list.add(s.substring(0,1));
        map.put(0, list);
        for (int i = 1; i < s.length(); i++) {
            list = new ArrayList<String>();
            list.add(s.substring(i, i + 1));
            map.put(i, list);
            int low = i - 1, high = i;
            while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
                map.get(low).add(s.substring(low, high + 1));
                low--;
                high++;
            }
            low = i - 1;
            high = i + 1;
            while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
                map.get(low).add(s.substring(low, high + 1));
                low--;
                high++;
            }
        }
        partitionHelper(s, map, new Stack<String>(), 0);
        return res;
    }
    
    private void partitionHelper(String s, Map<Integer, List<String>> map, Stack<String> ans, int index) {
        if (index == s.length()) {
            res.add(new ArrayList<String>(ans));
            return;
        }
        
        for (int i = 0; i < map.get(index).size(); i++) {
            String temp = map.get(index).get(i);
            ans.add(temp);
            partitionHelper(s, map, ans, index + temp.length());
            ans.pop();
        }
    }
}