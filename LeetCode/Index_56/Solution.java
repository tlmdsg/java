/**
 * 
 */
package Index_56;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author tlm
 * @leetcode : 56. Merge Intervals 
 */
public class Solution {

	public class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	public List<Interval> merge(List<Interval> intervals) {
		if (intervals == null || intervals.isEmpty()) {
			return new ArrayList<>();
		}
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
		List<Interval> result = new ArrayList<>();
		Interval previous = intervals.get(0);
		for (Interval interval : intervals) {
			if (previous.start <= interval.start && interval.start <= previous.end) {
				previous = new Interval(previous.start, Math.max(interval.end, previous.end));
			}else {
				result.add(previous);
				previous = interval;
			}
		}
		result.add(previous);
		return result;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		System.out.println();
	}

}
