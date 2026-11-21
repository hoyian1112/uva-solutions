package uva;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
public class uva572 {
	private static final int[] DR = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] DC = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            if (!st.hasMoreTokens()) continue;
            int m = Integer.parseInt(st.nextToken());
            if (m == 0) break;
            int n = Integer.parseInt(st.nextToken());

            char[][] grid = new char[m][n];
            for (int r = 0; r < m; r++) {
                String row = br.readLine();
                while (row != null && row.trim().isEmpty()) {
                    row = br.readLine();
                }
                if (row == null) break;
                row = row.trim();
                for (int c = 0; c < n && c < row.length(); c++) {
                    grid[r][c] = row.charAt(c);
                }
            }

            int deposits = 0;
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    if (grid[r][c] == '@') {
                        deposits++;
                        bfs(grid, r, c, m, n);
                    }
                }
            }
            sb.append(deposits).append('\n');
        }

        System.out.print(sb);
    }

    private static void bfs(char[][] grid, int startR, int startC, int m, int n) {
        Queue<int[]> q = new ArrayDeque<>();
        grid[startR][startC] = '*';
        q.offer(new int[]{startR, startC});

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            for (int d = 0; d < 8; d++) {
                int nr = r + DR[d];
                int nc = c + DC[d];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '@') {
                    grid[nr][nc] = '*';
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
}