package cz.cvut.fit.config.ui;

import com.jgoodies.binding.adapter.BasicComponentFactory;
import com.jgoodies.binding.beans.PropertyAdapter;
import com.jgoodies.binding.value.ValueModel;
import java.awt.Component;
import cz.cvut.fit.config.Property;
import cz.cvut.fit.config.context.PublishingContext;

/**
 * A {@link PropertyEditor} implementation editing the number property as an integer.
 *
 * @author ytoh
 */
public class IntegerTextFieldEditor implements PropertyEditor<Number, TextField> {

    public Component getEditorComponent(final Property<Number> property, TextField annotation, PublishingContext context) {
        final ValueModel model = new PropertyAdapter(property, "value", true);
        return BasicComponentFactory.createIntegerField(model);
    }
}