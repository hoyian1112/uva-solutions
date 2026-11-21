package uva;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
public class uva12100 {
	static class Job {
        int priority;
        int index;

        Job(int priority, int index) {
            this.priority = priority;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null) return;
        int cases = Integer.parseInt(line.trim());

        StringBuilder sb = new StringBuilder();
        while (cases-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(br.readLine());
            }
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Queue<Job> queue = new ArrayDeque<>();
            int[] count = new int[10];

            for (int i = 0; i < n; i++) {
                while (!st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine());
                }
                int p = Integer.parseInt(st.nextToken());
                queue.offer(new Job(p, i));
                count[p]++;
            }

            int minutes = 0;
            while (!queue.isEmpty()) {
                Job curr = queue.poll();
                boolean hasHigher = false;
                for (int p = curr.priority + 1; p <= 9; p++) {
                    if (count[p] > 0) {
                        hasHigher = true;
                        break;
                    }
                }

                if (hasHigher) {
                    queue.offer(curr);
                } else {
                    minutes++;
                    count[curr.priority]--;
                    if (curr.index == m) {
                        sb.append(minutes).append('\n');
                        break;
                    }
                }
            }
        }
        System.out.print(sb);
    }
}
