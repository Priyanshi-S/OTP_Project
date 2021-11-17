package com.example.DemoApp;

import org.testng.annotations.Test;

public class TestCodeCover {
	@Test
	public void positiveTest() {
		CompareString obj=new CompareString();
		obj.containsOrNot("sss");
	}
}
