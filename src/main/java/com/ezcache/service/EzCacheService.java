package com.ezcache.service;

import com.ezcache.annotation.EzCache;
import com.ezcache.annotation.EzLock;
import com.ezcache.annotation.EzRemove;
import com.ezcache.annotation.EzUpdate;

/**
 * @author : Liuji
 * @program : EzCache
 * @description :
 * @create : 2024-01-14 20:27
 **/
public interface EzCacheService {

    /**
     * put
     *
     * @param ezCache
     * @param o
     * @return
     */
    boolean put(EzCache ezCache, Object o);

    /**
     * get
     *
     * @param ezCache
     * @return
     */
    Object get(EzCache ezCache);

    /**
     * @param ezUpdate
     * @param o
     * @return
     */
    boolean update(EzUpdate ezUpdate, Object o);

    /**
     * remove
     *
     * @param ezRemove
     * @return
     */
    boolean remove(EzRemove ezRemove);

    /**
     * lock
     *
     * @param ezLock
     * @return
     */
    boolean lock(EzLock ezLock);
}
