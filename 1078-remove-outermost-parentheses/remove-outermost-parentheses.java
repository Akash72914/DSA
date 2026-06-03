class Solution {
    public String removeOuterParentheses(String s) {
        int count = 0;
        StringBuilder ans = new StringBuilder();

        for(char ch : s.toCharArray()) {
            if(ch == '(') {
                if(count > 0) {
                    ans.append(ch);
                }

                count++;
            } else {
                count--;

                if(count > 0) {
                    ans.append(ch);
                }
            }
        }

        return ans.toString();
    }
}