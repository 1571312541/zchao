package cn.clj.zchao.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Tuple;

import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
public class RedisClientTemplate {
	private static final Logger log = LoggerFactory.getLogger(RedisClientTemplate.class);

    @Autowired
    private RedisDataSource     redisDataSource;

    public void disconnect() {
        Jedis shardedJedis = redisDataSource.getRedisClient();
        shardedJedis.disconnect();
    }
    
    /**
     * 判断key 是否存在
     * 
     * @param key
     * @return
     */
    public Boolean exists(String key) {
        Boolean result = false;
        Jedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.exists(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            
        } finally {
            redisDataSource.returnResource(shardedJedis);
        }
        return result;
    }
    
    /**
     * 设置 key 属性名 属性值  
     * 
     * @param key
     * @param field
     * @param value
     * @return
     */
    public Long hset(String key, String field, String value) {
        Long result = null;
        Jedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.hset(key, field, value);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            
        } finally {
            redisDataSource.returnResource(shardedJedis);
        }
        return result;
    }
    /**
     * 根据key 
     * @param key
     * @param strings
     * @return
     */
    public Long lpush(String key, String... strings) {
        Long result = null;
        Jedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
       
        try {
            result = shardedJedis.lpush(key, strings);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            
        } finally {
            redisDataSource.returnResource(shardedJedis);
        }
        return result;
    }
    /**
     * 根据key
     * 返回并弹出指定Key关联的链表中的第一个元素，即头部元素。如果该Key不存，返回nil。 
     * @param key
     * @return
     */
    public String lpop(String key) {
        String result = null;
        Jedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
       
        try {
            result = shardedJedis.lpop(key);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            
        } finally {
            redisDataSource.returnResource(shardedJedis);
        }
        return result;
    }
    /**
     * hgetAll   获得key对应的所有属性 和 值
     * 
     * @param key
     * @return
     */
    public Map<String, String> hgetAll(String key) {
        Map<String, String> result = null;
        Jedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
       
        try {
            result = shardedJedis.hgetAll(key);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            
        } finally {
            redisDataSource.returnResource(shardedJedis);
        }
        return result;
    }
    
    /**
     * hget   根据 key 和 field 获取值
     * 
     * @param key
     * @param field
     * @return
     */
    public String hget(String key, String field) {
        String result = null;
        Jedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
       
        try {
            result = shardedJedis.hget(key, field);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            
        } finally {
            redisDataSource.returnResource(shardedJedis);
        }
        return result;
    }
    
    public Long hdel(String key,String field){
    	Long result = null;
        Jedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.hdel(key, field);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            
        } finally {
            redisDataSource.returnResource(shardedJedis);
        }
        return result;
        
    }
    /**
     * 获得key对应值+1的数  如果key不存在则返回1 
     * @param key   
     * @return
     */
    public Long incr(String key) {
        Long result = null;
        Jedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
       
        try {
            result = shardedJedis.incr(key);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            
        } finally {
            redisDataSource.returnResource(shardedJedis);
        }
        return result;
    }

    /**
     * 获得key field 对应值 + value 的数  如果key不存在则返回value
     * @param key
     * @param field
     * @param value
     * @return
     */
    public Long hincrBy(String key,String field,long value) {
        Long result = null;
        Jedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
       
        try {
            result = shardedJedis.hincrBy(key, field, value);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
            
        } finally {
            redisDataSource.returnResource(shardedJedis);
        }
        return result;
    }

    /**
     * 获得批量插入的管道
     * @return
     */
    public Pipeline pipelined() {
        Jedis shardedJedis = redisDataSource.getRedisClient();
        Pipeline result = null;
        if (shardedJedis == null) {
            return result;
        }
        try {
            result = shardedJedis.pipelined();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            redisDataSource.returnResource(shardedJedis);
        }
        return result;
    }
    
    /**
     * 设置多个值     hmset
     * 
     * @param key
     * @param map
     * @return
     */
    public String hmset(String key,Map<String,String> map) {
        String result = null;

        Jedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
       
        try {
            result = shardedJedis.hmset(key, map);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            
        } finally {
            redisDataSource.returnResource(shardedJedis);
        }
        return result;
    }
    /**
     * 设置单个值
     * 
     * @param key
     * @param value
     * @return
     */
    public String set(String key, String value) {
        String result = null;

        Jedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
       
        try {
            result = shardedJedis.set(key, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            
        } finally {
            redisDataSource.returnResource(shardedJedis);
        }
        return result;
    }

    /**
     * 设置单个值
     * @param key
     * @param value
     * @param seconds
     * @return
     */
    public String setex(String key, String value,int seconds) {
        String result = null;

        Jedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
       
        try {
            result = shardedJedis.setex(key, seconds, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            
        } finally {
            redisDataSource.returnResource(shardedJedis);
        }
        return result;
    }

    /**
     * 取单个值
     * 
     * @param key
     * @return
     */
    public String get(String key) {
        String result = null;

        Jedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
       
        try {
            result = shardedJedis.get(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            
        } finally {
            redisDataSource.returnResource(shardedJedis);
        }
        return result;
    }
    /**
     * 删除 
     * 
     * @param keys
     * @return
     */
    public Long del(String... keys) {
        Long result = null;

        Jedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
       
        try {
            result = shardedJedis.del(keys);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            
        } finally {
            redisDataSource.returnResource(shardedJedis);
        }
        return result;
    }
    
    /**
     *  
     * 
     * @param key
     * @param fields
     * @return
     */
    public List<String> hmget(String key,String... fields) {
    	List<String> result = null;

        Jedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
       
        try {
            result = shardedJedis.hmget(key, fields);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            
        } finally {
            redisDataSource.returnResource(shardedJedis);
        }
        return result;
    }
    

    /**
     * 设置单个值
     * 
     * @param key
     * @param unixTime
     * @return
     */
    public Long expireAt(String key, long unixTime) {
        Long result = null;

        Jedis shardedJedis = redisDataSource.getRedisClient();
        if (shardedJedis == null) {
            return result;
        }
       
        try {
            result = shardedJedis.expireAt(key,unixTime);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            
        } finally {
            redisDataSource.returnResource(shardedJedis);
        }
        return result;
    }
    /**
     * 设置过期时间
     * 
     * @param key
     * @param unixTime
     * @return
     */
    public Long expire(String key, int unixTime) {
    	Long result = null;
    	
    	Jedis shardedJedis = redisDataSource.getRedisClient();
    	if (shardedJedis == null) {
    		return result;
    	}
    	
    	try {
    		result = shardedJedis.expire(key,unixTime);
    	} catch (Exception e) {
    		log.error(e.getMessage(), e);
    		
    	} finally {
    		redisDataSource.returnResource(shardedJedis);
    	}
    	return result;
    }
    
    /**
     * 通过通配符获得所有的key
     * @param pattern 通配符  比如查询:eplat开头的  pattern为:eplat*
     * @return
     */
    public String[] keys(String pattern){
    	Jedis jedis = redisDataSource.getRedisClient();
    	Set<String> keySet = jedis.keys(pattern);
		if(keySet == null || keySet.size()<=0){
			return null;
		}
		String keyArr[] = new String[keySet.size()];
		int i =0;
		for (String keys : keySet) {
			keyArr[i] = keys;
			i++;
		}
		jedis.close();
    	return keyArr;
    }
    
    /**
	 * Redis Lrange 返回列表中指定区间内的元素，区间以偏移量 START 和 END 指定。 其中 0 表示列表的第一个元素， 1 表示列表的第二个元素，以此类推。 
	 * 你也可以使用负数下标，以 -1 表示列表的最后一个元素， -2 表示列表的倒数第二个元素，以此类推。
	 * @param key
	 * @param start
	 * @param end
	 * @return
	 */
	public List<String> lrange(String key, int start, int end) {
		Jedis jedis = redisDataSource.getRedisClient();
		List<String> result = jedis.lrange(key, start, end);
		jedis.close();
		return result;
	}
 
	/**
	 * 从列表中从头部开始移除count个匹配的值。如果count为零，所有匹配的元素都被删除。如果count是负数，内容从尾部开始删除。
	 * @param key
	 * @param count
	 * @param value
	 */
	public Long lrem(String key, Long count, String value) {
		Jedis jedis = redisDataSource.getRedisClient();
		Long result = jedis.lrem(key, count, value);
		jedis.close();
		return result;
	}
 
	/**
	 * Redis Zadd 命令用于将一个或多个成员元素及其分数值加入到有序集当中。
		如果某个成员已经是有序集的成员，那么更新这个成员的分数值，并通过重新插入这个成员元素，来保证该成员在正确的位置上。
		分数值可以是整数值或双精度浮点数。
		如果有序集合 key 不存在，则创建一个空的有序集并执行 ZADD 操作。
		当 key 存在但不是有序集类型时，返回一个错误。
	 * @param key
	 * @param score
	 * @param member
	 * @return 被成功添加的新成员的数量，不包括那些被更新的、已经存在的成员。
	 */
	public Long zadd(String key, double score, String member) {
		Jedis jedis = redisDataSource.getRedisClient();
		Long result = jedis.zadd(key, score, member);
		jedis.close();
		return result;
	}
	
	/**
	 * Redis Zrevrangebyscore 返回有序集中指定分数区间内的所有的成员。有序集成员按分数值递减(从大到小)的次序排列。
		具有相同分数值的成员按字典序的逆序(reverse lexicographical order )排列。
		除了成员按分数值递减的次序排列这一点外， ZREVRANGEBYSCORE 命令的其他方面和 ZRANGEBYSCORE 命令一样。
	 * @param key
	 * @param max
	 * @param min
	 * @param offset
	 * @param count
	 * @return 指定区间内，带有分数值(可选)的有序集成员的列表。
	 */
	public LinkedHashSet<String> zrevrangebyscore(String key, String max, String min, int offset, int count){
		Jedis jedis = redisDataSource.getRedisClient();
		LinkedHashSet<String> result = (LinkedHashSet<String>) jedis.zrevrangeByScore(key, max, min, offset, count);
		jedis.close();
		return result;
	}
	
	/**
	 * zset 删除一个或多个member
	 * @param key
	 * @param members
	 * @return
	 */
	public Long zrem(String key,String... members){
		Jedis jedis = redisDataSource.getRedisClient();
		Long result = jedis.zrem(key, members);
		jedis.close();
		return result;
	}
	
	/**
	 * 根据key、member返回有序集合zset中的score
	 * @param key
	 * @param member
	 * @return
	 */
	public Double zscore(String key,String member){
		Jedis jedis = redisDataSource.getRedisClient();
		Double result = jedis.zscore(key, member);
		jedis.close();
		return result;
	}
	
	/**
	 * 给指定元素的分数进行增减操作，负值为减，正值为加。zincrby
	 * @param key
	 * @param score
	 * @param member
	 * @return 为score值  不需要再zscore
	 */
	public Double zincrby (String key,Double score, String member){
		Jedis jedis = redisDataSource.getRedisClient();
		Double result = jedis.zincrby(key, score, member);
		jedis.close();
		return result;
	}
	
	/**
	 * zset 根据key值返回所有  包括member、score
	 * @param key
	 * @return
	 */
	public Set<Tuple> zrangeWithScores (String key){
		Jedis jedis = redisDataSource.getRedisClient();
		Set<Tuple> set = jedis.zrangeWithScores(key, 0, -1);
		jedis.close();
		return set;
	}
	
	/**
	 * 反射调用静态方法
	 * @param clazz
	 * @param methodName
	 * @param str
	 * @return
	 */
	public static Object invokeMethod(Class<?> clazz, String methodName, String str) {
		Method method;
		Object obj = null;
		try {
			method = clazz.getMethod(methodName,new Class<?>[]{str.getClass()});
			obj = method.invoke(null, str);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return obj;
	}
	/**
	 * 返回存储在key对应的有序集合中的元素的个数。
	 * 
	 * */
	public Long zcard(String key) {
		Jedis jedis = redisDataSource.getRedisClient();
		Long result = jedis.zcard(key);
		jedis.close();
		return result;
	}
}
