package vargas.dgsd22.fetcher;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import vargas.dgsd22.common.HtmlHelper;
import vargas.dgsd22.common.Url;
import vargas.dgsd22.pojo.Expert;
import vargas.dgsd22.prop.PropertyManagerExpert;

public class ExpertFetcher extends Fetcher {

	public List<Expert> getAllPojo(Map<String, Expert> lastPubRec) {
		
		List<Expert> expertList = new ArrayList<Expert>();
		
		Map<String, String> expertId = PropertyManagerExpert.getAllExperts();
		int len1 = expertId.size();
		int len2;
		int cnt1;
		int cnt2;
		String uid;
		String uname;
		for(cnt1 = 0; cnt1 < len1; cnt1++){
			uid = expertId.get(cnt1);
			
			Document doc = getDocument(Url.getExpertSite(uid));
			
			uname = 
					doc.getElementById(HtmlHelper.getExpertNameDivId()).
					getElementsByAttributeValue(HtmlHelper.CLASS, HtmlHelper.getExpertNameDivClass()).
					get(0).child(0).child(0).text();
			
			Element tbl = 
					doc.getElementsByAttributeValue(
							HtmlHelper.CLASS, 
							HtmlHelper.getExpertResultDivClass()).get(0).
							getElementsByTag(HtmlHelper.TABLE).get(1).child(0);
			
			len2 = tbl.children().size();
			
			Element row = null;
			Expert expert = null;
			Expert lastExpert = null;
			boolean hasFindLastRec = false;
			
			cnt2 = len2 - 1;
			for(cnt2 = len2 - 1; cnt2 >= 0; cnt2--){
				row = tbl.child(cnt2);
				
				//if xx is blank, stop
				String score = row.child(3).child(0).child(0).child(1).text();
				if(StringUtil.isBlank(score)){
					if(expert != null){
						lastPubRec.put(uid, expert);
					}
					break;
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
				
				//if last record exists, search
				lastExpert = lastPubRec.get(uid);
				if(lastExpert != null && !hasFindLastRec){
					if(lastExpert.getType().equals(expert.getType()) && 
							lastExpert.getDate().equals(expert.getDate()) && 
							lastExpert.getHost().equals(expert.getHost()) && 
							lastExpert.getGuest().equals(expert.getGuest())){
						
						hasFindLastRec = true;
					}
					
					continue;
				}else{
					expertList.add(expert);
				}
			}
		}
		
		return expertList;
	}
}
