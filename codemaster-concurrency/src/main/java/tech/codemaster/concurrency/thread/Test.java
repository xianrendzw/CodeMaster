package tech.codemaster.concurrency.thread;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tomdeng
 *
 */
public class Test {
	static void main(String... args) {
		new Test();
	}

	public Test() {
		final List<Integer> list = new ArrayList<>();
		for (final Integer e : list) {
			System.out.println(e);
		}
	}
}
