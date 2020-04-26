class Solution {

    public int minMutation(String start, String end, String[] bank) {

        boolean[] visited = new boolean[bank.length];
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        //深度
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            res++;
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                for (int j = 0; j < bank.length; j++) {
                    //已经访问过的元素跳过,树中不存在重复节点
                    if (visited[j]) {
                        continue;
                    }
                    //孩子节点只能改变一个字符转换为s,不满足则跳过
                    String string = bank[j];
                    if (!progress(poll, string)) {
                        continue;
                    }
                    //如果节点s等于endWord,接龙完成
                    if (string.equals(end)) {
                        return res;
                    }
                    visited[j] = true;
                    queue.add(string);
                }
            }
        }
        return 0;
    }
    private boolean progress(String poll, String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (poll.charAt(i) != s.charAt(i)) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return count == 1;
    }
}