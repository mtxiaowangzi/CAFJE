package com.eveino.utils;

import java.io.File;

public class FileUtil {
	/***
	 * 判断传入文件的后缀是否包含在给定的后缀数组中
	 * @param file
	 * @param suffix
	 * @return
	 */
	public static boolean suffixFile(File file, String[] suffix) {
		if (suffix == null || suffix.length == 0) {
			return true;
		}
		boolean flag = false;
		String fileSuffix = file.getName().substring(file.getName().lastIndexOf(".") + 1);
		for (String suf : suffix) {
			if (suf.equals(fileSuffix)) {
				flag = true;
			}
		}
		return flag;
	}

	/***
	 * 判断文件是否存在
	 * @param file
	 * @return
	 */
	public static boolean checkFileExist(File file) {
		if (file.exists()) {
			return true;
		}
		return false;
	}
}
