/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.fit.config.context;

/**
 *
 * @author ytoh
 */
public interface ContextAware {

    void registerContext(MutableContext context);
}
