 class Solution {
    public String largestGoodInteger(String num) {
        String ans = "";
        for (int i = 2; i < num.length(); i++) {
        
            if (num.charAt(i) == num.charAt(i - 1) && num.charAt(i) == num.charAt(i - 2)) {
                String current = num.substring(i - 2, i + 1); 
                if (current.compareTo(ans) > 0) { 
                    ans = current;
                }
            }
        }
        return ans;
    }
}
        
        

        

        

        
    
