package com.kgc.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;



//时间格式转换
public class ClientDateFormat extends JsonSerializer<Date>{

	@Override
	public void serialize(Date value, JsonGenerator jg, SerializerProvider arg2)
			throws IOException, JsonProcessingException {
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String str=sdf.format(value);
		jg.writeString(str);
	}  

}
