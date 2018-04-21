package com.eveino.engine.regex;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.dom4j.DocumentException;

import com.eveino.entity.Vuln;
import com.eveino.utils.FileUtil;
import com.eveino.utils.RegexpUtil;
import com.eveino.utils.XmlUtil;

/***
 * 
 * @author 小王子
 * @version 0.0.1
 */
public class RegexDetect {

	/***
	 * 
	 * @param dir
	 *            项目根目录，递归
	 * @param suffix
	 *            需要搜索文件的后缀，为空则搜索所有后缀
	 * @param buffw
	 *            用于写结果文件
	 * @param rulesPath
	 *            规则根目录
	 * @throws IOException
	 * @throws DocumentException
	 */
	public static void analysisFile(File dir, String[] suffix, Writer buffw, String rulesPath)
			throws IOException, DocumentException {
		File[] files = dir.listFiles();
		for (int x = 0; x < files.length; x++) {
			if (files[x].isDirectory()) {
				analysisFile(files[x], suffix, buffw, rulesPath);
			} else {
				if (FileUtil.suffixFile(files[x], suffix)) {
					List<Vuln> list = XmlUtil.xmlPaser(rulesPath);
					for (Vuln v : list) {
						StringBuffer stringBuffer = RegexpUtil.regexpParser(files[x], v.getRegexp());
						if (stringBuffer.length() > 0) {
							buffw.write(files[x].getPath() + "\n");
							buffw.write((v.getName() + "\n"));
							buffw.write(v.getId() + "\n");
							buffw.write((v.getDecription() + "\n"));
							buffw.write(v.getRecommendation() + "\n");
							buffw.write(v.getReference() + "\n");
							buffw.write(stringBuffer.toString() + "\n");
							buffw.flush();
						}
					}
				}
			}
		}
	}

}