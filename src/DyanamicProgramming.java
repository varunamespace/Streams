import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DyanamicProgramming {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        dp[n-1] = 0;
        dp[n-1] = cost[n-1];
        for(int i=n-2;i>=0;i--){
            dp[i] = Math.min(cost[i]+dp[i+1],cost[i]+dp[i+2]);
        }
        return Math.min(dp[0],dp[1]);
    }

    public int tribonacci(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+2];
        dp[0] = 0;
        dp[1] = 0;
        for(int i=0;i<nums.length;i++){
            dp[i+2] = Math.max(nums[i]+dp[(i+2)-2],dp[(i+2)-1]);
        }
        return dp[nums.length+1];
    }
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int maxLevel = 0;
        int maxSum = 0;
        int curLevel = 1;
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);
        while (!qu.isEmpty()) {
            int curSum = 0;
            for (int i = 0; i < qu.size(); i++) {
                TreeNode curNode = qu.poll();
                curSum += curNode.val;
                if (curNode.left != null) {
                    qu.add(curNode.left);
                }
                if (curNode.right != null) {
                    qu.add(curNode.right);
                }
            }
            if (curSum > maxSum) {
                maxSum = curSum;
                maxLevel = curLevel;
            }
            curLevel++;
        }
        return maxLevel;
    }
}
