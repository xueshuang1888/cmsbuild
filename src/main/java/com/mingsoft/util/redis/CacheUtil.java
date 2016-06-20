package com.mingsoft.util.redis;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.alibaba.fastjson.JSON;

/**
 * 缓存实现类
 * */
public class CacheUtil {
	private static StringRedisTemplate redisTemplate;  
	
	public static void setRedisTemplate(StringRedisTemplate redisTemplate) {
		CacheUtil.redisTemplate = redisTemplate;
	}
	
	/**
	 * 根据KEY加入缓存String
	 * @param key         缓存KEY
	 * @param value       缓存值
	 * @param expireTime  缓存过期时间（秒）,如果为null表示永久有效;(说明:以最后一次放入该KEY时的时间为开始时间)
	 * */
	public static void put(String key, String value, Integer expireTime) {
		if (StringUtils.isEmpty(key)) {
			return;
		}
		if(expireTime != null && expireTime > 0){
			redisTemplate.opsForValue().set(key,value,expireTime,TimeUnit.SECONDS);
		}else{
			redisTemplate.opsForValue().set(key,value);
		}
	}

	/**
	 * 根据KEY加入缓存Object
	 * @param key         缓存KEY
	 * @param value       缓存值
	 * @param expireTime  缓存过期时间（秒）,如果为null表示永久有效;(说明:以最后一次放入该KEY时的时间为开始时间)
	 * */
	public static void put(String key, Object value, Integer expireTime) {
		if (StringUtils.isEmpty(key)) {
			return;
		}
		if(expireTime != null && expireTime > 0){
			redisTemplate.opsForValue().set(key,JSON.toJSONString(value),expireTime,TimeUnit.SECONDS);
		}else{
			redisTemplate.opsForValue().set(key,JSON.toJSONString(value));
		}
	}
	
	/**
	 * 根据KEY获取缓存
	 * @param key         缓存KEY
	 * @return 			     返回缓存的String;若key对没有应的缓存数据则返回null.
	 * */
	public static String get(String key) {
		Object obj = redisTemplate.opsForValue().get(key);
		if(obj == null){
			return null;
		}else{
			return String.valueOf(obj);
		}
	}

	/**
	 * 根据KEY获取缓存
	 * @param key         缓存KEY
	 * @param className   获取的缓存值的类型
	 * @return 			     返回缓存的对象;若key对没有应的缓存数据则返回null.
	 * */
	public static <T> T get(String key, Class<T> className) {
		Object obj = redisTemplate.opsForValue().get(key);
		if(obj == null){
			return null;
		}
		return JSON.parseObject(""+obj, className);
	}

	/**
	 * 判断KEY在缓存中是否存在
	 * @param key         缓存KEY
	 * @return 			  true:缓存中存在该key;反之亦然.
	 * */
	public static boolean hasKey(String key) {
		if(StringUtils.isEmpty(key)){
			return false;
		}
		return redisTemplate.hasKey(key);
	}


	/**
	 * 根据KEY删除缓存
	 * @param key         缓存KEY
	 * */
	public static void remove(String key) {
		if(StringUtils.isEmpty(key)){
			return;
		}
		redisTemplate.delete(key);
	}
	
	
	/**
	 * 根据KEY获取缓存
	 * @param key         缓存KEY
	 * @param className   获取的缓存值的类型
	 * @return			     返回缓存的List;若key对没有应的缓存数据则返回null.
	 */
	public static <T> List<T> getListCache(String key, Class<T> className) {
		if (StringUtils.isEmpty(key)) {
			return null;
		}
		Object obj = redisTemplate.opsForValue().get(key);
		if(obj == null||"".equals(obj.toString())){
			return null;
		}
		return JSON.parseArray(obj.toString(), className); 
	}
	
	
}
