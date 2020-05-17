class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] arr1 = new int[256];
        int[] arr2 = new int[256];
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        for (int i = 0; i < s1.length; i++) {
            char c1 = s1[i];
            char c2 = t1[i];
            if (arr1[c1] != arr2[c2]) {
                return false;
            }
            arr1[c1] = i + 1;
            arr2[c2] = i + 1;
        }
        return true;
    }
}