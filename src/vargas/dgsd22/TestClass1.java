package vargas.dgsd22;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import vargas.dgsd22.common.ElementId;
import vargas.dgsd22.common.Parameter;
import vargas.dgsd22.common.Url;
import vargas.dgsd22.pojo.M;

public class TestClass1 {

	public static void main(String[] args){
		Document doc = null;
		try {
			doc = Jsoup.connect(Url.getBasic(Parameter.startDt)).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Element tbl = doc.getElementById(ElementId.getBasicTblId()).child(0).child(0);
		int cnt = tbl.children().size();
		
		Element row = null;
		M m = null;
		List<M> ms = new ArrayList<M>();
		
		int l = 0;
		try{
			for(l = 0; l < cnt; l++){
				row = tbl.child(l);
				if(row.id().matches(Parameter.A_STRING)){
					m = new M();
					//***
					m.setCode(row.id().replaceAll(Parameter.B_STRING, ""));
					//***
					m.getBasic().setNumber(row.child(0).child(1).text());
					//***
					m.getBasic().setType(row.child(1).child(0).text());
					//***
					m.getBasic().setDate(Parameter.startDt.split("-")[0] + "-" + row.child(2).text() + ":00");
					
					//***
					String t = row.child(4).getElementsByTag("span").get(1).text();
					if(!StringUtil.isBlank(t)){
						if(t.matches("^\\S+\\[\\d+\\]$")){
							m.getBasic().setHostLge(t.replaceAll("\\[\\d+\\]", ""));
							m.getBasic().setHostLgeRnk(t.replaceAll(m.getBasic().getHostLge(), "").replaceAll("[\\[\\]]", ""));
						}else if(t.matches("^\\[\\d+\\]$")){
							m.getBasic().setHostLge(m.getBasic().getType());
							m.getBasic().setHostLgeRnk(t.replaceAll("[\\[\\]]", ""));
						}
					}
					//***
					m.getBasic().setHost(row.child(4).getElementsByTag("a").get(0).text());
					
					//***
					t = row.child(4).getElementsByTag("span").get(2).text();
					if(!StringUtil.isBlank(t)){
						m.getBasic().setR(t.replaceAll("[\\(\\)]", ""));
					}
					
					//***
					m.getBasic().setScore(row.child(5).child(0).child(0).text() + ":" + row.child(5).child(0).child(2).text());
					
					//***
					t = row.child(6).getElementsByTag("span").get(1).text();
					if(!StringUtil.isBlank(t)){
						if(t.matches("^\\S+\\[\\d+\\]$")){
							m.getBasic().setGuestLge(t.replaceAll("\\[\\d+\\]", ""));
							m.getBasic().setGuestLgeRnk(t.replace(m.getBasic().getHostLge(), "").replaceAll("[\\[\\]]", ""));
						}else if(t.matches("^\\[\\d+\\]$")){
							m.getBasic().setGuestLge(m.getBasic().getType());
							m.getBasic().setGuestLgeRnk(t.replaceAll("[\\[\\]]", ""));
						}
					}
					//***
					m.getBasic().setGuest(row.child(6).getElementsByTag("a").get(0).text());
					
					//***
					m.getBasic().setHalfScore(row.child(7).child(0).text());
					
					//***
					if(!row.child(8).getElementsByTag("img").isEmpty()){
						m.getBasic().setWeather(row.child(8).getElementsByTag("img").get(0).attr("title"));
					}
					
					ms.add(m);
				}
			}
		}catch(Exception e){
			System.out.print(l);
		}
		
		cnt = 0;
		
	}
}
