package ex0110;

import java.util.function.Consumer;

public class StringListConsumer implements Consumer<String>{
	public void accept(String t) {
		System.out.println("%%%%%%"+t+"%%%%%%%");
	}
}
