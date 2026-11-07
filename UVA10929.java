package uva;
import java.math.BigInteger;
import java.util.Scanner;
public class UVA10929 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String s = scanner.next();
            if (s.equals("0")) {
                break;
            }
            BigInteger num = new BigInteger(s);
            BigInteger[] div = num.divideAndRemainder(BigInteger.valueOf(11));
            
            if (div[1].equals(BigInteger.ZERO)) {
                System.out.println(s + " is a multiple of 11.");
            } else {
                System.out.println(s + " is not a multiple of 11.");
            }
        }
    }
}
