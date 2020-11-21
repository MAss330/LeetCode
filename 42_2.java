class Solution {
    public int trap(int[] height) {
        // 暴力
        int ans = 0;
        for (int i = 0; i < height.length; i++){
            int leftMax = -1, rightMax = -1;
            for (int j = i; j >= 0; j--){
                leftMax = Math.max(leftMax, height[j]);
            }
            for (int j = i; j < height.length; j++){
                rightMax = Math.max(rightMax, height[j]);
            }
            ans += (Math.min(rightMax, leftMax) - height[i]);
            
        }
        return ans;
    }
}
