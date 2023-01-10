package ex0110;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ex05 {

	public static void main(String[] args) {
		List<String> list=new ArrayList<>();
		list.add("abc");
		list.add("abc");
		list.add("xyz");
		list.add("123");
		
		for(int i=0;i<list.size();i++) {
			String element=list.get(i);
			System.out.println(element);
		}
		System.out.println("=========");
		
//		Iterator<String> it=list.iterator();
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
		
		for(Iterator<String> it2=list.iterator();it2.hasNext();) {
			System.out.println(it2.next());
		}
		System.out.println("----------");
		for(String s:list) {
			System.out.println(s);
		}
		System.out.println("-----------");
		
		//forEach方法里面的参数，表示具体的操作
		Consumer<String> consumer=new StringListConsumer();
		
		list.forEach(consumer);
		
		Consumer<String> consumer2=new Consumer<String>() {
			public void accept(String t) {
				System.out.println("#####"+t+"#####");
			}
		};
		
		list.forEach(consumer2);
		
		list.forEach(new Consumer<String>() {
			public void accept(String t) {
				System.out.println("@@@@"+t+"@@@@");
			}
		});
		
		list.forEach((String t)->{
			System.out.println("!!!"+t+"!!!!!");
			}
		);
		
		list.forEach(t->System.out.println("!!!"+t+"!!!"));
		
		list.forEach(e->System.out.println(e+e));
		
		
	}

}
