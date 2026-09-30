import java.util.*;

// LC = 841
public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visit = new boolean[n];
        visit[0]=true;
        bfs(0, rooms, visit);
        for(boolean ele : visit){
            if(ele==false) return false;
        }
        return true;
    }
    public static void bfs(int i, List<List<Integer>> rooms, boolean[] visit ){
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while(q.size() > 0){
            int front = q.remove();
            for(int ele : rooms.get(front)){
                if(!visit[ele]){
                    visit[ele]= true;
                    q.add(ele);
                }
            }
        }
    }
    public static void main (String[] args){
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1, 3));
        rooms.add(Arrays.asList(3, 0, 1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(0));

        KeysAndRooms kr = new KeysAndRooms();
        System.out.println(kr.canVisitAllRooms(rooms));

    }
}
