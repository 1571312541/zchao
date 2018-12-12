package cn.clj.zchao.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component
public class RedisDataSourceImpl implements RedisDataSource{
	@Autowired
    private JedisPool    jedisPool;
	private static final Logger log = LoggerFactory.getLogger(RedisDataSourceImpl.class);
	@Override
	public Jedis getRedisClient() {
		try {
			Jedis shardedJedis=jedisPool.getResource();
			return shardedJedis;
		} catch (Exception e) {
			log.error("getRedisClent error   :",e);
		}
		return null;
	}

	@Override
	public void returnResource(Jedis shardedJedis) {
		jedisPool.returnResource(shardedJedis);
	}

	/*@Override
	public void returnResource(ShardedJedis shardedJedis, boolean broken) {
		if (broken) {
            shardedJedisPool.returnBrokenResource(shardedJedis);
        } else {
            shardedJedis.close();
        }
	}*/

}
