package lm_Interface_test;

public class Jack implements Sum{

	@Override
	public float sum(double x) {
		return (float)(x*PI);
	}

}
