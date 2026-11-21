package uva;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
public class uva548 {
	private static int bestSum;
    private static int bestLeaf;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int[] inorder = readSequence(br);
            if (inorder == null) break;
            int[] postorder = readSequence(br);
            if (postorder == null) break;

            int n = inorder.length;
            Map<Integer, Integer> posMap = new HashMap<>(n * 2);
            for (int i = 0; i < n; i++) {
                posMap.put(inorder[i], i);
            }

            bestSum = Integer.MAX_VALUE;
            bestLeaf = Integer.MAX_VALUE;

            dfs(postorder, 0, n - 1, 0, n - 1, posMap, 0);
            sb.append(bestLeaf).append('\n');
        }

        System.out.print(sb);
    }

    private static int[] readSequence(BufferedReader br) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            if (st.hasMoreTokens()) {
                int[] arr = new int[st.countTokens()];
                int idx = 0;
                while (st.hasMoreTokens()) {
                    arr[idx++] = Integer.parseInt(st.nextToken());
                }
                return arr;
            }
        }
        return null;
    }

    private static void dfs(
            int[] post,
            int inL,
            int inR,
            int postL,
            int postR,
            Map<Integer, Integer> posMap,
            int currentSum) {
        if (inL > inR || postL > postR) return;

        int rootVal = post[postR];
        int nextSum = currentSum + rootVal;
        int inRootIdx = posMap.get(rootVal);
        int leftSize = inRootIdx - inL;

        
        if (inL == inR) {
            if (nextSum < bestSum || (nextSum == bestSum && rootVal < bestLeaf)) {
                bestSum = nextSum;
                bestLeaf = rootVal;
            }
            return;
        }

       
        if (inL <= inRootIdx - 1) {
            dfs(post, inL, inRootIdx - 1, postL, postL + leftSize - 1, posMap, nextSum);
        }
        
        if (inRootIdx + 1 <= inR) {
            dfs(post, inRootIdx + 1, inR, postL + leftSize, postR - 1, posMap, nextSum);
        }
    }
}
