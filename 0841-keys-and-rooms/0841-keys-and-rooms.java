import java.util.*;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visit = new boolean[rooms.size()];
        Arrays.fill(visit, false);
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        while (!q.isEmpty()) {
            int curr = q.poll();
            visit[curr] = true;
            for (int v : rooms.get(curr)) {
                if (!visit[v]) {
                    q.offer(v);
                }
            }
        }
        for (boolean v : visit) {
            if (!v) {
                return false;
            }
        }
        return true;
    }
}
