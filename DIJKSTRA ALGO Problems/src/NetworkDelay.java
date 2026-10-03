import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
//Lc = 743
public class NetworkDelay {
    public class Pair implements Comparable<Pair>{
        int node;
        int time;
        Pair(int node, int time){
              this.node=node;
              this.time=time;
        }
        public int compareTo(Pair p){
            if(this.time==p.time) return this.node-p.node;
            return this.time-p.time;
        }
    }
    public int networkDelayTime(int[][] times, int n, int src) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i=0; i<=n; i++) adj.add(new ArrayList<Pair>());
        for(int i=0; i<times.length; i++){
            int u = times[i][0];
            int v = times[i][1];
            int time = times[i][2];
            adj.get(u).add(new Pair(v,time));
        }
        int[] sTime = new int[n+1];
        Arrays.fill(sTime, Integer.MAX_VALUE);
        sTime[src]= 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src,0));
        while(pq.size()>0){
            Pair top = pq.remove();
            int node = top.node;
            int time = top.time;
            if(time > sTime[node]) continue;
            for(Pair p : adj.get(node)){
                int totaltime = p.time + time;
                if(totaltime < sTime[p.node]){
                    sTime[p.node] = totaltime;
                    pq.add(new Pair(p.node,totaltime));
                }
            }
        }
        int max = 0;
        for(int i=1; i<=n; i++){
            if(sTime[i]== Integer.MAX_VALUE) return -1;
            max = Math.max(max,sTime[i]);
        }
        return max;
    }
    public static void main(String[] args){
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n=4, src = 2;
        NetworkDelay nd = new NetworkDelay();
        System.out.println( nd.networkDelayTime(times,n,src));
    }
}
