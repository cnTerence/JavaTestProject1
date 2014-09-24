package vargas.dgsd22;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import vargas.dgsd22.common.HtmlHelper;
import vargas.dgsd22.common.Parameter;
import vargas.dgsd22.common.Url;
import vargas.dgsd22.pojo.Expert;
import vargas.dgsd22.pojo.M;
import vargas.dgsd22.prop.ExpertKey;
import vargas.dgsd22.prop.PropertyManagerExpert;
import vargas.dgsd22.prop.PropertyManagerMatch;

public class TestClass1 {

	public static void main(String[] args){
		
		PropertyManagerExpert.init();
		PropertyManagerMatch.init();
		
		Document doc = null;
		try {
//			doc = Jsoup.connect(Url.getMatchBasicSite(Parameter.startDt)).get();
			doc = Jsoup.connect(Url.getExpertSite(Parameter.UID_STRING)).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Element tbl = doc.
				getElementsByAttributeValue(HtmlHelper.CLASS, HtmlHelper.getExpertResultDivClass()).get(0).
				getElementsByTag(HtmlHelper.TABLE).get(1).child(0);
		
		int cnt = tbl.children().size();
		
		Element row = null;
		Expert expert = null;
		List<Expert> es = new ArrayList<Expert>();
		Map<String, Expert> lastPubRec = new HashMap<String, Expert>();
		Expert lastExpert = null;
		boolean isFind = false;
		
		int l = cnt - 1;
		for(l = cnt - 1; l >= 0; l--){
			row = tbl.child(l);
			
			String score = row.child(3).child(0).child(0).child(1).text();
			if(StringUtil.isBlank(score)){
				if(expert != null){
					lastPubRec.put("uid", expert);
				}
				break;
			}
			
			expert = new Expert();
			expert.setType(row.child(1).child(0).text());
			expert.setDate(row.child(2).child(0).text());
			expert.setHost(row.child(3).child(0).child(0).child(0).text());
			expert.setGuest(row.child(3).child(0).child(0).child(2).text());
			expert.setP(row.child(4).text());
			String t = row.child(5).child(0).attr(HtmlHelper.SRC);
			if(t.contains(HtmlHelper.getExpertWinImgName())){
				expert.setResult(true);
			}else if(t.contains(HtmlHelper.getExpertLostImgName())){
				expert.setResult(false);
			}
			
			lastExpert = lastPubRec.get("uid");
			if(lastExpert != null && !isFind){
				if(lastExpert.getType().equals(expert.getType()) && 
						lastExpert.getDate().equals(expert.getDate()) && 
						lastExpert.getHost().equals(expert.getHost()) && 
						lastExpert.getGuest().equals(expert.getGuest())){
					
					isFind = true;
				}
				
				continue;
			}else{
				es.add(expert);
			}
		}
		
		
//		Element tbl = doc.getElementById(ElementId.getMatchBasicTblId()).child(0).child(0);
//		int cnt = tbl.children().size();
//		
//		Element row = null;
//		M m = null;
//		List<M> ms = new ArrayList<M>();
//		
//		int l = 0;
//		try{
//			for(l = 0; l < cnt; l++){
//				row = tbl.child(l);
//				if(row.id().matches(ElementId.getMatchBasicRowIdRegx())){
//					m = new M();
//					//***
//					m.setCode(row.id().replaceAll(ElementId.getMatchBasicRowIdPrefix(), ""));
//					//***
//					m.getBasic().setNumber(row.child(0).child(1).text());
//					//***
//					m.getBasic().setType(row.child(1).child(0).text());
//					//***
//					m.getBasic().setDate(Parameter.startDt.split("-")[0] + "-" + row.child(2).text() + ":00");
//					
//					//***
//					String t = row.child(4).getElementsByTag(HtmlHelper.SPAN).get(1).text();
//					if(!StringUtil.isBlank(t)){
//						if(t.matches("^\\S+\\[\\d+\\]$")){
//							m.getBasic().setHostLge(t.replaceAll("\\[\\d+\\]", ""));
//							m.getBasic().setHostLgeRnk(t.replaceAll(m.getBasic().getHostLge(), "").replaceAll("[\\[\\]]", ""));
//						}else if(t.matches("^\\[\\d+\\]$")){
//							m.getBasic().setHostLge(m.getBasic().getType());
//							m.getBasic().setHostLgeRnk(t.replaceAll("[\\[\\]]", ""));
//						}
//					}
//					//***
//					m.getBasic().setHost(row.child(4).getElementsByTag(HtmlHelper.A).get(0).text());
//					
//					//***
//					t = row.child(4).getElementsByTag(HtmlHelper.SPAN).get(2).text();
//					if(!StringUtil.isBlank(t)){
//						m.getBasic().setR(t.replaceAll("[\\(\\)]", ""));
//					}
//					
//					//***
//					m.getBasic().setScore(row.child(5).child(0).child(0).text() + ":" + row.child(5).child(0).child(2).text());
//					
//					//***
//					t = row.child(6).getElementsByTag(HtmlHelper.SPAN).get(1).text();
//					if(!StringUtil.isBlank(t)){
//						if(t.matches("^\\S+\\[\\d+\\]$")){
//							m.getBasic().setGuestLge(t.replaceAll("\\[\\d+\\]", ""));
//							m.getBasic().setGuestLgeRnk(t.replace(m.getBasic().getHostLge(), "").replaceAll("[\\[\\]]", ""));
//						}else if(t.matches("^\\[\\d+\\]$")){
//							m.getBasic().setGuestLge(m.getBasic().getType());
//							m.getBasic().setGuestLgeRnk(t.replaceAll("[\\[\\]]", ""));
//						}
//					}
//					//***
//					m.getBasic().setGuest(row.child(6).getElementsByTag(HtmlHelper.A).get(0).text());
//					
//					//***
//					m.getBasic().setHalfScore(row.child(7).child(0).text());
//					
//					//***
//					if(!row.child(8).getElementsByTag(HtmlHelper.IMG).isEmpty()){
//						m.getBasic().setWeather(row.child(8).getElementsByTag(HtmlHelper.IMG).get(0).attr(HtmlHelper.TITLE));
//					}
//					
//					ms.add(m);
//				}
//			}
//		}catch(Exception e){
//			System.out.print(l);
//		}
		
		int cnt1 = 0;
		
	}
}
