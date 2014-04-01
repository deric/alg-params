/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.fit.config.context;

/**
 *
 * @author ytoh
 */
public interface Publisher {

    <T> void subscribeTo(Class<T> type, String key, Subscriber<T> subscriber);
}
