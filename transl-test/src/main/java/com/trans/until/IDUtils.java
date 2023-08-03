package com.trans.until;

import cn.hutool.core.util.RandomUtil;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 各种id生成策略
 * <p>Title: IDUtils</p>
 * <p>Description: </p>
 * @author
 * @version 1.0
 */
public class IDUtils {
    /**
     * 生成合同业务编号
     * 各业务方创建合同时生成的唯一标识号，商品材料板块编号为：101，由101+日期+随机不重复9位数，例如：10120210530123456789
     * @return
     */
    public static String genContractNo(Integer source){
        String pre="";
        if(source<10){
            pre="10"+source;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String result =pre+ sdf.format(new Date());
        result = result + RandomUtil.randomNumbers(9);
        return result;
    }

	/**
	 * 图片名生成
	 */
	public static String genImageName() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//long millis = System.nanoTime();
		//加上三位随机数
		Random random = new Random();
		int end3 = random.nextInt(999);
		//如果不足三位前面补0
		String str = millis + String.format("%03d", end3);
		
		return str;
	}
	
	/**
	 * 商品id生成
	 */
	public static long genItemId() {
		//取当前时间的长整形值包含毫秒
		long millis = System.currentTimeMillis();
		//long millis = System.nanoTime();
		//加上两位随机数
		Random random = new Random();
		int end2 = random.nextInt(99);
		//如果不足两位前面补0
		String str = millis + String.format("%02d", end2);
		long id = new Long(str);
		return id;
	}
	
	/**
	 * 
	 *<P>开发者:chengh
	 *<P>方法名: randomNo
	 *<P>描述: 生成业务编码
	 *@return   
	 *@exception   
	 *@since  1.0.0
	 */
	public static String randomNo() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmssSSS");
		String result = sdf.format(new Date());
		return result;
	}

	/**
	 * <p>描述:   根据Id判断是否新增
	 * <p>开发者: GHQ·阿甘
	 * <p>时间:   2020/7/20 12:02
	 *
	 * @param id
	 * @return  java.lang.Boolean
	 * @throws
	 **/
	public static Boolean verfyIsInsert(Long id){
		if (null == id || id == 0){
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}


}
