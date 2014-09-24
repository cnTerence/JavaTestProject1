package vargas.dgsd22.prop;

import java.util.Map;
import java.util.ResourceBundle;

public class PropertyManagerExpert extends PropertyManager {

	private static final String ENC_EXPERTS = "UTF-8";
	private static final String ENC_EXPERTS_HTML_PARSER = "ISO-8859-1";
	private static final String PROP_EXPERTS = "expert";
	private static final String PROP_EXPERTS_HTML_PARSER = "expertHtmlParser";
	private static ResourceBundle expert;
	private static ResourceBundle expertHtmlParser;
	
	public static void init(){
		expert = ResourceBundle.getBundle(PROP_EXPERTS);
		expertHtmlParser = ResourceBundle.getBundle(PROP_EXPERTS_HTML_PARSER);
	}
	
	public static Map<String, String> getAllExperts(){
		return getAllValues(expert, ENC_EXPERTS);
	}
	
	public static String getParameter(String key){
		return getValueByKey(key, expertHtmlParser, ENC_EXPERTS_HTML_PARSER);
	}
}
