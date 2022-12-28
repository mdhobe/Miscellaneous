class Pair{
    int x, y;
    Pair(int i, int j){
        x=i;
        y=j;
    }
}
class Solution {
    ArrayList<Pair> nodes = new ArrayList<>();
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        for(int i=0;i<m;i++){
            if(board[i][0] == 'O'){
                dfs(i, 0, m, n, board);
            }
            if(board[i][n-1] == 'O'){
                dfs(i, n-1, m, n, board);
            }
        }
        for(int i=0;i<n;i++){
            if(board[0][i] == 'O'){
                dfs(0, i, m, n, board);
            }
            if(board[m-1][i] == 'O'){
                dfs(m-1, i, m, n, board);
            }
        }
        System.out.println(nodes);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                board[i][j] = 'X';
            }
        }
        for(Pair p : nodes){
            board[p.x][p.y] = 'O';
        }
    }
    public void dfs(int x, int y, int m, int n, char[][] board){
        board[x][y] = 'X';
        nodes.add(new Pair(x,y));
        if(x > 0 && board[x-1][y] == 'O') dfs(x-1,y,m,n,board);
        if(y > 0 && board[x][y-1] == 'O') dfs(x,y-1,m,n,board);
        if(x < m-1 && board[x+1][y] == 'O') dfs(x+1,y,m,n,board);
        if(y < n-1 && board[x][y+1] == 'O') dfs(x,y+1,m,n,board);
    }
}
