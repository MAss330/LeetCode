class Solution {
    public int trap(int[] height) {
        // double pointer 
        int len = height.length;
        if (len < 3){
            return 0;
        }
        int left = 0, right = len - 1, ans = 0;
        int leftMax =  height[left], rightMax = height[right];
        while (left <= right){
            if (leftMax <= rightMax){
                if (height[left] >= leftMax){
                    leftMax = height[left];
                }else{
                    ans += (leftMax - height[left]);
                }
                left++;
            }else{
                if (height[right] >= rightMax){
                    rightMax = height[right];
                }else{
                    ans += (rightMax - height[right]);
                }
                right--;
            }
        }
        return ans;
    }
}
