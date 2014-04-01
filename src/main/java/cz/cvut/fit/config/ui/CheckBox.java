package cz.cvut.fit.config.ui;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import cz.cvut.fit.config.annotations.Editor;
import cz.cvut.fit.config.annotations.Renderer;

/**
 * Render and edit as a checkbox.
 *
 * @author ytoh
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Editor(component=CheckBoxEditor.class)
@Renderer(component=CheckBoxEditor.class)
public @interface CheckBox { }
