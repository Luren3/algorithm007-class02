class Solution {
    public int[][] imageSmoother(int[][] M) {
        int r = M.length;
        int c = M[0].length;
        int[][] res = new int[r][c];
        for(int i = 0; i < r;i++){
            for(int j = 0;j < c;j++){
                res[i][j] = add(M,i,j,r,c);
            }
        }
        return res;
    }

    private int add(int[][] M,int i,int j,int m ,int n){
        int res = 0;
        int num = 0;
        if(i-1>=0){
            res += M[i-1][j];
            num++;
        }
        if(i+1 < m){
            res += M[i+1][j];
            num++;
        }
        if(j-1 >= 0){
            res += M[i][j-1];
            num++;
        }
        if(j+1 < n){
            res += M[i][j+1];
            num++;
        }

        if(i+1 < m &&j-1 >=0){
            res += M[i+1][j-1];
            num++;
        }
        if(i-1>=0&&j-1>=0){
            res += M[i-1][j-1];
            num++;
        }
        if(i-1>=0&&j+1<n){
            res += M[i-1][j+1];
            num++;
        }

        if(j+1 < n && i+1 < m){
            res += M[i+1][j+1];
            num++;
        }
        res += M[i][j];
        num++;
        res /=num;
        return res;
    }
}