package com.iplab.xwq.fblog.config;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Properties;

@Configuration
public class KaptchaConfig {
    @Bean
    public DefaultKaptcha getDefaultKaptcha(){
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        Properties properties = new Properties();
        properties.put("kaptcha.border","no");  //图片的边框
        properties.put("kaptcha.textproducer.font.color","black"); //字体颜色
        properties.put("kaptcha.image.width","150");   //图片宽度
        properties.put("kaptcha.image.heigth","40");   //图片高度
        properties.put("kaptcha.textproducer.font.size","30");  //字体大小
        properties.put("kaptcha.session.key", "verifyCode");
        properties.put("kaptcha.textproducer.char.space","5");  //验证码长度
//        properties.setProperty("kaptcha.textproducer.font.names", "宋体,楷体,微软雅黑");  //字体

        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}
