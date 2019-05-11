public class Test {

	public static void main(String[] args) {
		Test test = new Test();
		test.func(5);
	}

	void func(int a) {
		if (a == 0)
			return;
		func(a - 1);
		System.out.println(a);
	}

}
