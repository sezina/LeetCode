/**
 * 168
 *
 * @author sezina
 * @since 3/3/18
 */
public class ExcelSheetColumnTitle {

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int a = n % 26;
            if (a == 0) {
                sb.append('Z');
                n = (n - 1) / 26;
            } else {
                sb.append((char) (a + 'A' - 1));
                n /= 26;
            }
        }
        return sb.reverse().toString();
    }
}
