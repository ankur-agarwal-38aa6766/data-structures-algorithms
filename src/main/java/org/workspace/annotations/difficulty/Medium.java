package org.workspace.annotations.difficulty;

import java.lang.annotation.*;

/**
 * The annotation marks the solutions as {@literal Medium}.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Medium {
}
