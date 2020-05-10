class Solution {

    public static int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < Integer.SIZE; i++) {
            result <<= 1;
            result |= n & 1;
            n >>>= 1;
        }
        return result;
    }
}