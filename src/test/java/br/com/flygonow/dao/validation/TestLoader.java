package br.com.flygonow.dao.validation;

import org.junit.Test;

public class TestLoader {

	@Test
	public void test() {
		System.out.println(this.getClass().getClassLoader().getResource("applicationContext"));
	}

}
