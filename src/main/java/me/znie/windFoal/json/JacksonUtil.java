package me.znie.windFoal.json;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * jackson操作
 * @author znie
 *
 */
public class JacksonUtil {

	private static final Log log = LogFactory.getLog(JacksonUtil.class);

	private static ObjectMapper mapper = new ObjectMapper()
//			.setSerializationInclusion(Include.NON_NULL)
			.enable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
			.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
			.enable(MapperFeature.USE_ANNOTATIONS);
	
	
	/**
	 * json转对象
	 * @param json
	 * @param valueType
	 * @return
	 */
	public static <T> T toObj(String json,Class<T> valueType){
		try{
			return mapper.readValue(json, valueType);
		}catch (Exception e) {
			log.error("ERROR", e);
		}
		return null;
	}
	
	
	/**
	 * 对象转json
	 * @param value
	 * @return
	 */
	public static String tojson(Object value){
		try{
			return mapper.writeValueAsString(value);
		}catch (Exception e) {
			log.error("ERROR",e);
		}
		return null;
	}

	public static void main(String[] args){

	}
}
