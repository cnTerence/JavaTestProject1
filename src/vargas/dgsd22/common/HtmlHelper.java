package vargas.dgsd22.common;

import vargas.dgsd22.prop.ExpertKey;
import vargas.dgsd22.prop.MatchKey;
import vargas.dgsd22.prop.PropertyManagerExpert;
import vargas.dgsd22.prop.PropertyManagerMatch;

public class HtmlHelper {
	
	//tag
	public static final String TABLE = "table";
	public static final String DIV = "div";
	public static final String A = "a";
	public static final String SPAN = "span";
	public static final String IMG = "img";
	
	//attribute
	public static final String CLASS = "class";
	public static final String SRC = "src";
	public static final String TITLE = "title";

	public static String getMatchBasicTblId(){
		return PropertyManagerMatch.getParameter(MatchKey.KEY_BASIC_TBL_ID);
	}
	
	public static String getMatchBasicRowIdPrefix(){
		return PropertyManagerMatch.getParameter(MatchKey.KEY_BASIC_ROW_ID_PREFIX);
	}
	
	public static String getMatchBasicRowIdRegx(){
		return "^(" + getMatchBasicRowIdPrefix() + ")\\d{6}$";
	}
	
	public static String getExpertResultDivClass(){
		return PropertyManagerExpert.getParameter(ExpertKey.KEY_RESULT_DIV_CLASS);
	}
	
	public static String getExpertWinImgName(){
		return PropertyManagerExpert.getParameter(ExpertKey.KEY_WIN_IMG_NAME);
	}
	
	public static String getExpertLostImgName(){
		return PropertyManagerExpert.getParameter(ExpertKey.KEY_LOST_IMG_NAME);
	}
	
	public static String getExpertNameDivClass1(){
		return PropertyManagerExpert.getParameter(ExpertKey.KEY_EXPERT_NAME_DIV_CLASS1);
	}
	
	public static String getExpertNameDivClass2(){
		return PropertyManagerExpert.getParameter(ExpertKey.KEY_EXPERT_NAME_DIV_CLASS2);
	}
}
