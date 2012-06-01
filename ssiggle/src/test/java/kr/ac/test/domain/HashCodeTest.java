package kr.ac.test.domain;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class HashCodeTest {
	public class P {
	}

	public class A extends P {
		@Override
		public int hashCode() {
			return 1;
		}
	}

	public class B extends P {
		@Override
		public int hashCode() {
			return 1;
		}
	}

	@Test
	public void testHash() {
		P a = new A();
		P b = new B();

		assertThat(a == b, is(false));
	}

	@Test
	public void testHashAnother() {
		A a = new A();
		A b = new A();

		assertThat(a.hashCode() == b.hashCode(), is(true));
		assertThat(a == b, is(false));
	}
}