import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class keysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] vis = new boolean[n];
        vis[0]=true;
        dfs(0, rooms, vis);
        for(boolean ele : vis){
            if(ele==false) return false;
        }
        return true;
    }
    public static void dfs(int i, List<List<Integer>> rooms, boolean[] vis ){
        vis[i] = true;
        for(int ele : rooms.get(i)){
            if(!vis[ele]==false)  dfs(ele, rooms, vis);
        }
    }
    public static void main(String[] args){
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1,3));
        rooms.add(Arrays.asList(3,0,1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(0));
        keysAndRooms kr = new keysAndRooms();
        System.out.println(kr.canVisitAllRooms(rooms));
    }
}
