package com.trans.until;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ZouJiaJun
 * @Title: OssProperties
 * @Package: net.zhongjunkeji.config.obs
 * @Description:
 * @Date: 2022/8/4 - 11:45
 */
@Data
@ConfigurationProperties(prefix = "zjkj.global")
public class ObsProperties {

    private Map<Type, OssSecret> oss = new HashMap<>();

    public static enum Type {
        /**
         * 枚举类型
         */
        HUAWEI, ALIYUN
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class OssSecret {
        /**
         * 访问key
         */
        private String accessKey;

        /**
         * 密钥
         */
        private String secretKey;

        /**
         * 端点
         */
        private String endPoint;

        /**
         * 桶
         */
        private String bucketName;
    }
}
