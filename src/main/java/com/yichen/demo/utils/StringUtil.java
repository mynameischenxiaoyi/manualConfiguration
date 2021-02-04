package com.yichen.demo.utils;

import org.springframework.util.StringUtils;

/**
 * @author 陈易chenyi01
 * @version 1.0
 * @date 2021/2/4 7:40 下午 phone 13172680119
 */

public final class StringUtil {

  /**
   * 字符串分隔符
   */
  public static final String SEPARATOR = String.valueOf((char) 29);

  /**
   * 判断字符串是否为空
   */
  public static boolean isEmpty(String str) {
    if (str != null) {
      str = str.trim();
    }
    return StringUtils.isEmpty(str);
  }

  /**
   * 判断字符串是否非空
   */
  public static boolean isNotEmpty(String str) {
    return !isEmpty(str);
  }


}