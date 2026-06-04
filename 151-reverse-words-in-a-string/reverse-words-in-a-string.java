class Solution {
    public String reverseWords(String s) {

        Stack<String> st = new Stack<>();

        for (String word : s.trim().split("\\s+")) {
            st.push(word);
        }

        StringBuilder ans = new StringBuilder();

        while (!st.isEmpty()) {

            ans.append(st.pop());

            if (!st.isEmpty()) {
                ans.append(" ");
            }
        }

        return ans.toString();
    }
}