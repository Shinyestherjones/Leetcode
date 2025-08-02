class Solution {
    public long minCost(int[] basket1, int[] basket2) {
    
        long total = 0;
        Map<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < basket1.length; i++) {
            count.merge(basket1[i], 1, Integer::sum);
            count.merge(basket2[i], -1, Integer::sum);
        }

        List<Integer> swapped = new ArrayList<>();
        int minFruit = Integer.MAX_VALUE;

        for (var entry : count.entrySet()) {
            int cost = entry.getKey();
            int diff = entry.getValue();
            if (diff % 2 != 0) return -1; // Can't even-out
            for (int k = 0; k < Math.abs(diff) / 2; k++) {
                swapped.add(cost);
            }
            minFruit = Math.min(minFruit, cost);
        }

        Collections.sort(swapped);
        int m = swapped.size() / 2;

        for (int i = 0; i < m; i++) {
            total += Math.min(swapped.get(i), minFruit * 2L);
        }

        return total;
    }
}

        
    
