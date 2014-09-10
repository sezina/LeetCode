public class Solution {
    public String simplifyPath(String path) {
        String[] segs = path.split("/");
        List<String> res = new ArrayList<String>();
        for (int i = 0; i < segs.length; i++) {
            if (segs[i].isEmpty() || segs[i].equals(".")) continue;
            if (segs[i].equals("..")) {
                if (!res.isEmpty()) res.remove(res.size() - 1);
            }
            else res.add(segs[i]);
        }
        StringBuffer sb = new StringBuffer();
        for (String s: res)
            sb.append("/").append(s);
        return sb.length() == 0 ? "/" : sb.toString();
    }
}