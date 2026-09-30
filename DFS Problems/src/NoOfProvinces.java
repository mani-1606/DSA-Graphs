
public class NoOfProvinces {
    //LC= 547 using dfs
    public int helper(int[][] adj) {
        int count = 0;
        int n = adj.length;
        boolean[] visted = new boolean[n];
        for(int i=0; i<n; i++){
            if(!visted[i]){
                //bfs(i, adj, visted);
                dfs(i, adj, visted);
                count++;
            }
        }
        return count;
    }

    private void dfs(int i, int[][] adj, boolean[] visted) {
        visted[i]= true;
        int n = adj.length;
        for(int j=0; j<n; j++){
            if(adj[i][j]==1 && !visted[j]){
                dfs(j, adj, visted);
            }
        }

    }
    public static void main(String[] args){
        int[][] adj = {{1,1,0}, {1,1,0}, {0,0,1}};
        NoOfProvinces obj = new NoOfProvinces();
        System.out.println(obj.helper(adj));
    }
}
