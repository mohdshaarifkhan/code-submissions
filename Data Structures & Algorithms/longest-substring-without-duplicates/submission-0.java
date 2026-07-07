class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for(int i = 0; i< s.length(); i++){
            char currentChar = s.charAt(i);

            while(set.contains(currentChar)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(currentChar);

            int windowLength = i - left + 1;
            maxLength = Math.max(maxLength, windowLength);
        }
        return maxLength;
    }
}
