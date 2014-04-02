package cz.cvut.fit.config.context;

import java.util.List;

/**
 *
 * @author ytoh
 */
public interface Subscriber<T> {

    <E extends Publisher> void notifyOf(E publisher, List<? extends T> value,
            String key);
}
