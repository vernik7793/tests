package practics.quiz.test13;

public class Address implements Comparable<Address>{
	private State state;
	private String city;
	private String street;
	private int houseNumber;

	public Address(State state, String city, String street, int houseNumber) {
		this.state = state;
		this.city = city;
		this.street = street;
		this.houseNumber = houseNumber;
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
		Address other = (Address) obj;
		return (state.equals(other.state)) &&
				(city.equals(other.city)) &&
				(street.equals(other.street)) &&
				(houseNumber == other.houseNumber);
		//throw new UnsupportedOperationException("to do implementation");
	}
	
	@Override
	public int hashCode() {
        // TODO реализовать метод
        return 7 * state.hashCode() + 11 * city.hashCode() + 13 * street.hashCode() + 17 * (new Integer(houseNumber)).hashCode();
		//throw new UnsupportedOperationException("to do implementation");
	}
	
	@Override
	public String toString() {
        // TODO реализовать метод
		return "Address[state=" + state + ", city='" + city + "', street='" + street + "', houseNumber=" + houseNumber + "]";

		//throw new UnsupportedOperationException("to do implementation");
	}

	@Override
	public int compareTo(Address o) {
        // TODO реализовать метод
        //if (toString() > o.toString())

		throw new UnsupportedOperationException("to do implementation");
	}
}
