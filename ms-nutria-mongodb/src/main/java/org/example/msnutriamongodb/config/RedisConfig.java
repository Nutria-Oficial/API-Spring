package org.example.msnutriamongodb.config;

import io.lettuce.core.RedisURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
  @Value("${REDIS_URI}")
  private String redisUri;

  @Bean
  public LettuceConnectionFactory redisConnectionFactory() {
    RedisURI uri = RedisURI.create(redisUri);

    RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
    config.setHostName(uri.getHost());
    config.setPort(uri.getPort());
    config.setPassword(RedisPassword.of(uri.getPassword()));

    LettuceClientConfiguration clientConfig = LettuceClientConfiguration.builder().useSsl().build();

    return new LettuceConnectionFactory(config, clientConfig);
  }

  @Bean
  public RedisTemplate<String, Object> redisTemplate(LettuceConnectionFactory connectionFactory) {
    RedisTemplate<String, Object> template = new RedisTemplate<>();
    template.setConnectionFactory(connectionFactory);

    template.setKeySerializer(new StringRedisSerializer());
    template.setHashKeySerializer(new StringRedisSerializer());
    template.setValueSerializer(new StringRedisSerializer());
    template.setHashValueSerializer(new StringRedisSerializer());

    template.afterPropertiesSet();
    return template;
  }
}
