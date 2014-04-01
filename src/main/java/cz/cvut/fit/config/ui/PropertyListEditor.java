/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.cvut.fit.config.ui;

import java.awt.Component;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JPanel;
import org.apache.commons.collections.Closure;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.Validate;
import cz.cvut.fit.config.Property;
import cz.cvut.fit.config.context.PublishingContext;

/**
 *
 * @author ytoh
 */
public class PropertyListEditor implements PropertyEditor<List<?>, cz.cvut.fit.config.annotations.List> {

    public Component getEditorComponent(Property<List<?>> property, cz.cvut.fit.config.annotations.List annotation, PublishingContext context) {
        Validate.notNull(property.getValue(), "list property null.");
        Validate.isTrue(property.getValue() instanceof List, "property value does not hold a list.");

        final JPanel panel = new JPanel(new GridLayout(0, 1));

        CollectionUtils.forAllDo(property.getValue(), new Closure() {

            public void execute(Object i) {
                panel.add(new PropertyTable(i));
            }
        });

        return panel;
    }
}
