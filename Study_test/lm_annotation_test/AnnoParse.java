package lm_annotation_test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnoParse {

	public static void main(String[] args) {
		
		try {
			Class c = Class.forName("lm_annotation_test.Chinese");
			Annotation[] as = c.getAnnotations();
			for (Annotation annotation : as) {
				if (annotation instanceof Description) {
					Description description = (Description) annotation;
					System.out.println(description.value());
				}
			}
			Method[] methods = c.getMethods();
			for (Method method : methods) {
				Annotation annotation = method.getAnnotation(Description.class);
				Description description = (Description) annotation;
				if (description != null) {
					System.out.println(description.value());
				}
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
