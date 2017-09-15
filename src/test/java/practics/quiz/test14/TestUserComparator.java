package practics.quiz.test14;

import org.junit.Test;

import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

public class TestUserComparator {
	
	@Test
	public void testComparatorUserAge() {
		SortedSet<User> set = new TreeSet<User>(new UserAgeComparator());
		set.add(new User(3, "B"));
		set.add(new User(1, "C"));
		set.add(new User(2, "A"));
		assertEquals("[User[age=1, name'C'], User[age=2, name'A'], User[age=3, name'B']]", set.toString());
	}

	@Test
	public void testComparatorUserName() {
		SortedSet<User> set = new TreeSet<User>(new UserNameComparator());
		set.add(new User(3, "B"));
		set.add(new User(1, "C"));
		set.add(new User(2, "A"));
		assertEquals("[User[age=2, name'A'], User[age=3, name'B'], User[age=1, name'C']]", set.toString());
	}

}
