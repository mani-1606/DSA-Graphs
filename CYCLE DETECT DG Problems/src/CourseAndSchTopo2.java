import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//Lc = 210
public class CourseAndSchTopo2 {
    public int[] findOrder(int n, int[][] pre) {
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
        int[] ans2 = new int[ans.size()];
        for(int i=0; i<ans.size(); i++){
            ans2[i] = ans.get(i);
        }
        if(ans.size()!=n) return new int[]{};
        return ans2;

    }
    public static void main(String[] args){
        int n =2;
        int[][] pre = {{1,0}};
        CourseAndSchTopo2 cr = new CourseAndSchTopo2();
        System.out.println(cr.findOrder(n,pre));
    }
}
