package org.workspace.annotations.status;

import java.lang.annotation.*;

/**
 * The annotation marks the solutions as completely workable with all the test cases.
 *
 * @author Ankur Agarwal
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Completed {}
