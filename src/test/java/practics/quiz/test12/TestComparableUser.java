package practics.quiz.test12;

import org.junit.Test;

import java.util.SortedSet;
import java.util.TreeSet;

import static org.junit.Assert.assertEquals;

public class TestComparableUser {
	
	@Test
	public void testComparableUser() {
		SortedSet<ComparableUser> set = new TreeSet<ComparableUser>();
		set.add(new ComparableUser(3, "B"));
		set.add(new ComparableUser(1, "C"));
		set.add(new ComparableUser(2, "A"));
        assertEquals("[User[age=1, name'C'], User[age=2, name'A'], User[age=3, name'B']]", set.toString());
	}

}
