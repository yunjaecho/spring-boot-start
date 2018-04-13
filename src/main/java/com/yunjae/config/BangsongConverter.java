package com.yunjae.config;


import com.yunjae.domain.Bangsong;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Converter 추가 방식 3
 *Integer 값을 Bangsong 변경
 */
@Component
public class BangsongConverter implements Converter<String, Bangsong> {
    @Override
    public Bangsong convert(String id) {
        Bangsong bangsong = new Bangsong();
        bangsong.setId(Integer.parseInt(id));
        return bangsong;
    }
}
