package cz.cvut.fit.alg.params.context;

/**
 *
 * @author ytoh
 */
public interface Publisher {

    <T> void subscribeTo(Class<T> type, String key, Subscriber<T> subscriber);
}
