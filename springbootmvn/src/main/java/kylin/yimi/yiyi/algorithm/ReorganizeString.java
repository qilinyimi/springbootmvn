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
//		StringBuilder sb = new StringBuilder();
		///排字母
		Map<Character,Integer> copymap = new HashMap<>();
		copymap.putAll(cmap);
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
//		StringBuilder sbs = new StringBuilder();//重排
		for(int i=0;i<charArray.length;i++) {
			int bs = (i/max)<1?1:(i/max)+1;
			if(bs==1) {
				list.add(i, charArray[i]);
				continue;
			}
//			link.add((i%max+1)*bs, charArray[i]);
//			if(list.size()=)
			list.add((i%max+1)*bs-1, charArray[i]);
//			list.add(e);
//			sbs.insert(offset, i)
		}
		

//		for(int i=0;i<chars.length;i++) {
////			插入位置   i/max 是倍数 （1%max+1）*(i/max) 是位置
//			link.add((1%max+1)*(i/max), element);
//		}
		return list.toString();
	}
	protected class Node{
		private Node pre;
		private Node next;
		private String c;
		Node(String c){
			this.c = c;
		}
		String getChar() {
			return c;
		}
		
		
	}
}

