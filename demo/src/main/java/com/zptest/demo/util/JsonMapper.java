package com.zptest.demo.util;

//import net.sf.json.JSONObject;
//import org.apache.commons.lang3.StringUtils;
//import org.codehaus.jackson.JsonGenerator;
//import org.codehaus.jackson.JsonParser;
//import org.codehaus.jackson.JsonProcessingException;
//import org.codehaus.jackson.map.*;
//import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
//import org.codehaus.jackson.map.util.JSONPObject;
//import org.codehaus.jackson.type.JavaType;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.IOException;
import java.lang.reflect.Field;

/**
 * @Description JSON的工具类
 * @author liuzhaoq
 * @Create at 2012-11-16 上午11:19:14
 * @modify 上午11:19:14
 */
public class JsonMapper {

	private ObjectMapper mapper;

	public JsonMapper(JsonSerialize.Inclusion inclusion) {
		mapper = new ObjectMapper();
		// 设置输出时包含属性的风格
		mapper.getSerializationConfig().setSerializationInclusion(inclusion);
		// 设置输入时忽略在JSON字符串中存在但Java对象实际没有的属性
		mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		// 禁止使用int代表Enum的order()來反序列化Enum,非常危险
		mapper.configure(DeserializationConfig.Feature.FAIL_ON_NUMBERS_FOR_ENUMS, true);
	}

	/**
	 * 创建输出全部属性到Json字符串的Mapper.
	 */
	public static JsonMapper buildNormalMapper() {
		return new JsonMapper(JsonSerialize.Inclusion.ALWAYS);
	}

	/**
	 * 创建只输出非空属性到Json字符串的Mapper.
	 */
	public static JsonMapper buildNonNullMapper() {
		return new JsonMapper(JsonSerialize.Inclusion.NON_NULL);
	}

	/**
	 * 创建只输出初始值被改变的属性到Json字符串的Mapper.
	 */
	public static JsonMapper buildNonDefaultMapper() {
		return new JsonMapper(JsonSerialize.Inclusion.NON_DEFAULT);
	}

	/**
	 * 如果JSON字符串为Null或"null"字符串, 返回Null. 如果JSON字符串为"[]", 返回空集合.
	 * 
	 * 如需读取集合如List/Map, 且不是List<String>这种简单类型时使用如下语句,使用后面的函数.
	 */
	public <T> T fromJson(String jsonString, Class<T> clazz) {
		if (StringUtils.isEmpty(jsonString)) {
			return null;
		}

		try {
			return mapper.readValue(jsonString, clazz);
		} catch (IOException e) {
			return null;
		}
	}

	/**
	 * 如果JSON字符串为Null或"null"字符串, 返回Null. 如果JSON字符串为"[]", 返回空集合.
	 * 
	 * 如需读取集合如List/Map, 且不是List<String>時, 先用constructParametricType(List.class,MyBean.class)构造出JavaTeype,再調用本函数.
	 */
	@SuppressWarnings("unchecked")
	public <T> T fromJson(String jsonString, JavaType javaType) {
		if (StringUtils.isEmpty(jsonString)) {
			return null;
		}

		try {
			return (T) mapper.readValue(jsonString, javaType);
		} catch (IOException e) {
			return null;
		}
	}

	/**
	 * 构造泛型的Type如List<MyBean>, Map<String,MyBean>
	 */
	public JavaType constructParametricType(Class<?> parametrized, Class<?>... parameterClasses) {
		return mapper.getTypeFactory().constructParametricType(parametrized, parameterClasses);
	}

	/**
	 * 如果对象为Null, 返回"null". 如果集合为空集合, 返回"[]".
	 */
	public String toJson(Object object) {

		try {
			return mapper.writeValueAsString(object);
		} catch (IOException e) {
			return null;
		}
	}

	/**
	 * 当JSON里只含有Bean的部分属性時，更新一个已存在Bean，只覆部分的属性.
	 */
	@SuppressWarnings("unchecked")
	public <T> T update(T object, String jsonString) {
		try {
			return (T) mapper.updatingReader(object).readValue(jsonString);
		} catch (JsonProcessingException e) {
		} catch (IOException e) {
		}
		return null;
	}

	/**
	 * 输出JSONP格式数据.
	 */
	public String toJsonP(String functionName, Object object) {
		return toJson(new JSONPObject(functionName, object));
	}

	/**
	 * 設定是否使用Enum的toString函数来读写Enum, 为False时时使用Enum的name()函数来读写Enum, 默认为False. 注意本函数一定要在Mapper创建后, 所有的读写动作之前調用.
	 */
	public void setEnumUseToString(boolean value) {
		mapper.getSerializationConfig().set(SerializationConfig.Feature.WRITE_ENUMS_USING_TO_STRING, value);
		mapper.getDeserializationConfig().set(DeserializationConfig.Feature.READ_ENUMS_USING_TO_STRING, value);
	}

	/**
	 * 取出Mapper做进一步的设置或使用其他序列化API.
	 */
	public ObjectMapper getMapper() {
		return mapper;
	}
	
	public static JsonMapper buildMapper(){
		return new JsonMapper();
	}
	
	public JsonMapper()  {  
		mapper = new ObjectMapper();
        // 允许单引号   
		mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        // 字段和值都加引号   
		mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        // 数字也加引号   
		mapper.configure(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS, true);
		mapper.configure(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS, true);
        // 空值处理为空串   
		mapper.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>()
        {   
            @Override   
            public void serialize(   
                    Object value,   
                    JsonGenerator jg,
                    SerializerProvider sp) throws IOException, JsonProcessingException
            {   
                jg.writeString("");   
            }   
        });   
    }

	public static JSONObject changeJson(Object object) throws Exception {
		JSONObject jb = new JSONObject(); //声明json对象
		Class c = object.getClass();  //获取类的类型类
		Field[] fields = c.getDeclaredFields(); //获取属性集合
		Field.setAccessible(fields, true); //在类外面要想获取私有属性的值必须设置
		Object[] name = new Object[fields.length]; //存储变量名
		Object[] value = new Object[fields.length]; //存储变量值
		Object[] type = new Object[fields.length]; //存储变量类型
		for (int i = 0; i < fields.length; i++) { //设置数组的值
			name[i] = fields[i].getName();
			value[i] = fields[i].get(object);
			type[i] = fields[i].getType();
		}
		for (int i = 0; i < name.length; i++) {
			String s1 = type[i].toString(); //变量类型
			String v1 = value[i] + ""; //变量值
			String n1 = name[i].toString(); //变量名
			if (s1.contains("String")) {
				if (!v1.equals("null")) {
					jb.put(n1, v1); //给jsonobject设置key-value
				}
			} else if (s1.contains("long")) {
				jb.put(n1, Integer.parseInt(v1));
			} else if (s1.contains("int")) {
				jb.put(n1, Integer.parseInt(v1));
			}
		}
		return jb;
	}


	/**
	 * 将恒生返回的结果转换成我们的结果类型
	 *
	 * @param response
	 */
//	public void putHsResponseToResponse(STBaseResp response) {
//		if (response != null) {
//			Method[] methods = this.getClass().getMethods();
//			for (Method method : methods) {
//				String methodName = method.getName();
//				if (methodName.startsWith("set")) {
//					char c = (char) (methodName.charAt(3) + 32);
//					//参数名称
//					String paramName = c + methodName.substring(4);
//					try {
//						//是否是特殊的字段  特殊字段就是说 是所以一个子集的 而不是一个字段
//						method.invoke(this, isEspecial(paramName) ? response.getList(paramName) : response.getObject(paramName));
//					} catch (Exception e) {
////						logger.error(e);
////						throw new UmException(e.getMessage());
//					}
//				}
//			}
//		}
//	}

}
