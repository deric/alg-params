package cz.cvut.fit.config.annotations;

import cz.cvut.fit.config.ui.SelectionSetEditor;
import cz.cvut.fit.config.ui.SelectionSetRenderer;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by IntelliJ IDEA.
 * User: lagon
 * Date: Oct 11, 2009
 * Time: 12:27:34 AM
 * To change this template use File | Settings | File Templates.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Editor(component = SelectionSetEditor.class)
@Renderer(component = SelectionSetRenderer.class)

public @interface SelectionSet {
    String key();
    Class<?> type();
    String windowTitle() default "Selection window";
    String rendererCellText() default "Click to select items...";
}
