class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] st = new int[256];
        int[] ts = new int[256];
        Arrays.fill(st, -1);
        Arrays.fill(ts, -1);

        for(int i=0; i<s.length(); i++) {
            char ss = s.charAt(i);
            char tt = t.charAt(i);

            if(st[ss] == -1 && ts[tt] == -1) {
                st[ss] = tt;
                ts[tt] = ss;
            } else if(st[ss] != tt && ts[tt] != ss) {
                return false;
            }
        }

        return true;
    }
}