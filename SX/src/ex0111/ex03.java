package ex0111;

import java.util.HashMap;
import java.util.Map;

public class ex03 {
	/**
	 * ����һ�ַ�����ͳ��ÿ���ַ����ֵĴ���
	 * @param args
	 */

	public static void main(String[] args) {
		
		String str="adscshnciuiew";
		
//		System.out.println(str.charAt(10));
//		for(int i=0;i<str.length();i++) {
//			System.out.println(str.charAt(i));
//		}
		
		Map<Character,Integer> map=new HashMap<>();
		for(int i=0;i<str.length();i++) {
			char key=str.charAt(i);
			if(!map.containsKey(key)) {
				map.put(key, 1);
			}else {           //map���Ѿ����ڸ��ַ���
				int num=map.get(key);
				num++;
				map.put(key,num);
			}
		}
		
		System.out.println(map);
		
		System.out.println(map.get('a'));
	}

}
