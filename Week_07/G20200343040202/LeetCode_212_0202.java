class Solution {

    public List<String> findWords(char[][] board, String[] words) {
        List<String> list = new ArrayList<>();
        for (String word : words) {
            if (exist(board, word) && !list.contains(word)) {
                list.add(word);
            }
        }
        return list;
    }

    private boolean exist(char[][] board, String word) {
        if (word.length() == 0 || board.length == 0) {
            return false;
        }

        boolean[][] flag = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (find(board, word, 0, i, j, flag)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean find(char[][] board, String word, int index, int i, int j, boolean[][] flag) {
        if (index == word.length()) {
            return true;
        }
        boolean result = false;
        if (i >= 0 && i < board.length && j >= 0 && j < board[i].length && !flag[i][j] && word.charAt(index) == board[i][j]) {
            flag[i][j] = true;
            index += 1;
            result = find(board, word, index, i + 1, j, flag) || find(board, word, index, i - 1, j, flag) ||
                    find(board, word, index, i, j + 1, flag) || find(board, word, index, i, j - 1, flag);
            if (result == false) {
                index -= 1;
                flag[i][j] = false;
            }
        }
        return result;
    }
}