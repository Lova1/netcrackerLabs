package interfacepackage.annotation;

import java.lang.annotation.*;

/**
 * @author Lova Vardanian
 * @version 1.1
 * @since 1.1
 * <p>
 * This is an annotation for mark Fillers class
 *</p>
 */

//@Inherited
@Target(value=ElementType.TYPE)
@Retention(value= RetentionPolicy.RUNTIME)
public @interface ClassFillersAnnotation {

}
