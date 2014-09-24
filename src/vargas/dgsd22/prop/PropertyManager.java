package vargas.dgsd22.prop;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

abstract class PropertyManager {
	
	private static final String ENC_ISO8859 = "ISO-8859-1";
	
	protected static Map<String, String> getAllValues(ResourceBundle rb, String enc){
		
		Map<String, String> values = new HashMap<String, String>();
		Enumeration<String> enumeration = rb.getKeys();
		String key;
		
		while(enumeration.hasMoreElements()){
			key = enumeration.nextElement();
			values.put(key, getValueByKey(key, rb, enc));
		}
		
		return values;
	}
	
	protected static String getValueByKey(String key, ResourceBundle rb, String enc){
		if(ENC_ISO8859.equals(enc)){
			return rb.getString(key);	
		}else{
			return transformCode(rb.getString(key), enc);	
		}
	}
	
	private static String transformCode(String s, String targetEnc){
		try {
			return new String(s.getBytes(ENC_ISO8859), targetEnc);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
