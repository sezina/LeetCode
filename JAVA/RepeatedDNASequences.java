/**
 * 187
 *
 * @author sezina
 * @since 3/4/18
 */
public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i + 10 <= s.length(); i++) {
            String a = s.substring(i, i+10);
            if (!map.containsKey(a)) map.put(a, 0);
            map.put(a, map.get(a) + 1);
        }
        List<String> result = new ArrayList<String>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1)
                result.add(entry.getKey());
        }
        return result;
    }
}
