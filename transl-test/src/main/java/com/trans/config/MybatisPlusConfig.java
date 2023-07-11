package com.trans.config;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.incrementer.DefaultIdentifierGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: ZouJiaJun
 * @Title: MybatisPlusConfig
 * @Package: com.trans.config
 * @Description:
 * @Date: 2023/7/10 - 16:21
 */
@Configuration
public class MybatisPlusConfig {

    @Bean
    public DefaultIdentifierGenerator defaultIdentifierGenerator() {
        // 以免多线程批量插入，ID主键生成有重复，主键冲突错误
        // 1-31 随机数
        long workerId = RandomUtil.randomLong(1, 31);
        // 1-31 随机数
        long dataCenterId = RandomUtil.randomLong(1, 31);

        return new DefaultIdentifierGenerator(workerId, dataCenterId);
    }
}
