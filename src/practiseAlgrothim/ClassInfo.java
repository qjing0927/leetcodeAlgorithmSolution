package practiseAlgrothim;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ClassInfo {
	String author();
	String date();
	int CurrentVersion() default 1;
	String LastModified() default "N/A";
	String LastModifiedBy() default "N/A";
	String[] reviewers();
	String engineer() default "[unassgined]";
}
