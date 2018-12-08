package interfacepackage.annotation;

import java.lang.annotation.*;

/**
 * @author Lova Vardanian
 * @version 1.1
 * @since 1.1
 * <p>
 * This is an annotation for mark Fillers class
 * </p>
 */

@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface MethodFillersAnnotation {

}