package vargas.dgsd22.common;

import vargas.dgsd22.prop.ExpertKey;
import vargas.dgsd22.prop.MatchKey;
import vargas.dgsd22.prop.PropertyManagerExpert;
import vargas.dgsd22.prop.PropertyManagerMatch;

public class Url {
	
	public static String getMatchBasicSite(String dt){
		return PropertyManagerMatch.getParameter(MatchKey.KEY_BASIC_SITE).replace("${0}", dt);
	}
	
	public static String getExpertSite(String uid){
		return PropertyManagerExpert.getParameter(ExpertKey.KEY_SITE).replace("${0}", uid);
	}
}
