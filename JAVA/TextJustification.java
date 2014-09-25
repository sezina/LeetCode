public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        List<String> result = new ArrayList<String>();
        if (words.length == 0) return result;
        StringBuffer sb = new StringBuffer();
        int charCount = 0, beginIndex = 0;
        for (int i = 0; i < words.length; i++) {
            if (charCount + words[i].length() + (i - beginIndex) > L) {
                if (i - beginIndex == 1) {
                    sb.append(words[beginIndex]);
                    for (int j = 0; j < L - words[beginIndex].length(); j++)
                        sb.append(' ');
                } else {
                    int space = (L - charCount) / (i - beginIndex - 1);
                    int remain = L - charCount - space * (i - beginIndex - 1);
                    for (int j = beginIndex; j < i - 1; j++) {
                        sb.append(words[j]);
                        for (int k = 0; k < space; k++)
                            sb.append(' ');
                        if (remain > 0) {
                            sb.append(' ');
                            remain--;
                        }
                    }
                    sb.append(words[i - 1]);
                }
                result.add(sb.toString());
                
                sb.setLength(0);
                charCount = 0;
                beginIndex = i;
            }
            charCount += words[i].length();
        }
        
        // handle last line
        if (charCount != 0 || beginIndex != words.length) {
            if (words.length - beginIndex == 1) {
                sb.append(words[beginIndex]);
                for (int j = 0; j < L - words[beginIndex].length(); j++)
                    sb.append(' ');
            } else {
                for (int j = beginIndex; j < words.length - 1; j++)
                    sb.append(words[j]).append(' ');
                sb.append(words[words.length - 1]);
                int remain = L - sb.length();
                while (remain > 0) {
                    sb.append(' ');
                    remain--;
                }
            }
            result.add(sb.toString());
        }
        return result;
    }
}