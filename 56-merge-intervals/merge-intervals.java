class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> res = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i = 0; i < n; i++) {
            //Overlap case
            if (intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            }
            //Non-overlapping interval → push previous and reset
            else {
                res.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        res.add(new int[]{start, end});

        return res.toArray(new int[res.size()][]);
    }
}