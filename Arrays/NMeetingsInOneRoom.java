/*
 * There is one meeting room in a firm. There are N meetings in the form of
 * (start[i], end[i]) where start[i] is start time of meeting i and end[i] is
 * finish time of meeting i.
 * What is the maximum number of meetings that can be accommodated in the
 * meeting room when only one meeting can be held in the meeting room at a
 * particular time?
 * 
 * Note: Start time of one chosen meeting can't be equal to the end time of the
 * other chosen meeting.
 */

import java.util.Arrays;

class NMeetingsInOneRoom {
    private static class Meeting {
        private int start;
        private int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    // Time -> O(n * log(n) * (n)) //
    // Space -> O(n) //

    private static int maxMeetings(int n, int start[], int end[]) {
        Meeting[] meetings = new Meeting[n];

        for (int i = 0; i < n; i++) {
            meetings[i] = new Meeting(start[i], end[i]);
        }

        Arrays.sort(meetings, (meet1, meet2) -> Integer.compare(meet1.end, meet2.end));

        int endTime = meetings[0].end;

        int res = 1;

        for (int i = 1; i < n; i++) {
            if (endTime < meetings[i].start) {
                res++;
                endTime = meetings[i].end;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int n = 6;
        int[] start = { 1, 3, 0, 5, 8, 5 };
        int[] end = { 2, 4, 6, 7, 9, 9 };

        System.out.println(maxMeetings(n, start, end));
    }
}