public class Solution {
    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        StringBuilder sb = new StringBuilder();
        int carry = 0, temp, j = a.length() - 1;
        for (int i = b.length() - 1; i >= 0; i--, j--) {
            temp = (a.charAt(j) - '0') + (b.charAt(i) - '0') + carry;
            carry = temp / 2;
            sb.append(temp % 2);
        }
        for (; j >= 0; j--) {
            temp = (a.charAt(j) - '0') + carry;
            carry = temp / 2;
            sb.append(temp % 2);
        }
        if (carry == 1) sb.append(1);
        return sb.reverse().toString();
    }
}

public class Solution {
    public String addBinary(String a, String b) {
        int aLen = a.length(), bLen = b.length();
        int maxLen = Math.max(aLen, bLen);
        StringBuilder sb = new StringBuilder();
        int carry = 0, temp, i = 0;
        while (i < maxLen) {
            int p = i < aLen ? (a.charAt(aLen - i - 1) - '0') : 0;
            int q = i < bLen ? (b.charAt(bLen - i - 1) - '0') : 0;
            temp = p + q + carry;
            carry = temp / 2;
            sb.append(temp % 2);
            i++;
        }
        if (carry == 1) sb.append(1);
        return sb.reverse().toString();
    }
}