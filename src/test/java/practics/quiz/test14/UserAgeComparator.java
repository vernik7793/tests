package practics.quiz.test14;

import java.util.Comparator;

/**
 * Написать Comparator для сравнения возраста User'а в порядке убывания
 */
public class UserAgeComparator implements Comparator<User>{

	@Override
	public int compare(User user0, User user1) {
        // TODO реализовать метод
		return ((Integer)user0.getAge()).compareTo(user1.getAge());
        //throw new UnsupportedOperationException("to do implementation");
	}
	
}
