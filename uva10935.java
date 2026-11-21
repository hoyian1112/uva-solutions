package uva;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
public class uva10935 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        while (true) {
            while (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) {
                    System.out.print(sb);
                    return;
                }
                st = new StringTokenizer(line);
            }

            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;

            Queue<Integer> deck = new ArrayDeque<>();
            for (int i = 1; i <= n; i++) {
                deck.offer(i);
            }

            List<Integer> discarded = new ArrayList<>();
            while (deck.size() >= 2) {
                discarded.add(deck.poll());
                deck.offer(deck.poll());
            }

            sb.append("Discarded cards:");
            for (int i = 0; i < discarded.size(); i++) {
                if (i == 0) {
                    sb.append(' ').append(discarded.get(i));
                } else {
                    sb.append(", ").append(discarded.get(i));
                }
            }
            sb.append('\n');
            sb.append("Remaining card: ").append(deck.peek()).append('\n');
        }

        System.out.print(sb);
    }
}