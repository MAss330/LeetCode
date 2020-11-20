class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // 计数的方法
        int[] count = new int[1001];
        int[] ans = new int[arr1.length];
        for (int val : arr1){
            count[val]++; 
        }
        int index = 0;
        for (int num : arr2){
            while (count[num] > 0){
                count[num]--;
                ans[index++] = num;
            }
        }

        for (int i = 0; i < count.length; i++){
            while (count[i] > 0){
                count[i]--;
                ans[index++] = i;
            }
        }

        return ans;   

    }
}
