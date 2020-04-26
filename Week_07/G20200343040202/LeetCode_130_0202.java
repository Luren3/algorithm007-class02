class Solution {

    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean isEdge = i == 0 || j == 0 || i == board.length - 1 || j == board[i].length - 1;
                if (isEdge && board[i][j] == 'O') {
                    solveDfs(board, i, j);
                }
            }
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j]=board[i][j]=='1'?'O':'X';
            }
        }
    }
    private void solveDfs(char[][] board,int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == 'X' || board[i][j] == '1') {
            return;
        }
        board[i][j] = '1';
        solveDfs(board, i - 1, j);
        solveDfs(board, i + 1, j);
        solveDfs(board, i, j - 1);
        solveDfs(board, i, j + 1);
    }
}