package kylin.yimi.yiyi.algorithm;

import java.util.HashMap;
import java.util.Map;
/**
 * 
 * 算法题描述：我们认定数字按位旋转180之后仍有些数字是有意义的，例如：1转180度后认为1；数字2转180度之后为5；数字15旋转180度之后为12；
 * 规定：（1<->1,2<->5,3无意义，4无意义，5<->2，6<->9,7无意义，8<->8;9<->6,0<->0）
 *其中2转180度后为5，与其本身不同，我们认为这样的数是有效数。
 *例如：在1到10中，有效数2,5,6,9，共4个。
 *计算：100以内有效数个数。
 */
public class RevolveNumber {
	static Map<Integer,Boolean> inverMap = new HashMap<>(16);
	static{
		inverMap.put(1, false);
		inverMap.put(2, true);
		inverMap.put(5, true);
		inverMap.put(6, true);
		inverMap.put(8, false);
		inverMap.put(9, true);
		inverMap.put(0, false);
	}
	public static void main(String [] args) {
		Long start = System.currentTimeMillis();
		int  maxnum = 1000;//初始值
		int num = 0;//存放有效数个数
		int i=0;//递增寻找值
		for(;;) {
			i++;//从1开始
			int pre = i;//存放高位数值（123 下次循环就是12  再下次就是1）
			boolean iseffictnum = false;//是否有效
			boolean notnum = false;//一票否决权
//			int nlength = String.valueOf(i).length();//100以内多消耗了5毫秒（milliseconds）  初值为1000 消耗23 毫秒
			int nlength = getSize(i);//初值为100 消耗3毫秒   初始值为1000 消耗18毫秒
			for(int j=0;j<nlength;j++) {
				int last = pre%10;
				if(inverMap.containsKey(last)) {
					iseffictnum |=  inverMap.get(last);
				}else {
					notnum = true;
					break;
				}
				pre = pre/10;
			}
			if(iseffictnum&&!notnum) {
				num++;
				System.out.println("第"+num+"个有效值是："+i);
			}
			if(i==maxnum) {
				break;
			}
		}
		System.out.println("时间消耗："+(System.currentTimeMillis()-start));
		
	}
	private static int getSize(int x) {
		for(int i=0;;i++)
			if(x<=sizeTable[i]) {
				return i+1;
			}
	}
	private static final int [] sizeTable = {9, 99, 999, 9999, 99999, 999999, 9999999,
            99999999, 999999999, Integer.MAX_VALUE};
}
