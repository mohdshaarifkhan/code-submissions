class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        int[] need = new int[128];
        int[] window = new int[128];
        int matched = 0;
        int left = 0;
        int start = 0;
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }

        for (int right = 0; right < s.length(); right++) {
            window[s.charAt(right)]++;

            if (need[s.charAt(right)] > 0 && window[s.charAt(right)] <= need[s.charAt(right)]) {
                matched++;
            }

            while (matched == t.length()) {
                int windowLength = right - left + 1;

                if (windowLength < minLength) {
                    minLength = windowLength;
                    start = left;
                }
                window[s.charAt(left)]--;

                if (need[s.charAt(left)] > 0 && window[s.charAt(left)] < need[s.charAt(left)]) {
                    matched--;
                }
                left++;
            }
        }
        if (minLength == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(start, start + minLength);
    }
}
