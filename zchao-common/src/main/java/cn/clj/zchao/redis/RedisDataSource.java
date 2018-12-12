package cn.clj.zchao.redis;

import redis.clients.jedis.Jedis;

public interface RedisDataSource {
	/**
	 * getRedisClient() ： 取得redis的客户端，可以执行命令了。
	 * eturnResource(ShardedJedis shardedJedis) ： 将资源返还给pool
	 * returnResource(ShardedJedis shardedJedis, boolean broken) : 出现异常后，将资源返还给pool （其实不需要第二个方法）
	 * @return
	 */
	public abstract Jedis getRedisClient();
	
    public void returnResource(Jedis shardedJedis);
    
    //public void returnResource(ShardedJedis shardedJedis,boolean broken);

}
