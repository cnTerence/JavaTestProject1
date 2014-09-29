package vargas.dgsd22.fetcher;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import vargas.dgsd22.common.HtmlHelper;
import vargas.dgsd22.common.Url;
import vargas.dgsd22.pojo.Expert;
import vargas.dgsd22.prop.PropertyManagerExpert;

public class ExpertFetcher extends Fetcher {

	public List<Expert> getAllPojo() {
		
		List<Expert> expertList = new ArrayList<Expert>();
		
		Map<String, String> expertId = PropertyManagerExpert.getAllExperts();
		int len2;
		int cnt2;
		String uid;
		String uname;
		List<String> usedUid = new ArrayList<String>();
		
		Iterator<String> keySetIterator = expertId.keySet().iterator();  
		while (keySetIterator.hasNext()) {  
			uid = keySetIterator.next();
			
			//check if it is the duplicate uid
			if(usedUid.contains(uid)){
				continue;
			}
			
			Document doc = getDocument(Url.getExpertSite(uid));
			
			uname = 
					doc.getElementsByAttributeValue(HtmlHelper.CLASS, HtmlHelper.getExpertNameDivClass1()).get(0).
					getElementsByAttributeValue(HtmlHelper.CLASS, HtmlHelper.getExpertNameDivClass2()).
					get(0).child(0).child(0).text();
			
			Element tbl = 
					doc.getElementsByAttributeValue(
							HtmlHelper.CLASS, 
							HtmlHelper.getExpertResultDivClass()).get(0).
							getElementsByTag(HtmlHelper.TABLE).get(1).child(0);
			
			len2 = tbl.children().size();
			
			Element row = null;
			Expert expert = null;
			
			cnt2 = len2 - 1;
			for(cnt2 = len2 - 1; cnt2 >= 0; cnt2--){
				row = tbl.child(cnt2);
				
				if(row.child(5).children().size() == 0){
					continue;
				}
				
				expert = new Expert();
				expert.setUid(uid);
				expert.setUname(uname);
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
				
				expertList.add(expert);
			}
			
			usedUid.add(uid);
		
		}
		
		return expertList;
	}
}
