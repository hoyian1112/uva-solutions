package uva;
import java.io.*;
import java.util.*;
public class uva100 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;
            
            StringTokenizer st = new StringTokenizer(line);
            if (!st.hasMoreTokens()) break;
            
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            
            int start = Math.min(i, j);
            int end = Math.max(i, j);
            int maxCycle = 0;
            
            for (int n = start; n <= end; n++) {
                int cycle = getCycleLength(n);
                if (cycle > maxCycle) {
                    maxCycle = cycle;
                }
            }
            
            System.out.println(i + " " + j + " " + maxCycle);
        }
    }
    
    
    private static int getCycleLength(long n) {
        int length = 1;
        while (n != 1) {
            if (n % 2 != 0) {
                n = 3 * n + 1;
            } else {
                n = n / 2;
            }
            length++;
        }
        return length;
    }
}