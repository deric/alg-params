package cz.cvut.fit.config.ui;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JDialog;
import cz.cvut.fit.config.Property;
import cz.cvut.fit.config.context.PublishingContext;


/**
 * Created by IntelliJ IDEA.
 * User: lagon
 * Date: Sep 29, 2009
 * Time: 4:35:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class DynamicListPickerEditor extends JDialog implements PropertyEditor<String, DynamicListPicker> {

    public Component getEditorComponent(Property<String> property, DynamicListPicker annotation, PublishingContext context) {
        JButton butt = new JButton();
        butt.setText("Close list window");
        return butt;
    }

}
