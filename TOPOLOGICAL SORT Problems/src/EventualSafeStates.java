import java.util.*;

public class EventualSafeStates {
//Lc = 802
public List<Integer> eventualSafeNodes(int[][] graph) {
    int n = graph.length;
    List<List<Integer>> adj = new ArrayList<>();
    for(int i=0; i<n; i++){
        adj.add(new ArrayList<>());
    }
    int[] indeg = new int[n];
    for(int i=0; i<n; i++){
        for(int ele : graph[i]){
            adj.get(ele).add(i);
            indeg[i]++;
        }
    }
    Queue<Integer> q = new LinkedList<>();
    List<Integer> ans = new ArrayList<>();
    for(int i=0; i<n; i++){
        if(indeg[i]==0) q.add(i);
    }
    while(q.size()>0){
        int front = q.remove();
        ans.add(front);
        for(int ele : adj.get(front)){
            indeg[ele]--;
            if(indeg[ele]==0) q.add(ele);
        }
    }
    Collections.sort(ans);
    return ans;
}
public static void main(String[] args) {
    int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
    EventualSafeStates es = new EventualSafeStates();
    System.out.println(es.eventualSafeNodes(graph));
}
}
