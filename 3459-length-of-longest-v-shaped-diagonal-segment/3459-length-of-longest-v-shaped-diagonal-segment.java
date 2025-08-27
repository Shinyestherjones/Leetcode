class Solution {
   
    private final int[] dx = {1, 1, -1, -1};
    private final int[] dy = {1, -1, -1, 1};
    private int m, n;
    private int[][] grid;
    private int[][][][][] mem; // mem[i][j][turned][valIdx][dir]

    public int lenOfVDiagonal(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;

        mem = new int[m][n][2][3][4];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int t = 0; t < 2; t++) {
                    for (int v = 0; v < 3; v++) {
                        for (int d = 0; d < 4; d++) {
                            mem[i][j][t][v][d] = -1;
                        }
                    }
                }
            }
        }

        int ans = 0;
      
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    for (int dir = 0; dir < 4; dir++) {
                        ans = Math.max(ans, dfs(i, j, dir, 0, 0));  
                    }
                }
            }
        }
        return ans;
    }

    private int valFromIdx(int valIdx) {
        if (valIdx == 0) return 1;
        if (valIdx == 1) return 2;
        return 0;
    }

    
    private int nextValIdx(int valIdx) {
        if (valIdx == 0) return 1; // 1 -> 2
        if (valIdx == 1) return 2; // 2 -> 0
        return 1;                   // 0 -> 2
    }

    
    private int dfs(int i, int j, int dir, int turned, int valIdx) {
        if (i < 0 || i >= m || j < 0 || j >= n) return 0;
        if (grid[i][j] != valFromIdx(valIdx)) return 0;

        int cached = mem[i][j][turned][valIdx][dir];
        if (cached != -1) return cached;

        int res = 1; 
        int nextIdx = nextValIdx(valIdx);

       
        int ni = i + dx[dir], nj = j + dy[dir];
        int extendSame = dfs(ni, nj, dir, turned, nextIdx);
        res = Math.max(res, 1 + extendSame);

        if (turned == 0) {
            int ndir = (dir + 1) % 4;
            int ni2 = i + dx[ndir], nj2 = j + dy[ndir];
            int extendTurn = dfs(ni2, nj2, ndir, 1, nextIdx);
            res = Math.max(res, 1 + extendTurn);
        }

        mem[i][j][turned][valIdx][dir] = res;
        return res;
    }
}
