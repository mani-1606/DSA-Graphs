import java.util.*;
//Lc=1514
public class PathWithMaxProb {
    public class Pair implements Comparable<Pair> {
        int node;
        double prob;

        Pair(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }

        public int compareTo(Pair p) {
            if (this.prob == p.prob) return this.node - p.node;
            return Double.compare(this.prob, p.prob);
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<Pair>());
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            adj.get(u).add(new Pair(v, prob));
            adj.get(v).add(new Pair(u, prob));
        }
        double[] ans = new double[n];
        ans[start] = 1;
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(new Pair(start, 1));
        while (pq.size() > 0) {
            Pair top = pq.remove();
            int node = top.node;
            double prob = top.prob;
            if (prob < ans[node]) continue;
            for (Pair p : adj.get(node)) {
                double Tprob = p.prob * top.prob;
                if (Tprob > ans[p.node]) {
                    ans[p.node] = Tprob;
                    pq.add(new Pair(p.node, Tprob));
                }
            }
        }
        return ans[end];
    }
    public static void main(String[] args){
        int[][] edges = {{0,1},{1,2},{0,2}};
        double[] succProb = {0.5,0.5,0.2};
        int start = 0;
        int end = 2;
        int n =3;
        PathWithMaxProb pp = new PathWithMaxProb();
        System.out.println(pp.maxProbability(n,edges,succProb,start,end));

    }
}

