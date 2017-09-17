package practics.quiz.test13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Считать, что порядок адресов в массиве - важен.
 * Написать в классе Person метод hashCode.
 * Написать в классе Person метод toString.
 * Написать в классе Person метод equals.
 *
 * Написать в классе Person метод CompareTo.
 * Считать что раньше должен стоять тот, кто моложе, если равного возраста, то тот у кого имя
 * лексиграфически меньше (считайте null больше всех), если имена совпадают, то на адресах определите
 * порядок сами (но он должен быть корректным - антисимметричным, транзитивным).
 * 
 * корректно обработать ситуации когда поле ссылочного типа равно null.
 * кореектно обрабатывать массив нулевой длины
 * 
 * порядок адресов в массиве - важен, если массивы адресов [address0, address1, address2]
 * и [address2, address1, address0] считаются не эквивалентными.
 *
 */

public class Person implements Comparable<Person> {
	private int age;
	private String name;
	private Address[] addresses;

	private int CompareArraysOfAddress(Address[] addrs1, Address[] addrs2) {
		int len1 = addrs1.length;
		int len2 = addrs2.length;
		int len = Math.min(len1, len2);
		boolean compared = false;
		int rslt = 0;
		int i = 0;
		while ((i < len) && !compared) {
			rslt = addrs1[i].compareTo(addrs2[i]);
			if (Math.abs(rslt) > 0)
				compared = true;
			i++;
		}
		if (!compared)
			return ((Integer)len1).compareTo(len2);
		else
			return rslt;
	}

	public Person(int age, String name, Address[] addresses) {
		this.age = age;
		this.name = name;
		this.addresses = addresses;
	}


	
	@Override
	public String toString() {
        // TODO реализовать метод
		return "Person[age=" + age + ", name='" + name + "', addresses=" + Arrays.toString(addresses) + "]";
        //throw new UnsupportedOperationException("to do implementation");
	}
	
	/*
	 * метод compareTo не имеет право выбрасывать исключение
	 * какие бы аргументы ему не передавали
	 */
	@Override
	public int compareTo(Person o) {
        // TODO реализовать метод
		if (age == o.age) {
			if (((name == null) && (o.name == null)) || ((name != null) && (name.equals(o.name)))) {
				return CompareArraysOfAddress(addresses, o.addresses);
			}
			else if (name == null)
				return -1;
			else if (o.name == null)
				return 1;
			else
				return name.compareTo(o.name);
		} else
			return ((Integer)age).compareTo(o.age);
        //throw new UnsupportedOperationException("to do implementation");
	}

	@Override
	public int hashCode() {
        // TODO реализовать метод
        return 7 * (new Integer(age)).hashCode() + 11 * name.hashCode() + 13 * Arrays.toString(addresses).hashCode();
		//throw new UnsupportedOperationException("to do implementation");
	}

	/* 
	 * метод equal не имеет право выбрасывать исключение
	 * какие бы аргументы ему не передавали
	 */
	@Override
	public boolean equals(Object obj) {
        // TODO реализовать метод
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return (age == other.age) && name.equals(other.name) && (CompareArraysOfAddress(addresses, other.addresses) == 0);
        //throw new UnsupportedOperationException("to do implementation");
	}
}
