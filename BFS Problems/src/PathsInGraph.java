import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//LC=1971
public class PathsInGraph {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        if(start==end) return true;
        List<List<Integer>> adj = new ArrayList<>();
        boolean[] vis = new boolean[n];
        for(int i=0;i<n; i++){
            List<Integer> l1 = new ArrayList<>();
            adj.add(l1);
        }
        for(int i=0; i<edges.length; i++){
            int a = edges[i][0], b = edges[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        bfs(start, adj, vis, end);
        vis[start]=true;
        return vis[end];
    }
    public static void bfs(int start, List<List<Integer>> adj, boolean[] vis, int end){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(q.size()>0){
            int front = q.remove();
            for(int ele : adj.get(front)){
                if(!vis[ele]){
                    q.add(ele);
                    vis[ele]=true;
                }
                if(start==end) return;
            }
        }
    }
    public static void main(String[] args){
        int[][] edges = {{0,1},{0,2},{3,5},{5,4},{4,3}};
        int n = 6;
        int start = 0;
        int end = 5;
        PathsInGraph pg = new PathsInGraph();
        System.out.println(pg.validPath(n,edges,start,end));

    }
}
