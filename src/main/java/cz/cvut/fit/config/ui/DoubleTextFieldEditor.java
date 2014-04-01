package cz.cvut.fit.config.ui;

import com.jgoodies.binding.adapter.BasicComponentFactory;
import com.jgoodies.binding.beans.PropertyAdapter;
import com.jgoodies.binding.value.ValueModel;
import java.awt.Component;
import java.text.DecimalFormat;
import cz.cvut.fit.config.Property;
import cz.cvut.fit.config.context.PublishingContext;

/**
 * A {@link PropertyEditor} instance editing numer properties with a formatted
 * JTextField.
 *
 * @author ytoh
 */
public class DoubleTextFieldEditor implements PropertyEditor<Object, TextField> {

    public Component getEditorComponent(final Property<Object> property, TextField annotation, PublishingContext context) {
        final ValueModel model = new PropertyAdapter(property, "value", true);
        return BasicComponentFactory.createFormattedTextField(model, new DecimalFormat("#.###"));
    }
}