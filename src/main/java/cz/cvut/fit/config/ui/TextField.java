package cz.cvut.fit.config.ui;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import cz.cvut.fit.config.annotations.Editor;

/**
 * Edit as a text field.
 *
 * @author ytoh
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Editor(component=TextFieldEditor.class)
public @interface TextField { }
