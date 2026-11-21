package uva;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
public class uva10004 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        while (true) {
            int n = nextInt(br, st);
            if (n == -1 || n == 0) break;

            int l = nextInt(br, st);
            List<List<Integer>> adj = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                adj.add(new ArrayList<>());
            }

            for (int i = 0; i < l; i++) {
                int u = nextInt(br, st);
                int v = nextInt(br, st);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }

            int[] color = new int[n];
            Arrays.fill(color, 0);
            boolean bicolorable = true;

            Queue<Integer> q = new ArrayDeque<>();
            color[0] = 1;
            q.offer(0);

            while (!q.isEmpty() && bicolorable) {
                int u = q.poll();
                for (int v : adj.get(u)) {
                    if (color[v] == 0) {
                        color[v] = -color[u];
                        q.offer(v);
                    } else if (color[v] == color[u]) {
                        bicolorable = false;
                        break;
                    }
                }
            }

            sb.append(bicolorable ? "BICOLORABLE.\n" : "NOT BICOLORABLE.\n");
        }

        System.out.print(sb);
    }

    private static StringTokenizer currentSt = null;

    private static int nextInt(BufferedReader br, StringTokenizer ignored) throws IOException {
        while (currentSt == null || !currentSt.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) return -1;
            currentSt = new StringTokenizer(line);
        }
        return Integer.parseInt(currentSt.nextToken());
    }
}