class Solution {
    public int maxDepth(String s) {
        int depth = 0;
        int maxDepth = 0;

        for(char ch : s.toCharArray()) {
            if(ch == '(') {
                depth++;
                maxDepth = Math.max(depth, maxDepth);
            } else if(ch == ')') {
                depth--;
            }
        }

        return maxDepth;
    }
}