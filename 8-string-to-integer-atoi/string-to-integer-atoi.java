class Solution {
    public boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public int myAtoi(String s) {
        // "   123" -> 123
        // "-123" -> -123
        // "+23" -> 23
        // "-041" -> -41
        // "-04bc2" -> -4

        int i = 0;
        int num = 0;
        int sign = 1; //default is +ve

        while(i < s.length() && s.charAt(i) == ' ') {
            i = i+1;
        }

        if(i < s.length()) {
            if(s.charAt(i) == '-') {
                sign = -1;
                i = i+1;
            } else if(s.charAt(i) == '+') {
                i = i+1;
            }
        }

        while(i < s.length() && isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            if(num == Integer.MAX_VALUE / 10) {
                if(sign == 1) {
                    if(digit >= 7) {
                        return Integer.MAX_VALUE;
                    }
                } else if(sign == -1) {
                    if(digit >= 8) {
                        return Integer.MIN_VALUE;
                    }
                }
            }

            if(num > Integer.MAX_VALUE / 10) {
                if(sign == 1) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }

            num = num * 10 + digit;
            i = i+1;
        }

        return sign * num;
    }
}