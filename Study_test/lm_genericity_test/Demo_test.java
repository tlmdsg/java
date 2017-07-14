package lm_genericity_test;


public class Demo_test {

	public static void main(String[] args) {
		
		Box<String> name = new Box<>("tlm");
		Box<Integer> age = new Box<Integer>(23);
		Box<Number> number = new Box<Number>(123);
		Box<Character> c = new Box<>('a');
		
		
		System.out.println(name.hashCode());
		System.out.println(age.hashCode());
		System.out.println(number.hashCode());
		System.out.println(c.hashCode());
		
//		System.out.println(name.getData());
//		System.out.println(name.getClass());
//		System.out.println(age.getData());
//		System.out.println(age.getClass());
//		System.out.println(number.getData());
//		System.out.println(number.getClass());
		
//		getData(name);
//		getData(age);
//		getData(number);
		
//		getData1(name);
		getData1(age);
		getData1(number);
		
		
	}
	
	public static void getData(Box<?> e) {
		System.out.println(e.getClass());
		System.out.println(e.getData());
	}
	
	public static void getData1(Box<? extends Number> e) {
		System.out.println(e.getClass());
		System.out.println(e.getData());
	}
	
	

}
