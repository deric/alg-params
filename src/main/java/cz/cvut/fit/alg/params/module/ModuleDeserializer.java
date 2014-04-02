package cz.cvut.fit.alg.params.module;

import org.apache.commons.configuration.Configuration;

/**
 *
 * @author ytoh
 */
public interface ModuleDeserializer {

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
     * @param parent
     */
    void deserializeModule(Module parent);
}
