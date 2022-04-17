package com.arminzheng.converter;

import lombok.Data;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * MyDateConverter
 *
 * @author zy
 * @version 2022/4/18
 */
@Data
public class MyDateConverter implements Converter<String, Date> {

    private String pattern;

    /**
     * @param source 代表配置文件中日期字符串
     * @return 转换好后的日期类型
     */
    @Override
    public Date convert(String source) {
        Date parse = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            parse = simpleDateFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }
}
