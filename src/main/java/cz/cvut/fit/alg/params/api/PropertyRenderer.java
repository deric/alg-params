package cz.cvut.fit.alg.params.api;

import java.awt.Component;
import java.lang.annotation.Annotation;
import cz.cvut.fit.alg.params.Property;

/**
 * <code>PropertyRenderer</code> is used to retrieve a {@link Component} capable of displaying
 * the underlying property.
 *
 * @author ytoh
 * @param <T>
 * @param <A>
 */
public interface PropertyRenderer<T, A extends Annotation> {

    /**
     * Returns a {@link Component} that is bound to the supplied {@link Property}
     * and is capable of displaying it.
     *
     * @param property <code>Property</code> to display
     * @param annotation {@link Annotation} defining this renderer
     * @return <code>Component</code> bound to the supplied <code>property</code>
     */
    Component getRendererComponent(Property<T> property, A annotation);
}
