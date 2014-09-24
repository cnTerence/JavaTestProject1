package vargas.dgsd22.prop;

import java.util.ResourceBundle;

public class PropertyManagerMatch extends PropertyManager {

	private static final String ENC = "ISO-8859-1";
	private static final String PROP_MATCH_HTML_PARSER = "matchHtmlParser";
	private static ResourceBundle matchHtmlParser;
	
	public static void init(){
		matchHtmlParser = ResourceBundle.getBundle(PROP_MATCH_HTML_PARSER);
	}
	
	public static String getParameter(String key){
		return getValueByKey(key, matchHtmlParser, ENC);
	}
}
