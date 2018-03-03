/**
 * 165
 *
 * @author sezina
 * @since 3/3/18
 */
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] v1parts = version1.split("\\.");
        String[] v2parts = version2.split("\\.");
        if (v1parts.length < v2parts.length)
            return -compare(v2parts, v1parts, 0);
        return compare(v1parts, v2parts, 0);
    }

    public int compare(String[] version1, String[] version2, int index) {
        if (index >= version1.length && index >= version2.length)
            return 0;
        else if (index >= version2.length) {
            int c = toNum(version1[index]);
            if (c != 0) return 1;
            return compare(version1, version2, index + 1);
        }
        int a = toNum(version1[index]);
        int b = toNum(version2[index]);
        if (a > b) return 1;
        else if (a < b) return -1;
        return compare(version1, version2, index + 1);
    }

    public int toNum(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res * 10 + (s.charAt(i) - '0');
        }
        return res;
    }
}
