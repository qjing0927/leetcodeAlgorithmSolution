package practiseAlgrothim;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@ClassInfo(
		author = "Jing",
		date = "13/02/2017",
		reviewers = { "jing","qiu" }
		)
public class TryAnnotation {
	
	public static void main(String[] args) throws Exception{
		
		
		for(Annotation annote : TryAnnotation.class.getAnnotations()){
			
			Class<? extends Annotation> type = annote.annotationType();
			System.out.println("what I fetched is:" + type.getName() );
			
			for (Method method : type.getMethods()){
				Object value = method.invoke(annote, (Object[])null);
				System.out.println(method.getName() + ":" + value);
			}
		}
		
		
	}
}
