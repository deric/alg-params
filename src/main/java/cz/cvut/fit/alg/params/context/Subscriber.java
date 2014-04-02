package cz.cvut.fit.alg.params.context;

import java.util.List;

/**
 *
 * @author ytoh
 */
public interface Subscriber<T> {

    <E extends Publisher> void notifyOf(E publisher, List<? extends T> value,
            String key);
}
