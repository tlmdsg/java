package Index_45;

import java.util.Arrays;

/**
 * @author tlm
 * @aimoffer : 扑克牌顺子
 * @题目描述 : 从扑克牌中随机抽5张牌，判断是不是一个顺子， 即这5张牌是不是连续的。 2～10为数字本身， A为1。 J为11、Q为12、
 *       为13。小王可以看成任意数字。为了方便起见,你可以认为大小王是0。
 */

public class Solution {

	public static boolean isContinuous(int[] numbers) {
		if (numbers == null || numbers.length != 5) {
			return false;
		}
		// 对元素进行排序
		Arrays.sort(numbers);
		int numberOfZero = 0;
		int numberOfGap = 0;
		for (int i = 0; i < numbers.length && numbers[i] == 0; i++) {
			numberOfZero++;
		}
		// 第一个非0元素的位置
		int small = numberOfZero;
		int big = small + 1;
		while (big < numbers.length) {
			if (numbers[small] == numbers[big]) {
				return false;
			}
			numberOfGap += (numbers[big] - numbers[small] - 1);
			small = big;
			big++;
		}
		return numberOfGap <= numberOfZero;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println();
	}

}
