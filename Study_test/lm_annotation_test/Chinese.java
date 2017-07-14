package lm_annotation_test;

@Description("this is Chinese class.")
public class Chinese extends Person {

	@Description("this is a Chinese method.")
	@Override
	public void sayHi() {
		System.out.println("Hi,Chinese friend.");
	}
}
