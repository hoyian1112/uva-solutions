package uva1023;
import java.util.Scanner;
public class uva01586 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt(); 
        
        while (t-- > 0) {
            String s = sc.next();
            double totalMass = 0;
            int n = s.length();
            
            for (int i = 0; i < n; ) {
                char element = s.charAt(i);
                double weight = 0;
                
                
                if (element == 'C') weight = 12.01;
                else if (element == 'H') weight = 1.008;
                else if (element == 'O') weight = 16.00;
                else if (element == 'N') weight = 14.01;
                
                i++; 
                
                int count = 0;
                
                while (i < n && Character.isDigit(s.charAt(i))) {
                    count = count * 10 + (s.charAt(i) - '0');
                    i++;
                }
                
                
                if (count == 0) {
                    count = 1;
                }
                
                
                totalMass += weight * count;
            }
            
           
            System.out.printf("%.3f\n", totalMass);
        }
        
        sc.close();
    }
}

