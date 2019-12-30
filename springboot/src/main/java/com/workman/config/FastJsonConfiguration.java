package com.workman.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

@Configuration
public class FastJsonConfiguration extends WebMvcConfigurationSupport {

    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        //定义一个conver转换消息的对象
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        //添加fastjson配置信息
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullListAsEmpty);
        //在conver中添加配置信息
        fastConverter.setFastJsonConfig(fastJsonConfig);
        //解决中文乱码问题，APPLICATION_JSON_UTF8提示已废弃，直接在applicatioin.properties里配置声明force吧
//        List<MediaType> fastMediaTypes = new ArrayList<>();
//        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
//        fastConverter.setSupportedMediaTypes(fastMediaTypes);
        //将conver添加到convertiers中
        converters.add(fastConverter);
        //追加默认转换器
        super.addDefaultHttpMessageConverters(converters);

    }
}
