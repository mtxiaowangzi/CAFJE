package com.eveino.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.eveino.entity.Vuln;

/***
 * 
 * @author 小王子
 * @version 0.0.1 操作XML文件
 */
public class XmlUtil {

	/***
	 * 将XML转换成到Vuln实体
	 * 
	 * @param file
	 *            规则文件
	 * @return 封装Vuln实体的list
	 * @throws DocumentException
	 */
	public static List<Vuln> xml2Bean(File file) throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(file);
		Element root = document.getRootElement();
		List<Vuln> list = new ArrayList<>();
		List<Element> elements = root.elements("vuln");
		for (Element element : elements) {
			Vuln vuln = new Vuln();
			vuln.setName(element.attributeValue("name"));
			vuln.setId(element.attributeValue("id"));
			vuln.setRegexp(element.elementText("regexp"));
			vuln.setDecription(element.elementText("decription"));
			vuln.setRecommendation(element.elementText("recommendation"));
			vuln.setReference(element.elementText("reference"));
			list.add(vuln);
		}
		return list;
	}

	/***
	 * 解析规则根目录中的xml文件
	 * 
	 * @param rulesPath
	 *            配置文件根目录
	 * @return 封装规则的list
	 * @throws DocumentException
	 */
	public static List<Vuln> xmlPaser(String rulesPath) throws DocumentException {
		String[] suffix = { "xml" };
		File file = new File(rulesPath);
		File[] files = file.listFiles();
		List<Vuln> list = new ArrayList<>();
		for (File f : files) {
			if (FileUtil.suffixFile(f, suffix)) {
				list.addAll(XmlUtil.xml2Bean(f));
			}
		}
		return list;
	}
}
