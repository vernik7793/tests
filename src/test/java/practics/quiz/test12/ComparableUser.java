package practics.quiz.test12;

/**
 * Написать compareTo для сравнения age в порядке возрастания
 * Написать toString, HashCode и Equals
 */
public class ComparableUser implements Comparable<ComparableUser>{
	private int age;
	private String name;
	
	public ComparableUser(int age, String name) {
		this.name = name;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
        // TODO реализовать метод
        return "User[age=" + getAge() + ", name'" + getName() + "']";
		//throw new UnsupportedOperationException("to do implementation");
	}
	
	@Override
	public int compareTo(ComparableUser that) {
        // TODO реализовать метод
		if (age > that.getAge())
			return 1;
		else if (age < that.getAge())
			return -1;
		else
			return 0;

		//throw new UnsupportedOperationException("to do implementation");
	}

	@Override
	public int hashCode() {
        // TODO реализовать метод
        return 11 * getName().hashCode() + 13 * (new Integer(getAge())).hashCode();
		//throw new UnsupportedOperationException("to do implementation");
	}

	@Override
	public boolean equals(Object obj) {
        // TODO реализовать метод
        if (obj == null)
        	return false;
        if (this == obj)
        	return true;
        if (getClass() != obj.getClass())
        	return false;
		ComparableUser other = (ComparableUser) obj;
		return (name.equals(other.name)) && (age == other.age);
		//throw new UnsupportedOperationException("to do implementation");
	}
}
