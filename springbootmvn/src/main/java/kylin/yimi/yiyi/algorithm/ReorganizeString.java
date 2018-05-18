package kylin.yimi.yiyi.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
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
	String s = "abaacbabbcc";
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
		Map<Character,Integer> copymap = new HashMap<>();//拷贝一份cmap
		copymap.putAll(cmap);
		///排字母
		char[] charsr = new char[copymap.size()];
		for(int i=0;i<charsr.length;i++) {
//			排序
			int maxcc = 0;
			for(Character ckey:copymap.keySet()) {
				Integer cunum = copymap.get(ckey);
				if(maxcc<cunum) {
					maxcc = cunum;
					charsr[i] = ckey;
				}
			}
			copymap.remove(charsr[i]);
		}
		StringBuilder sb = new StringBuilder();//重排
		for(char c:charsr) {
			Integer integer = cmap.get(c);
			for(int i=0;i<integer;i++) {
				sb.append(c);
			}
		}
		char[] charArray = sb.toString().toCharArray();//按字母数量多少排序结果
//		LinkedList<Character> link = new LinkedList<>();
		List<Character> list = new ArrayList<>();
		for(int i=0;i<charArray.length;i++) {
			int bs = (i/max)<1?1:(i/max)+1;
			if(bs==1) {
				list.add(i, charArray[i]);
				continue;
			}
//			link.add((i%max+1)*bs, charArray[i]);
			//计算重排位置
			int p = (i%max+1)*bs-1;
			list.add(p, charArray[i]);
		}
		return list.toString();
	}
}

