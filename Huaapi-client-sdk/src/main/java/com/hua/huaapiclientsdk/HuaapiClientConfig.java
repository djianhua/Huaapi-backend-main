package com.hua.huaapiclientsdk;

import com.hua.huaapiclientsdk.client.HuaapiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("huaapi.client")
@Data
@ComponentScan
public class HuaapiClientConfig {
    private String accessKey;
    private String secretKey;

    @Bean
    public HuaapiClient huaapiClient(){
        return new HuaapiClient(accessKey,secretKey);
    }
}
