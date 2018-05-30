package practiseAlgrothim;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NodeRelatedTest {

	@Test
	public void test() {

		StringRelated testStringRelated = new StringRelated();

		assertEquals(false, testStringRelated.isValid("(o[]"));
		assertEquals(true, testStringRelated.isValid(""));
		assertEquals(false, testStringRelated.isValid("([)]"));
	}

}
