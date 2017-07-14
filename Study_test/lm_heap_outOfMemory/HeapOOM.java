package lm_heap_outOfMemory;

import java.util.ArrayList;
import java.util.List;

/*
 * VM Args: -Xms10m -Xmx10m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {

	static class OOMobject {

	}

	public static void main(String[] args) {
		List<OOMobject> objects = new ArrayList<>();
		while (true) {
			objects.add(new OOMobject());
		}

	}

}
