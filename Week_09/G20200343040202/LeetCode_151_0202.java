class Solution {

    public String reverseWords(String s) {
        String[] arr = s.trim().split("\\s+");

        StringBuilder builder = new StringBuilder();

        for (int i = arr.length - 1; i >= 0; i--) {
            builder.append(arr[i]).append(" ");
        }
        return builder.toString().trim();
    }
}