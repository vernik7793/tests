package practics.quiz.test14;

import java.util.Comparator;

/**
 * Сравнить User'ов по именам в лексикографическом порядке,
 * причем null меньше любого символа.
 * Если имена совпадают, сравниваем по возрасту в порядвке возрастания
 */
public class UserNameNullComparator implements Comparator<User> {

	@Override
	public int compare(User u1, User u2) {
        // TODO реализовать метод
		if (((u1.getName() == null) && (u2.getName() == null)) || ((u1.getName() != null) && (u1.getName().equals(u2.getName())))) {
			return ((Integer)u1.getAge()).compareTo(u2.getAge());
		}
		else if (u1.getName() == null)
			return -1;
		else if (u2.getName() == null)
			return 1;
		else
			return u1.getName().compareTo(u2.getName());
		//throw new UnsupportedOperationException("to do implementation");
	}

}
