# 数组的相对排序
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // 简单题 按照题目的意思就可以
        Map<Integer,Integer > map = new HashMap<>();
        for (int val : arr2){
            map.put(val, 0);
        }
        List<Integer> list = new ArrayList<>();
        for (int val : arr1){
            if (map.containsKey(val)){
                map.put(val, map.getOrDefault(val, 0)+ 1);
            }else {
                list.add(val);
            }
        }
        Collections.sort(list, new Comparator<Integer>() { // 升序排序
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        int[] ans = new int[arr1.length];
        int index = 0;
        for (int i = 0; i < arr2.length; i++){
            int value = map.get(arr2[i]);
            while (value > 0){
                ans[index++] = arr2[i];
                value--;
            }
        }
        for (int val : list){
            ans[index++] = val;
        }
        return ans;
    }
}
