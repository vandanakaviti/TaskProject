package com.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UnitTest2 {

	@Test
	void test() {
		Testing t = new Testing();
		assertEquals(1, t.isUser());
	}

}
