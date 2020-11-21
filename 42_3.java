class Solution {
    public int trap(int[] height) {
        Deque<Integer> stack = new ArrayDeque<>();
        int cur = 0, ans = 0;
        while (cur < height.length){
            while (!stack.isEmpty() && height[cur] > height[stack.peek()]){
                int top = stack.pop();
                if(stack.isEmpty()){
                    break;
                }
                ans += (Math.min(height[stack.peek()], height[cur]) - height[top]) *(cur - stack.peek()- 1);
            }
            stack.push(cur++);
        }
        return ans;
    }
}
