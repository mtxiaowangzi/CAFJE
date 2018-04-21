package com.eveino.engine;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Properties;

import org.dom4j.DocumentException;

import com.eveino.engine.regex.RegexDetect;
import com.eveino.utils.FileUtil;
import com.eveino.utils.UseUtil;

/***
 * 
 * @author 小王子
 * @version 0.0.1
 */
public class MainEngine {
	private static final Properties properties = new Properties();

	public static void main(String[] args) throws IOException, DocumentException {
		// 外部传入配置文件路径
		if (args.length!=1 || !"config.properties".equals(args[0])) {
			UseUtil.usage();
		}
		properties.load(new FileInputStream(args[0]));

		// 项目中配置文件路径
		// properties.load(new FileInputStream("src/config.properties"));

		System.out.println("扫描开始...");
		Long time1 = System.currentTimeMillis();
		File projectRoot = new File(properties.getProperty("projectRoot"));
		// 判断项目路径是否存在
		if (!FileUtil.checkFileExist(projectRoot)) {
			System.err.println(projectRoot + " 不存在.\n请确认项目根目录");
			System.exit(0);
		}
		String suffix = properties.getProperty("suffix");
		String[] suffixs = null;
		// 判断suffix是否空，不为空则配置有后缀，分割成数组
		if (!suffix.equals("") || suffix.length() != 0) {
			suffixs = suffix.split(",");
		}
		String rulesPath = properties.getProperty("rulesPath");
		// 在项目根目录生成扫描结果
		File result = new File(projectRoot + File.separator + "resultCAFJE.txt");
		BufferedWriter buffw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(result), "UTF-8"));
		// engineRegex
		RegexDetect.analysisFile(projectRoot, suffixs, buffw, rulesPath);
		// TODO 其他引擎
		Long time2 = System.currentTimeMillis();
		String time = Long.toString(time2 - time1);
		System.out.println("耗时:" + time + "毫秒");
		buffw.write("耗时:" + time + "毫秒");
		buffw.close();
	}

}
