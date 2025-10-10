class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length()-1;
        int length = 0;

         // Step 1: skip trailing spaces
        while(n >= 0 && s.charAt(n) == ' ') {
            n--;
        }

         // Step 2: count the length of the last word
        while(n >= 0 && s.charAt(n) != ' ') {
            length++;
            n--;
        }
        return length;
    }
}