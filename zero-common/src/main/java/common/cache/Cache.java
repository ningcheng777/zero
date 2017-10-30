package common.cache;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author ningcheng
 * @date 2017/10/25
 */
public interface Cache<K, T> {
    T get(K key);

    List<T> mutiGet(Collection<K> keys);

    void put(K key, T value);

    void mutiPut(Map<? extends K, ? extends T> map);

    void evit(K key);

    void evit(List<K> keys);
}
