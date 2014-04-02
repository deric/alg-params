package cz.cvut.fit.config.module;

import org.apache.commons.configuration.Configuration;
import java.beans.PersistenceDelegate;

/**
 *
 * @author ytoh
 */
public interface ModuleSerializer {

    /**
     *
     * @param configuration
     */
    void setConfiguration(Configuration configuration);

    /**
     * Sets configuration base directory.
     *
     * @param path Path to directory with configuration files
     */
    void setConfigurationDirectory(String path);

    /**
     * Returns configuration base directory.
     *
     * @return A path to directory with configuration.
     */
    String getConfigurationDirectory();

    /**
     *
     * @param module
     */
    void serializeModule(Module module);

    /**
     * Adds special handler for XML serializer for given class
     *
     * @param servedType Class to be served by this delegate.
     * @param delegate   Delegate class instance
     */
    void addNewDelegate(Class<?> servedType, PersistenceDelegate delegate);
}
