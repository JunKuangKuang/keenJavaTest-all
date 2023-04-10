package xyz.clzly.keen.utils;


import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.regex.Pattern;

public class CommonUtils {
	/**
	 * 传入对象是否全部为null
	 * @param objects
	 * @return
	 */
	public static boolean isAllNull(Object... objects) {
		
		if (objects == null) {
			return true;
		}
		
		for (Object obj : objects) {
			if (obj != null) {
				return false;
			}
		}
		return true;
	}
	/**
	 * 传入的字符串全部为null或空串
	 * @param strings
	 * @return
	 */
	public static boolean isAllBlank(String... strings) {
		if (strings == null) {
			return true;
		}
		for (String str : strings) {
			if (!StringUtils.isBlank(str)) {
				return false;
			}
		}
		return true;
	}
	/**
	 * 传入的集合全部为null或empty
	 * @param collections
	 * @return
	 */
	public static boolean isAllEmpty(Collection<?>... collections) {
		if (collections == null) {
			return true;
		}
		for (Collection<?> coll : collections) {
			if (!CollectionUtils.isEmpty(coll)) {
				return false;
			}
		}
		return true;
	}
	/**
	 * 如果str的长度超过limitLength，  截取0~limitLength
	 * @param str
	 * @param limitLength
	 * @return
	 */
	public static String subStringIfOverlength(String str, int limitLength) {
		if (StringUtils.isBlank(str)) {
			return str;
		}
		if (limitLength <= 0) {
			return "";
		}
		if (str.length() > limitLength) {
			return str.substring(0, limitLength);
		}
		return str;
	}
	/**
	 * 传入多个对象，只要有一个是null,返回ture
	 * @param objs
	 * @return
	 */
	public static boolean isContainNull(Object... objs) {
		if (objs == null) {
			return true;
		}
		for (Object obj : objs) {
			if (obj == null) {
				return true;
			}
		}
		return false;
	}
	/**
	 * 传入多个字符串，只要有一个isBlank,返回true
	 * @param strs
	 * @return
	 */
	public static boolean isContainBlank(String... strs) {
		if (strs == null) {
			return true;	
		}
		for (String str : strs) {
			if (StringUtils.isBlank(str)) {
				return true;
			}
		}
		return false;
	}
	
	/**
     * 检查是否字符编号strNo去掉前缀noPrefix后，可以转换成数字 id
     * @param strNo     字符编号
     * @param noPrefix  编号前缀
     * @return
     */
    public static boolean canTransformStrNo(String strNo, String noPrefix) {
    	return null != transformStrNo(strNo, noPrefix);
    }
    /**
     * 将字符编号strNo去掉前缀noPrefix，然后转换成long id
     * @param strNo     字符编号
     * @param noPrefix  编号前缀
     * @return
     */
    public static Long transformStrNo(String strNo, String noPrefix) {
    	if (isContainBlank(strNo, noPrefix)) {
            return null;
        }
    	if (strNo.startsWith(noPrefix)) {
        	try {
        		return Long.valueOf(strNo.substring(noPrefix.length()));
        	} catch (Exception ex) {}
        }
        return null;
    }
    
    /**
     * value是targets中的任意一个，则返回ture
     * @param value
     * @param targets
     * @return
     */
    public static boolean isOneOf(Object value, Object... targets) {
    	if (value == null) {
    		if (isContainNull(targets)) {
    			return true;
    		}
    		return false;
    	}
    	
    	if (targets == null) {
    		return false;
    	}
    	
    	for (Object temp : targets) {
    		if (value.equals(temp)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    /**
     * 是否是整数
     * @param str
     * @return
     */
    public static boolean isDigits(String str) {
    	if (StringUtils.isBlank(str)) {
    		return false;
    	}
    	return Pattern.compile("^[-\\+]?[\\d]*$").matcher(str).matches();
    }


    public static Date parseDate(String date, String formate) {
    	if (isContainNull(date, formate)) {
    		return null;
    	}
    	try {
	    	SimpleDateFormat dateFormat = new SimpleDateFormat(formate);
	    	return dateFormat.parse(date);
    	} catch (Exception ex) {
    	}
    	return null;
    }

    public static String formatDate(Date date, String formate) {
    	if (isContainNull(date, formate)) {
    		return null;
    	}
    	try {
    		SimpleDateFormat dateFormat = new SimpleDateFormat(formate);
	    	return dateFormat.format(date);
    	} catch (Exception ex) {
    	}
    	return null;
    }
    /**
     * 重新格式化日期
     *
     * reFormatDate(null, "222")                          ---->  null
     * reFormatDate("222", null)                          ---->  null
     * reFormatDate("2014-06-07", "666")                  ---->  null
     * reFormatDate("2014-06-08 00:45:34", "yyyy-MM-dd")  ---->  2014-06-08
     * reFormatDate("2017-07-07", "yyyy-MM-dd")           ---->  2017-07-07
     *
     * @param date
     * @param formate
     * @return
     */
    public static String reFormatDate(String date, String formate) {
    	return formatDate(parseDate(date, formate), formate);
    }

	/**
	 *
	 * @param dateStr 要验证的日期字符串
	 * @param format 目标日期格式
	 * @return  true：格式正确
	 */
	public static boolean isValidDate(String dateStr,String format){
		try {
			// 指定日期格式
			SimpleDateFormat dateFormat = new SimpleDateFormat(format);
			// 设置lenient为false. 否则SimpleDateFormat会比较宽松的验证日期，比如2004/02/29会被接受，并转换成2004/03/01
			dateFormat.setLenient(false);
			dateFormat.parse(dateStr);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 是否地址解析   0-不解析    1-解析(客户编码)   2-订单地址解析
	 */
	public static final Byte ADDRESS_ANALYSIS_ON = 1;

	public static final Byte ORDER_ADDRESS_ANALYSIS_ON = 2;
	
	// public static boolean needAddressAnalysis(Order order) {
	// 	return ADDRESS_ANALYSIS_ON.equals(order.getAddrAnalysis());
	// }

	public static boolean bothEmptyOrNot(String str1, String str2) {
		return allEmptyOrNot(str1, str2);
	}

	/**
	 * 对比多个字符串 是否 都为空 或 都不为空
	 *
	 * @param strs
	 * @return 返回true则一致, false则其中一个为空
	 */
	public static boolean allEmptyOrNot(String... strs) {
		if (isAllBlank(strs)) {
			return true;
		}
		if (!isContainBlank(strs)) {
			return true;
		}
		return false;
	}

	/**
	 * 源字符串经过分隔符切割后, 是否包含目标字符串
	 *
	 * @param srcStr 源字符串
	 * @param regex  分割符
	 * @param tarStr 目标字符串
	 * @return
	 */
	public static boolean isContainStr(String srcStr, String regex, String tarStr) {
		if (srcStr == null) {
			return tarStr == null;
		}
		if (tarStr == null) {
			return false;
		}
		if (regex == null) {
			return false;
		}
		return isOneOf(tarStr, srcStr.split(regex));

	}

	public static  String defaultIfBlank(String targetValue,String defaultValue){
		if(StringUtils.isNotBlank(targetValue)){
			return targetValue;
		}
		return  defaultValue;
	}

	/**
	 * 双字节匹配器
	 */
	private static final Pattern DOUBLE_BYTE_PATTERN = Pattern.compile("[^\\x00-\\xff]");
	/**
	 * 获取一个字符串的字节长度。（java使用unicode编码，一个字符就能标识一个汉字，但汉字是两个字节存储）
	 *
	 * 示例：
	 *   lengthByByte(null) 	= 0
	 *   lengthByByte("") 		= 0
	 *   lengthByByte(" ")     	= 1
	 *   lengthByByte("1a@")   	= 3
	 *   lengthByByte("你䵔㜱") 	= 6
	 *
	 * @param str
	 * @return
	 */
	public static int lengthByByte(String str) {
		if (str == null) {
			return 0;
		}
		return DOUBLE_BYTE_PATTERN.matcher(str).replaceAll("**").length();
	}

	/**
	 * Integer转String
	 *
	 * @param value
	 * @return
	 */
	public static String parseToString(Integer value) {
        return value == null ? null : value.toString();
    }
}
