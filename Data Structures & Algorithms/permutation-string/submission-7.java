class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] s1Counts = new int[26];
        int[] s2Counts = new int[26];

        // 1. Populate the frequency for s1 and the first window of s2
        for (int i = 0; i < s1.length(); i++) {
            s1Counts[s1.charAt(i) - 'a']++;
            s2Counts[s2.charAt(i) - 'a']++;
        }

        // 2. Slide the window across s2
        for (int i = s1.length(); i < s2.length(); i++) {
            // If the current window matches s1's frequencies, we found it!
            if (matches(s1Counts, s2Counts)) return true;

            // Slide window: Add the new character on the right
            s2Counts[s2.charAt(i) - 'a']++;
            // Remove the oldest character on the left
            s2Counts[s2.charAt(i - s1.length()) - 'a']--;
        }

        // Check the very last window position
        return matches(s1Counts, s2Counts);
    }

    // Helper method to compare two frequency arrays
    private boolean matches(int[] s1Counts, int[] s2Counts) {
        for (int i = 0; i < 26; i++) {
            if (s1Counts[i] != s2Counts[i]) return false;
        }
        return true;
    }
}