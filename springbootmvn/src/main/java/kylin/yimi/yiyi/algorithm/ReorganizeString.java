package kylin.yimi.yiyi.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given a string S, check if the letters can be rearranged so that two characters that are adjacent 
 * to each other are not the same.If possible, output any possible result.  If not possible, 
 * return the empty string.
 * Example 1:
 * Input: S = "aab"
 * Output: "aba"
 * Example 2:
 * Input: S = "aaab"
 * Output: ""
 *
 */
public class ReorganizeString {
	public static void main(String[] args) {
	String s = "abaacba";
	System.out.println(getReorganizeString(s));
	}

	private static String getReorganizeString(String s) {
		Map<Character,Integer> cmap = new HashMap<>();
		char[] chars = s.toCharArray();
		int max = 1;//最少总有一个字符吧
		for(char c:chars) {
//			System.out.println(c);
			if(cmap.containsKey(c)) {
				int n = cmap.get(c)+1;
				max = max>=n?max:n;
				cmap.put(c, cmap.get(c)+1);
				continue;
			}
			cmap.put(c,1);
		}
		System.out.println(max);
		if(max>((chars.length/2)+1)) {
			//不可以实现
			return "不可重排";
		}
		StringBuilder sb = new StringBuilder();
		char[] charsr = new char[chars.length];
		for(Character ckey:cmap.keySet()) {
//			cmap.get
		}
		return "可重拍";
	}
}
