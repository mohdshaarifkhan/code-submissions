class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }

        int[] s1Freq = new int[26];
        int[] windowLength = new int[26];

        for(int i = 0; i < s1.length(); i++){
            s1Freq[s1.charAt(i) - 'a']++;
            windowLength[s2.charAt(i) - 'a']++;
        }

        if(Arrays.equals(s1Freq, windowLength)){
            return true;
        }

        for(int i = s1.length(); i < s2.length(); i++){

            int incoming = s2.charAt(i);
            int outgoing = s2.charAt(i - s1.length());

            windowLength[incoming - 'a']++;
            windowLength[outgoing - 'a']--;

            if(Arrays.equals(s1Freq, windowLength)){
                return true;
            }
        }

        return false;
    }
}
