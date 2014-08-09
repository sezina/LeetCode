/**
 * bruce force
 */
public class Solution {
    public String intToRoman(int num) {
        String result = "";
        int[] bits = {0,0,0,0};
        int i = 0;
        while (num != 0) {
            bits[i++] = num % 10;
            num /= 10;
        }
        
        for (int j = 0; j < bits[3]; j++)
            result += 'M';
            
        if (bits[2] == 9)
            result += "CM";
        else if (bits[2] == 4)
            result += "CD";
        else if (bits[2] > 4) {
            result += 'D';
            bits[2] -= 5;
        }
        switch(bits[2]) {
            case 3: result += 'C';
            case 2: result += 'C';
            case 1: 
                result += 'C';
                break;
            default:
                break;
        }
        
        if (bits[1] == 9)
            result += "XC";
        else if (bits[1] == 4)
            result += "XL";
        else if (bits[1] > 4) {
            result += 'L';
            bits[1] -= 5;
        }
        switch(bits[1]) {
            case 3: result += 'X';
            case 2: result += 'X';
            case 1: 
                result += 'X';
                break;
            default:
                break;
        }
        
        if (bits[0] == 9)
            result += "IX";
        else if (bits[0] == 4)
            result += "IV";
        else if (bits[0] > 4) {
            result += 'V';
            bits[0] -= 5;
        }
        switch(bits[0]) {
            case 3: result += 'I';
            case 2: result += 'I';
            case 1: 
                result += 'I';
                break;
            default:
                break;
        }
        return result;
    }
}

/**
 * more readable
 */
public class Solution2 {
    public String intToRoman(int num) {
        String result = "";
        int[] digit = {0,0,0,0};
        int i = 0;
        while (num != 0) {
            digit[i++] = num % 10;
            num /= 10;
        }
        
        for (int j = 0; j < digit[3]; j++)
            result += 'M';
            
        result += digitConvert(digit[2], 'M', 'D', 'C');
        result += digitConvert(digit[1], 'C', 'L', 'X');
        result += digitConvert(digit[0], 'X', 'V', 'I');
        
        return result;
    }
    
    private static String digitConvert(int digit, char ten, char five, char base) {
        String result = "";
        if (digit == 9)
            result = (result + base) + ten;
        else if (digit == 4)
            result = (result + base) + five;
        else if (digit > 4) {
            result += five;
            digit -= 5;
        }
        if (digit < 4) {
            for (int i = 0; i < digit; i++)
                result += base;
        }
        return result;
    }
}
