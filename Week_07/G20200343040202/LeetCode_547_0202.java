class Solution {

    public int find(int parent[], int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }
    public void union(int parent[], int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        if (xset != yset)
            parent[xset] = yset;
    }
    public int findCircleNum(int[][] M) {
        int[] parent = new int[M.length];
        Arrays.fill(parent, -1);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1 && i != j) {
                    union(parent, i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1)
                count++;
        }
        return count;
    }

    // public int findCircleNum(int[][] M) {
    //     int[] visited = new int[M.length];
    //     int count = 0;
    //     for (int i = 0; i < M.length; i++) {
    //         if (visited[i] == 0) {
    //             findCircleNumDfs(M, visited, i);
    //             count++;
    //         }
    //     }
    //     return count;
    // }
    // private void findCircleNumDfs(int[][] M, int[] visited, int i) {
    //     for (int j = 0; j < M.length; j++) {
    //         if (M[i][j] == 1 && visited[j] == 0) {
    //             visited[j] = 1;
    //             findCircleNumDfs(M, visited, j);
    //         }
    //     }
    // }
}