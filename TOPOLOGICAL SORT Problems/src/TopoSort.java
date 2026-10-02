import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
//Gfg Problem
public class TopoSort {
   public ArrayList<Integer> topo(int n, int[][] edjes){
       ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
       for(int i=0; i<n; i++){
           adj.add(new ArrayList<>());
       }
       int[] indeg = new int[n];
       for(int i=0; i< edjes.length; i++){
           int u = edjes[i][0];
           int v = edjes[i][1];
           adj.get(u).add(v);
           indeg[v]++;
       }
       Queue<Integer> q = new LinkedList<>();
       for(int i=0; i<n; i++){
           if(indeg[i]==0) q.add(i);
       }
       ArrayList<Integer> ans = new ArrayList<>();
       while(q.size()>0){
           int front = q.remove();
           ans.add(front);
           for(int ele : adj.get(front)){
               if(indeg[ele]!=0){
                   indeg[ele]--;
                   if(indeg[ele]==0) q.add(ele);
               }
           }
       }
       return ans;
   }
   public static void main(String[] args){
       int[][] edges = {{3,0},{1,0},{2,0}};
       int n = 4;
       TopoSort tp = new TopoSort();
       System.out.println(tp.topo(n,edges));
   }
}
