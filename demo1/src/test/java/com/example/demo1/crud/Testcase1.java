package com.example.demo1.crud;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;


public class Testcase1 {
	ProController pc = new ProController();
	Product p;

	@Test
	public void hello() {
		assertEquals("welcome", pc.Hello());
	}
	// public void getdata() {
	// 	assertEquals("success", pc.getProd(p));
	// }
}