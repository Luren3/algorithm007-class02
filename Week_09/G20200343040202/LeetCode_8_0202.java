class Solution {
    public static int myAtoi(String str) {
        str = str.trim();

        if (str.length() == 0) return 0;

        if (str.equals("+") || str.equals("-")) return 0;

        String string = "" + str.charAt(0);

        if ((!(string.equals("+") || string.equals("-") || isNumber(str.charAt(0))))) {
            return 0;
        }
        StringBuilder builder = new StringBuilder();
        builder.append(string);
        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            if (isNumber(c)) {
                builder.append(c);
            } else {
                break;
            }
        }
        if (builder.toString().equals("+") || builder.toString().equals("-")) return 0;
        Double num = Double.parseDouble(builder.toString());
        if (num > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if (num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return num.intValue();
    }

    private static boolean isNumber(char c) {
        String number = "0123456789";
        if (number.indexOf(c) == -1) {
            return false;
        }
        return true;
    }
}