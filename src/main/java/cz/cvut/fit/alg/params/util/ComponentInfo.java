package cz.cvut.fit.alg.params.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.PropertyUtils;
import cz.cvut.fit.alg.params.annotations.Property;

/**
 *
 * @author ytoh
 */
public class ComponentInfo {

    //
    private final String name;
//    //
//    private final Class<?>              type;
    //
    private final Map<String, Object> properties;

    /**
     *
     * @param name
     * @param properties
     */
    public ComponentInfo(String name, Map<String, Object> properties) {
        this.name = name;
//        this.type = type;
        this.properties = new HashMap<String, Object>(properties);
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public Map<String, Object> getProperties() {
        return new HashMap<String, Object>(properties);
    }

    /**
     *
     * @return
     */
//    public Class<?> getType() {
//        return type;
//    }
    /**
     *
     * @param o
     * @return
     * @throws java.lang.IllegalAccessException
     * @throws java.lang.reflect.InvocationTargetException
     * @throws java.lang.NoSuchMethodException
     */
    public static ComponentInfo getInfo(Object o) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Map<String, Object> properties = new HashMap<String, Object>();
        String name = Annotations.getName(o.getClass());

        List<Field> filtered = Annotations.filter(Arrays.asList(o.getClass().getDeclaredFields()), Property.class);

        for (Field field : filtered) {
            properties.put(field.getName(), PropertyUtils.getProperty(o, field.getName()));
        }

        return new ComponentInfo(name, /*o.getClass(),*/ properties);
    }
}
