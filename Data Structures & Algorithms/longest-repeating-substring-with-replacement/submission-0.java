class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];

        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++){
            char currentChar = s.charAt(right);

            count[currentChar - 'A']++;

            maxFreq = Math.max(maxFreq, count[currentChar - 'A']);
            int windowLength = right - left + 1;

            while(windowLength-maxFreq > k){
                char charLeft = s.charAt(left);
                count[charLeft - 'A']--;
                left++;

                windowLength = right - left + 1;
            }
            maxLength = Math.max(maxLength, windowLength);
        }
        return maxLength;
    }
}
