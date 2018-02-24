package self.preparation.java.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortByComparable {

	class Customer implements Comparable<Customer> {

		private String name;
		private int age;

		public Customer(String name, int age) {
			this.name = name;
			this.age = age;
		}

		@Override
		public int compareTo(Customer customer) {
			if (age == customer.age) {
				return 0;
			} else if (age > customer.age) {
				return 1;
			} else {
				return -1;
			}
		}

		@Override
		public String toString() {
			return "Customer [name=" + name + ", age=" + age + "]";
		}
	}

	public static void main(String[] args) {
		SortByComparable testSort2 = new SortByComparable();
		List<Customer> list = new ArrayList<Customer>();
		list.add(testSort2.new Customer("Ankit", 27));
		list.add(testSort2.new Customer("Amit", 26));
		list.add(testSort2.new Customer("Bhavesh", 34));
		Collections.sort(list);
		for (Customer customer : list) {
			System.out.println(customer);
		}
	}

}
