package com.dyl.cache.redis;

import java.util.concurrent.locks.ReadWriteLock;

import org.apache.ibatis.cache.Cache;
/**
 * 使用redis缓存来替代mybatis缓存默认配置
 * @author Administrator
 *
 */
public class RedisCache implements Cache {

	@Override
	public String getId() {
		return null;
	}

	@Override
	public void putObject(Object key, Object value) {
	}

	@Override
	public Object getObject(Object key) {
		return null;
	}

	@Override
	public Object removeObject(Object key) {
		return null;
	}

	@Override
	public void clear() {

	}

	@Override
	public int getSize() {
		return 0;
	}

	@Override
	public ReadWriteLock getReadWriteLock() {
		// TODO Auto-generated method stub
		return null;
	}

}
