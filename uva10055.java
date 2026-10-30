package uva;
import java.io.*;
import java.util.*;
public class uva10055 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;
            
            StringTokenizer st = new StringTokenizer(line);
            if (!st.hasMoreTokens()) continue;
            
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            
            
            System.out.println(Math.abs(a - b));
        }
    }
}
