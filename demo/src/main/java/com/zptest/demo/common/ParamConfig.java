package com.zptest.demo.common;

import com.zptest.demo.util.PropertiesLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * 应用的配置.
 */
public class ParamConfig {
	protected static Properties prop;
	protected static Logger logger = LoggerFactory.getLogger(ParamConfig.class);

	static {
		init();
	}

	public static void init() {
		try {
			//默认读取classpath/message目录下的所有配置文件
//			URL classPtah = ParamConfig.class.getResource("/");

            //weblogic使用class文件部署时，上面代码取到的路径错误，改为如下方式：
            URL classPtah = ParamConfig.class.getClassLoader().getResource("/");
			File classpathFile = new File(classPtah.getPath() + File.separator + "config");
			logger.info("ParamConfig.init():classPtah[{}],classpathFile[{}]", classpathFile, classpathFile);
			File[] files = classpathFile.listFiles();
			String[] filesPath = new String[files.length];
			int index = 0;

			//配置文件路径头
			String head = "classpath:/config/";
			for (File file : files) {
				//是properties配置文件
				if (file.isFile() && file.getName().endsWith(".properties")) {
					filesPath[index] = head + file.getName();
					index++;
				}
			}

			//classpath后面不能加星.
			//指定编码UTF-8
			PropertiesLoader propertiesLoader = new PropertiesLoader(
					Charset.forName("UTF-8"), filesPath);

			prop = propertiesLoader.getProperties();
		} catch (Exception e) {
			logger.error("加载属性文件失败", e);
		}
	}

	public static int getInt(String key, int defaultValue) {
		if (prop.getProperty(key) != null) {
			return Integer.parseInt(prop.getProperty(key));
		}
		return defaultValue;
	}

	public static long getLong(String key, long defaultValue) {
		if (prop.getProperty(key) != null) {
			return Long.parseLong(prop.getProperty(key));
		}
		return defaultValue;
	}

	public static String getString(String key, String defaultValue) {
		if (prop.getProperty(key) != null) {
			return prop.getProperty(key);
		}
		return defaultValue;
	}

	public static String getString(String key) {
		if (prop.getProperty(key) != null) {
			return prop.getProperty(key);
		}
		logger.error("");
		return null;
	}

	public static String getStringWithEncode(String key, String charset) {
		if (prop.getProperty(key) != null) {
			return prop.getProperty(key);
		}
		logger.error("");
		return null;
	}

	public static String getStringWithParam(String key, String... msgParams) {
		String targetStr = getString(key);
		if(targetStr == null) {
			return key;
		} else {
			if(msgParams != null && msgParams.length > 0) {
				for(int i = 0; i < msgParams.length; ++i) {
					String str = msgParams[i];;
					if(null != str) {
						str = str.replaceAll("\\\\", "\\\\\\\\");
						str = str.replaceAll("\\$", "\\\\\\$");
						targetStr = targetStr.replaceAll("\\{" + i + "\\}", str);
					}
				}
			}

			return targetStr;
		}
	}
}
