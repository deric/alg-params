package cz.cvut.fit.config.annotations;

import cz.cvut.fit.config.ui.ComponentNameRenderer;
import cz.cvut.fit.config.ui.PropertyListEditor;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author ytoh
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Editor(component = PropertyListEditor.class)
@Renderer(component = ComponentNameRenderer.class)
public @interface List {
}
