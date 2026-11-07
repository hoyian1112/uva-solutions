package uva;
import java.util.*;
public class UVA10008 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int n = scanner.nextInt();
        scanner.nextLine(); // 讀取換行符號
        
        int[] count = new int[26];
        while (n > 0 && scanner.hasNextLine()) {
            String line = scanner.nextLine();
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (Character.isLetter(c)) {
                    count[Character.toUpperCase(c) - 'A']++;
                }
            }
            n--;
        }
        
        // 將出現過的字母放入 List 中
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                list.add((char) ('A' + i));
            }
        }
        
        // 排序：頻率由大到小；頻率相同時，字母由小到大
        list.sort((a, b) -> {
            int freqA = count[a - 'A'];
            int freqB = count[b - 'A'];
            if (freqA != freqB) {
                return freqB - freqA; // 降序
            }
            return a - b; // 升序
        });
        
        // 輸出結果
        for (char c : list) {
            System.out.println(c + " " + count[c - 'A']);
        }

    }
	
}
