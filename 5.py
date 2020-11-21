class Solution {
    public String longestPalindrome(String s) {
        // 中心扩展法 
        if(s == null || s.length() == 0){
            return "";
        }
        int start = 0, end = 0;
        int max = 0;
        for (int i = 0; i < s.length()-1; i++){
            int oddLen = expendMaxLen(s, i, i);
            int evenLen = expendMaxLen(s, i, i+1);
            max = Math.max(oddLen, evenLen);
            if (max > end - start + 1){
                start = i - (max - 1) / 2;
                end = i + max/2;
            }
        }
        return s.substring(start, end+1);
        
    }
    public int expendMaxLen(String s, int left, int right){
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }
}
