package com.photoknow.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Locale;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

public class StringUtil {
	public static long G = 1024L * 1024L * 1024L;
	public static long K = 1024L;
	public static long M = 1024L * 1024L;
	public static long T = 1024L * 1024L * 1024L * 1024L;
	public static final String REGEX_VALID_CODE = "^[[\\w]+[ ()<>{}`~!@#$%&*+=;'/\"\\~\\.\\:\\[\\]\\^\\|\\?"
            + "\\-\\\\]+]+$";

    /**
     * check whether the search criteria indicates to perform a fuzzy query.
     *
     * @param searchCriteria
     * @return
     */
    public static boolean isFuzzyQuery(final String searchCriteria) {
        boolean bool = false;
        if (StringUtils.isEmpty(searchCriteria)) {
            bool = false;
            //return false;
        }
        if (searchCriteria.indexOf("%") != -1) {
            bool = true;
            //            return true;
        }
        return bool;
    }
    /**
     * check Object obj is null
     * @param obj
     * @return
     */
    public static boolean isEmpty(final Object obj) {
        if (null != obj && !"".equals(obj)) {
            return false;
        }
        return true;
    }
    /**
     * check Object obj is not null
     * @param obj
     * @return
     */
    public static boolean isNotEmpty(final Object obj) {
        return !isEmpty(obj);
    }
	public static String camelize(String underscoredString) {
		return toCamelCase(underscoredString);
	}

	public static String chop(String x, int maxLen) {
		if (x == null)
			return x;
		if (x.length() > maxLen)
			x = x.substring(0, maxLen);
		return x;
	}

	public static String chopByBytes(String x, int maxBytes) {
		if (x == null)
			return x;

		byte[] bytes = x.getBytes();

		if (bytes.length > maxBytes) {
			x = new String(bytes, 0, maxBytes);
		}
		return x;
	}

	public static int compare(String a, String b) {
		if (a == b)
			return 0; // if same instance or both is null

		if (a != null && b != null)
			return a.compareTo(b); // string compare

		return (a == null) ? -1 : 1;
	}

	public static String decamelize(String txt) {
		if (txt == null)
			return "";
		StringBuilder ret = new StringBuilder();

		boolean wasUpper = true;
		for (int i = 0; i < txt.length(); i++) {
			char ch = txt.charAt(i);
			boolean isUpper = Character.isUpperCase(ch);

			if (!wasUpper && isUpper)
				ret.append('_');
			ret.append(Character.toLowerCase(ch));

			wasUpper = isUpper;
		}

		return ret.toString();
	}

	public static String formatDouble(double value, String format) {
		DecimalFormat formatter = new DecimalFormat(format);

		return formatter.format(value);
	}

	/**
	 * Format an integer
	 * 
	 * Example
	 * ------------------------------------------------------------------------
	 * Format String Value Output
	 * ------------------------------------------------------------------------
	 * 0000 123 0123 ##00 3 03 .00 0.234 .23 0.00 0.234 0.23 #,###,### 12345
	 * 12,345 #;(#) -123 (123)
	 * 
	 * @param value
	 *            an integer value
	 * @param format
	 *            a format string
	 * @return Formatted string in specified format
	 * 
	 */
	public static String formatInteger(long value, String format) {
		DecimalFormat formatter = new DecimalFormat(format);

		return formatter.format(value);
	}

	public static String formatSize(long size, boolean showZeroFields) {
		if (!showZeroFields && size == 0)
			return "0 b";

		long tbytes = size / T;
		size = size % T;
		long gbytes = size / G;
		size = size % G;
		long mbytes = size / M;
		size = size % M;
		long kbytes = size / K;
		size = size % K;
		long bytes = size;

		StringBuilder sb = new StringBuilder();
		if (showZeroFields || (!showZeroFields && tbytes > 0))
			sb.append(tbytes + " T ");
		if (showZeroFields || (!showZeroFields && gbytes > 0))
			sb.append(gbytes + " G ");
		if (showZeroFields || (!showZeroFields && mbytes > 0))
			sb.append(mbytes + " M ");
		if (showZeroFields || (!showZeroFields && kbytes > 0))
			sb.append(kbytes + " K ");
		if (showZeroFields || (!showZeroFields && bytes > 0))
			sb.append(bytes + " b ");

		return sb.toString().trim();
	}

	public static String formatSize(long size, boolean showZeroFields, int nFields) {
		if (!showZeroFields && size == 0)
			return "0 b";

		long tbytes = size / T;
		size = size % T;
		long gbytes = size / G;
		size = size % G;
		long mbytes = size / M;
		size = size % M;
		long kbytes = size / K;
		size = size % K;
		long bytes = size;

		int i = 0;
		StringBuilder sb = new StringBuilder();

		if (showZeroFields || (!showZeroFields && tbytes > 0)) {
			sb.append(tbytes + " T ");
			if (++i >= nFields)
				return sb.toString().trim();
		}
		if (showZeroFields || (!showZeroFields && gbytes > 0)) {
			sb.append(gbytes + " G ");
			if (++i >= nFields)
				return sb.toString().trim();
		}
		if (showZeroFields || (!showZeroFields && mbytes > 0)) {
			sb.append(mbytes + " M ");
			if (++i >= nFields)
				return sb.toString().trim();
		}
		if (showZeroFields || (!showZeroFields && kbytes > 0)) {
			sb.append(kbytes + " K ");
			if (++i >= nFields)
				return sb.toString().trim();
		}
		if (showZeroFields || (!showZeroFields && bytes > 0)) {
			sb.append(bytes + " b ");
			if (++i >= nFields)
				return sb.toString().trim();
		}

		return sb.toString().trim();
	}

	public static String formatTimestamp(String ptn, long time) {
		SimpleDateFormat sdf = new SimpleDateFormat(ptn, Locale.US);

		return sdf.format(time);
	}

	public static boolean isDifferent(String a, String b) {
		return !isSame(a, b);
	}

	public static boolean isEmpty(String txt) {
		return txt == null || txt.length() == 0 || txt.trim().length() == 0 || "null".equals(txt);
	}

	public static boolean isEqual(String a, String b) {
		if (a == null && b == null)
			return true;
		if (a != null && b != null && a.equals(b))
			return true;
		return false;
	}

	public static boolean isInt(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isNotEmpty(String txt) {
		return !isEmpty(txt);
	}

	public static boolean isSame(String a, String b) {
		if (a == b)
			return true; // if same instance or both is null

		if (a != null && b != null)
			return a.equals(b); // string compare

		return false; // otherwise
	}

	public static String join(String sep, Collection<?> list) {
		String ret = null;

		if (list != null)
			for (Object obj : list) {
				ret = ret == null ? String.valueOf(obj) : ret + sep + String.valueOf(obj);
			}

		return ret;
	}

	public static String join(String sep, int... params) {
		String ret = null;

		if (params != null)
			for (int i = 0; i < params.length; i++) {
				ret = ret == null ? String.valueOf(params[i]) : ret + sep + String.valueOf(params[i]);
			}

		return ret;
	}

	public static String join(String sep, Object... params) {
		String ret = null;

		if (params != null)
			for (int i = 0; i < params.length; i++) {
				ret = ret == null ? String.valueOf(params[i]) : ret + sep + String.valueOf(params[i]);
			}

		return ret;
	}

	public static String join(String sep, String... params) {
		if (params == null)
			return null;

		String ret = null;

		if (params != null)
			for (int i = 0; i < params.length; i++) {
				ret = ret == null ? params[i] : ret + sep + params[i];
			}

		return ret == null ? "" : ret;
	}

	public static String join(String sep, String[] params, int offset, int len) {
		if (params == null)
			return null;

		String ret = null;

		for (int i = offset; i < params.length && i < offset + len; i++) {
			ret = ret == null ? params[i] : ret + sep + params[i];
		}

		return ret == null ? "" : ret;
	}

	public static String lPad(String txt, String paddedChar, int len) {
		if (txt == null)
			txt = "";
		int l = txt.length();

		if (l < len) {
			txt = StringUtil.pad(paddedChar, len - l) + txt;
		}

		return txt;
	}

	public static void main(String args[]) {
		System.out.println(toCamelCase("PURCHASE_ORDER_LEGACY_NUM_COLOR_CODE"));
	}
	
	public static String toString(Object object) {
		if (object != null && StringUtil.isNotEmpty(object.toString())) {
			return object.toString();
		}
		
		return "";
	}

	public static String nvl(String txt, String alternative) {
		if (isEmpty(txt))
			return alternative;
		return txt;
	}

	public static String nvl2(String txt, String alternative1, String alternative2) {
		return (isEmpty(txt)) ? alternative1 : alternative2;
	}

	public static String pad(String paddedChar, int n) {
		String ret = "";
		for (int i = 0; i < n; i++)
			ret += paddedChar;
		return ret;
	}

	public static String quoteSqlString(String txt) {
		return txt == null ? "null" : "'" + txt.replaceAll("\\'", "''") + "'";
	}

	public static String[] repeat(String txt, int n) {
		String[] ret = new String[n];

		for (int i = 0; i < n; i++)
			ret[i] = txt;

		return ret;
	}

	/**
	 * Creates string by repeating string
	 * 
	 * @param string
	 *            The string to repeat
	 * @param n
	 *            The repeat count
	 * @return repeatString The new string containing repeated substrings
	 */
	public static String repeatString(String string, int n) {
		String repeatString = "";
		int i;
		for (i = 0; i < n; i++) {
			repeatString = repeatString + string;
		}
		return repeatString;
	}

	public static String[] split(String str, String regex) {
		if (isEmpty(str))
			return null;

		return str.split(regex);
	}

	public static BigDecimal toBigDecimal(String value, BigDecimal defaultValue) {
		try {
			return new BigDecimal(value);
		} catch (Exception e) {
			return defaultValue;
		}
	}

	public static String toCamelCase(String underscoredString) {
		if (underscoredString == null)
			return "";
		String ret = underscoredString;

		ret = ret.toLowerCase();

		int pos = 0;
		while ((pos = ret.indexOf('_')) >= 0) {
			ret = ret.substring(0, pos) + ret.substring(pos + 1, pos + 2).toUpperCase() + ret.substring(pos + 2);
		}

		return ret;
	}

	public static int toInt(String value, int radix, int defaultValue) {
		try {
			return Integer.parseInt(value, radix);
		} catch (Exception e) {
			return defaultValue;
		}
	}

	public static long toLong(String value, int radix, long defaultValue) {
		try {
			return Long.parseLong(value, radix);
		} catch (Exception e) {
			return defaultValue;
		}
	}

	public static String[] toStrings(Enum<?>[] enums) {
		if (enums == null)
			return null;

		String[] ret = new String[enums.length];
		for (int i = 0; i < enums.length; i++) {
			ret[i] = enums[i].toString();
		}

		return ret;
	}

	public static String toUtf(String isoString) {
		return toUtf("ISO-8859-1", isoString);
	}

	public static String toUtf(String srcEncoding, String isoString) {
		return transcode(srcEncoding, "UTF-8", isoString);
	}

	public static String transcode(String srcEncoding, String dstEncoding, String isoString) {
		try {
			byte[] stringBytesISO = isoString.getBytes(srcEncoding);
			return new String(stringBytesISO, dstEncoding);
		} catch (Exception e) {
		}
		return isoString;
	}

	public static String trim(String text) {
		if (text == null)
			return null;
		return text.trim();
	}

	public static String trimToEmpty(String text) {
		if (text == null)
			return "";
		return text.trim();
	}

	public static String uCase(String txt) {
		if (txt == null)
			return null;
		return txt.toUpperCase();
	}
	public static boolean isFloatValue(String value){
		  boolean flag = false;
		  try {
			Float.parseFloat(value);
			flag = true;
		} catch (Exception e) {
			//e.printStackTrace();
			flag = false;
		}
		  return flag;
	  }
	public static boolean isDoubleValue(String value){
		  boolean flag = false;
		  try {
			  Double.parseDouble(value);
			flag = true;
		} catch (Exception e) {
			//e.printStackTrace();
			flag = false;
		}
		  return flag;
	  }
	 public static boolean isIntegerValue(String value){
		  boolean flag = false;
		  try {
			  Integer.parseInt(value);
			  flag = true;
		} catch (Exception e) {
			//e.printStackTrace();
			flag = false;
		}
		  return flag;
	  }
	public static boolean checkIsNotEmpty(String... vaulus){
		  boolean flag = false;
		  for(String s :vaulus){
			  if(StringUtil.isNotEmpty(s)){
				  flag = true ;
				  continue;
			  }
		  }
		   return  flag;
	   }
	
	  public static String toUtf8String(String s){ 
		     StringBuffer sb = new StringBuffer(); 
		       for (int i=0;i<s.length();i++){ 
		          char c = s.charAt(i); 
		          if (c >= 0 && c <= 255){sb.append(c);} 
		        else{ 
		        byte[] b; 
		         try { b = Character.toString(c).getBytes("utf-8");} 
		         catch (Exception ex) { 
		             System.out.println(ex); 
		                  b = new byte[0]; 
		         } 
		            for (int j = 0; j < b.length; j++) { 
		             int k = b[j]; 
		              if (k < 0) k += 256; 
		              sb.append("%" + Integer.toHexString(k).toUpperCase()); 
		              } 
		     } 
		  } 
		  return sb.toString(); 
		}
	  
	  
	  public static  String htmlToText(String inputString) {    
	      String htmlStr = inputString; //含html标签的字符串    
	      String textStr ="";    
	      java.util.regex.Pattern p_script;    
	      java.util.regex.Matcher m_script;    
	      java.util.regex.Pattern p_style;    
	      java.util.regex.Matcher m_style;    
	      java.util.regex.Pattern p_html;    
	      java.util.regex.Matcher m_html;    
	           
	      try {    
	       String regEx_script = "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>"; // 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
	       String regEx_style = "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>"; // 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
	          String regEx_html = "<[^>]+>"; //定义HTML标签的正则表达式    
	          String regEx_html2 = "[^>]+>"; //定义HTML标签的正则表达式    
	          String regEx_html3 = "<[^>]+"; //定义HTML标签的正则表达式 
	          p_script = Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE);    
	          m_script = p_script.matcher(htmlStr);    
	          htmlStr = m_script.replaceAll(""); //过滤script标签    
	    
	          p_style = Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE);    
	          m_style = p_style.matcher(htmlStr);    
	          htmlStr = m_style.replaceAll(""); //过滤style标签    
	            
	          p_html = Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE);    
	          m_html = p_html.matcher(htmlStr);    
	          htmlStr = m_html.replaceAll(""); //过滤html标签    

	          p_html = Pattern.compile(regEx_html2,Pattern.CASE_INSENSITIVE);    
	          m_html = p_html.matcher(htmlStr);    
	          htmlStr = m_html.replaceAll(""); //过滤html标签
	          
	          p_html = Pattern.compile(regEx_html3,Pattern.CASE_INSENSITIVE);    
	          m_html = p_html.matcher(htmlStr);    
	          htmlStr = m_html.replaceAll(""); //过滤html标签
	          
	       textStr = htmlStr;    
	            
	      }catch(Exception e) {    
	                  System.err.println("Html2Text: " + e.getMessage());    
	      }    
	           
	      return textStr;//返回文本字符串    
	    }
	  
	  
	  public static boolean isImage(String imgStr) {
			boolean flag = false;
			if (imgStr != null) {
				if (imgStr.equalsIgnoreCase(".gif")
						|| imgStr.equalsIgnoreCase(".jpg")
						|| imgStr.equalsIgnoreCase(".jpeg")
						|| imgStr.equalsIgnoreCase(".png")) {
					flag = true;
				}
			}
			return flag;
		}
}
