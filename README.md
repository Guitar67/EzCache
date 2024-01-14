# EzCache

A framework that can solve most caching problems using annotations can be translated as "Annotation-driven caching
framework" in English.

# 功能概述

缓存读写: @EzCache(key="key" manager="managerName")

更新缓存: @EzUpdate(key="key")

删除缓存: @EzRemove(key="key")

设置失效时间: @EzCache(key="key", ttl="1")

设置读写策略: @EzCache(key="key", pattern="aside") // aside-旁路缓存 through-读写穿透 behind-异步读写

分布式锁: @EzLock(key="key")




