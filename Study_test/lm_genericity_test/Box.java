package lm_genericity_test;

public class Box<E> {

	E data;

	public Box(E e) {
		this.data = e;
	}
	
	public void setData(E data) {
		this.data = data;
	}

	public E getData() {
		return data;
	}

}
