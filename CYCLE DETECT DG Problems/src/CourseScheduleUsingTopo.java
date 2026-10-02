import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//Lc = 207
public class CourseScheduleUsingTopo {
    public boolean canFinish(int n, int[][] pre) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        int[] indeg = new int[n];
        for(int i=0; i<pre.length; i++){
            int u = pre[i][0];
            int v = pre[i][1];
            adj.get(v).add(u);
            indeg[u]++;
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(indeg[i]==0) q.add(i);
        }
        while(q.size() > 0){
            int front = q.remove();
            ans.add(front);
            for(int ele : adj.get(front)){
                indeg[ele]--;
                if(indeg[ele]==0) q.add(ele);
            }
        }
        return (ans.size()==n);
    }
    public static void main(String[] args){
        int n =2;
        int[][] pre = {{1,0}, {0,1}};
        CourseScheduleUsingTopo cs = new CourseScheduleUsingTopo();
        System.out.println(cs.canFinish(n,pre));
    }
}
