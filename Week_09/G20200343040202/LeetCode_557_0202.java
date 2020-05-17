class Solution {
    public String reverseWords(String s) {
        String[] arr = s.trim().split("\\s+");

        StringBuilder builder = new StringBuilder();
        for (String str:arr) {
            builder.append(reverseString(str)).append(" ");
        }
        return builder.toString().trim();
    }

    public String reverseString(String s) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length / 2; i++) {
            char tmp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = tmp;
        }
        return new String(chars);
    }
}