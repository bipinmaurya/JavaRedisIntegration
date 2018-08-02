package com.infoease.redis;

import redis.clients.jedis.Jedis;

public class RedisConnection {


	public static void main(String[] args) {
		Jedis jredis = new Jedis("localhost");
		System.out.println("Ping: " + jredis.ping());
	}
}
