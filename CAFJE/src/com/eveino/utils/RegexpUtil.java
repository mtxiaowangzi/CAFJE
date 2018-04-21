package com.eveino.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/***
 * 
 * @author 小王子
 * @version 0.0.1 正则匹配
 */
public class RegexpUtil {
	/***
	 * 
	 * @param file
	 *            传入需匹配的文件
	 * @param regex
	 *            传入正则
	 * @return 匹配后的StringBuffer，正则对应文件的行号和所在行，为空则不存在
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static StringBuffer regexpParser(File file, String regex) throws FileNotFoundException, IOException {
		Pattern pattern = Pattern.compile(regex.toLowerCase());
		LineNumberReader lnr = new LineNumberReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
		String line = null;
		StringBuffer stringBuffer = new StringBuffer();
		while ((line = lnr.readLine()) != null) {
			Matcher matcher = pattern.matcher(line.toLowerCase());
			if (matcher.find()) {
				stringBuffer.append(lnr.getLineNumber() + ":" + line + "\n");
			}
		}
		lnr.close();
		return stringBuffer;
	}
}
