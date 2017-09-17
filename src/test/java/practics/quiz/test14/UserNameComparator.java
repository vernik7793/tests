package practics.quiz.test14;

import java.util.Comparator;

/**
 * Написать Comparator для сравнения имени User'а в лексикографическом порядке
 */
public class UserNameComparator implements Comparator<User> {

	@Override
	public int compare(User user0, User user1) {
        // TODO реализовать метод
	if (user0 == user1)
		return 0;
	if (user0.getName() == null)
		return -1;
	else if (user1.getName() == null)
		return 1;
	else
		return user0.getName().compareTo(user1.getName());
        //throw new UnsupportedOperationException("to do implementation");
	}
	
}
