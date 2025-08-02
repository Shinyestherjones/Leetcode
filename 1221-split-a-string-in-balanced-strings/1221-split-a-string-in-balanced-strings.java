class Solution {
    public int balancedStringSplit(String s) {
        int count = 0, balance = 0;

        for (char ch : s.toCharArray()) {
            if (ch == 'R') {
                balance++;
            } else {
                balance--;
            }

            if (balance == 0) {
                count++;
            }
        }

        return count;
    }
}
