package vargas.dgsd22.common;

public class Url {

	private final static String basic = "";
	
	public static String getBasic(String dt){
		return basic.replace("${0}", dt);
	}
}
