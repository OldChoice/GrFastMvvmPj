package com.free.grfastmvvm.utils;

import java.util.Locale;

/**
* Create by guorui on 2021/11/16
* Last update 2021/11/16
* Description:手机系统类
**/
public class SystemUtil {

	/**
	 * 获取当前手机系统语言。
	 *
	 * @return 返回当前系统语言。例如：当前设置的是“中文-中国”，则返回“zh-CN”
	 */
	public static String getSystemLanguage() {
		return Locale.getDefault().getLanguage();
	}

	/**
	 * 获取当前系统上的语言列表(Locale列表)
	 *
	 * @return  语言列表
	 */
	public static Locale[] getSystemLanguageList() {
		return Locale.getAvailableLocales();
	}

	/**
	 * 获取当前手机系统版本号
	 *
	 * @return  系统版本号
	 */
	public static String getSystemVersion() {
		return android.os.Build.VERSION.RELEASE;
	}

	/**
	 * 获取手机型号
	 *
	 * @return  手机型号
	 */
	public static String getSystemModel() {
		return android.os.Build.MODEL;
	}

	/**
	 * 获取手机厂商
	 *
	 * @return  手机厂商
	 */
	public static String getDeviceBrand() {
		return android.os.Build.BRAND;
	}

}