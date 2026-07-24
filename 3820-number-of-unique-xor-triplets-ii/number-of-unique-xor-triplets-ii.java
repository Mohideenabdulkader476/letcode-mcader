class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int MAX = 2048;   // Enough for values up to 1023

        boolean[] pair = new boolean[MAX];
        boolean[] ans = new boolean[MAX];

        int n = nums.length;

        // Store all XORs of pairs (i <= j)
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                pair[nums[i] ^ nums[j]] = true;
            }
        }

        // XOR each pair result with every element
        for (int x = 0; x < MAX; x++) {
            if (!pair[x]) continue;

            for (int num : nums) {
                ans[x ^ num] = true;
            }
        }

        int count = 0;
        for (boolean b : ans) {
            if (b) count++;
        }

        return count;
    }
}