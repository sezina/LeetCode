/**
 * 171
 *
 * @author sezina
 * @since 3/3/18
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i) - 'A' + 1;
            res = res * 26 + a;
        }
        return res;
    }
}
