/**
 * 
 */
package Index_3;


/**
 * @author tlm
 * @leetcode : 3. Longest Substring Without Repeating Characters
 */
public class Solution {

	public int lengthOfLongestSubstring(String s) {
        int max=0 , length=0;
        boolean flag;
 
        char[] cs = new char[s.length()];
        s.getChars(0, s.length(), cs, 0);
        
        for (int i = 0; i < cs.length; i++) {
			length = 1;
			flag = true;
			
			while (length <= cs.length-i) {
				if (length == 1) {
					length++;
					continue;
				}
				for (int j = 0; j < length-1; j++) {
					if(cs[i+j] == cs[i+length-1]){
						flag = false;
						break;
					}
				}
				if (flag == false) {
					break;
				}
				length++;
			}
			max = (length-1)>max?(length-1):max;
		}
        
       
        return max;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
	}

}
