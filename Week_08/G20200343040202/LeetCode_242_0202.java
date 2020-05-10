class Solution {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] chars1 = s.toCharArray();
        Arrays.sort(chars1);
        char[] chars2 = t.toCharArray();
        Arrays.sort(chars2);

        if (!String.valueOf(chars1).equals(String.valueOf(chars2))) {
            return false;
        }
        return true;
    }
}