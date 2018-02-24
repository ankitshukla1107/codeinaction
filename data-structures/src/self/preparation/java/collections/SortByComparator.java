package self.preparation.java.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByComparator {

	static class Customer {

		String name;
		int age;

		public Customer(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}

		@Override
		public String toString() {
			return "Customer [name=" + name + ", age=" + age + "]";
		}
	}

	static class AgeComparator implements Comparator<Object> {
		@Override
		public int compare(Object o1, Object o2) {
			Customer customer1 = (Customer) o1;
			Customer customer2 = (Customer) o2;
			if (customer1.age == customer2.age) {
				return 0;
			} else if (customer1.age > customer2.age) {
				return 1;
			} else {
				return -1;
			}
		}
	}

	static class NameComparator implements Comparator<Object> {
		@Override
		public int compare(Object o1, Object o2) {
			Customer customer1 = (Customer) o1;
			Customer customer2 = (Customer) o2;
			return customer1.name.compareTo(customer2.name);
		}

	}

	public static void main(String[] args) {
		List<Customer> list = new ArrayList<Customer>();
		list.add(new Customer("Ankit", 27));
		list.add(new Customer("pablo", 17));
		list.add(new Customer("leo", 35));
		System.out.println("sorting collections by name: ");
		Collections.sort(list, new NameComparator());
		for (Customer customer : list) {
			System.out.println(customer);
		}
		System.out.println("sorting collections by age: ");
		Collections.sort(list, new AgeComparator());
		for (Customer customer : list) {
			System.out.println(customer);
		}
	}

}
