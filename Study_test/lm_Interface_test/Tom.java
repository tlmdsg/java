package lm_Interface_test;

public class Tom implements Sum {

	@Override
	public float sum(double x) {
		return (float) (x + PI);
	}

}
