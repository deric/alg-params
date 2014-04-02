package cz.cvut.fit.config.module;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.lang.Validate;

import java.util.Stack;

/**
 *
 * @author ytoh
 */
public final class Modules {

    private static final Configuration configuration;

    static {
        try {
            configuration = new PropertiesConfiguration(
                    Modules.class.getResource("/configuration.properties"));
        } catch (ConfigurationException ex) {
            throw new cz.cvut.fit.config.ConfigurationException(
                    "Could not configure modules.", ex);
        }
    }

    /**
     * This is a utility class and it should not be initialized
     */
    private Modules() {
        throw new Error("Utility class should not be initialized.");
    }

    /**
     *
     */
    public static void save() {
        ModuleSerializer serializer = new XmlSerializer();
        serializer.setConfiguration(configuration);
        Stack<Module> stack = new Stack<Module>();
        stack.push(getRootModule());

        while (!stack.empty()) {
            serializer.serializeModule(stack.peek());
            for (Module m : stack.pop().getChildren()) {
                stack.push(m);
            }
        }
    }

    /**
     *
     */
    public static void load() {
        ModuleDeserializer deserializer = new XmlDeserializer();
        deserializer.deserializeModule(getRootModule());
    }

    /**
     *
     * @param module
     * @return
     */
    public static boolean isRootModule(Module module) {
        return module.getParent() == null;
//        return RootModule.INSTANCE.equals(module);
    }

    /**
     *
     * @return
     */
    public static Module getRootModule() {
        RootModule root = RootModule.INSTANCE;

//		if(!root.isInitialized()) {
//            load();
//		}
        return root;
    }

    /**
     *
     * @param module
     * @return
     */
    public static String getModuleFullName(Module module) {
        Validate.notNull(module, "Module cannot be null.");

        return isRootModule(module) ? "/" : getInnerModuleFullName(module);
    }

    /**
     *
     * @param module
     * @return
     */
    private static String getInnerModuleFullName(Module module) {
        return isRootModule(module) ? "" : getInnerModuleFullName(
                module.getParent()) + "/" + module.getName();
    }

    /**
     *
     * @param fullName
     * @return
     */
    public static Module getModule(String fullName) {
        Validate.notNull(fullName, "Module name cannot be null.");
        Validate.isTrue(fullName.startsWith("/"),
                        "Module full name must start with '/'");

        if ("/".equals(fullName)) {
            return getRootModule();
        }

        String[] names = fullName.substring(1).split("/");
        Module module = getRootModule();

        for (String name : names) {
            module = findSubModule(name, module);
        }

        return module;
    }

    /**
     *
     * @param name
     * @param module
     * @return
     */
    private static Module findSubModule(final String name, Module module) {
        return (Module) CollectionUtils.find(module.getChildren(),
                                             new Predicate() {
                                                 public boolean evaluate(Object object) {
                                                     return name.equals(((Module) object).getName());
                                                 }
                                             });
    }
}
