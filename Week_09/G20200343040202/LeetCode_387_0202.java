class Solution {

    public int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            int index = s.indexOf(s.charAt(i));
            if (s.lastIndexOf(s.charAt(i)) == index) {
                return i;
            }
        }
        return -1;
    }
//    public int firstUniqChar(String s) {
//
//        Map<Character,Integer> map = new HashMap<>();
//        for (int i=0;i<s.length();i++){
//            if (map.containsKey(s.charAt(i))){
//                int num = map.get(s.charAt(i)) + 1;
//                map.put(s.charAt(i),num);
//            }else {
//                map.put(s.charAt(i),1);
//            }
//        }
//
//        for (int i=0;i<s.length();i++){
//            if (map.get(s.charAt(i)) == 1){
//
//                return i;
//            }
//        }
//        return -1;
//    }
}