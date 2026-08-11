class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] an = new int[26];
        for (char c : s.toCharArray()) {
            an[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            an[c - 'a']--;
        }

        for (int freq : an) {
            if (freq != 0) {
                return false;
            }
        }
        return true;
    }
}
