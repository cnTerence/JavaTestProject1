package vargas.dgsd22;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import vargas.dgsd22.fetcher.ExpertFetcher;
import vargas.dgsd22.pojo.Expert;
import vargas.dgsd22.prop.PropertyManagerExpert;
import vargas.dgsd22.prop.PropertyManagerMatch;

public class TestClass1 {

	public static void main(String[] args){
		
		PropertyManagerExpert.init();
		PropertyManagerMatch.init();
		
//		Map<String, Expert> lastPubRec = new HashMap<String, Expert>();
//		ExpertFetcher fetcher = new ExpertFetcher();
//		List<Expert> newRec = fetcher.getAllPojo(lastPubRec);
//		
//		Iterator<String> keySetIterator = lastPubRec.keySet().iterator();  
//		while (keySetIterator.hasNext()) {  
//			String key = keySetIterator.next();  
//			Expert value = lastPubRec.get(key);
//			
//			System.out.println(value.getUid() + " | " +
//					value.getUname() + " | " +
//					value.getDate() + " | " +
//					value.getType() + " | " +
//					value.getHost() + " | " +
//					value.getGuest() + " | " +
//					value.isResult() + " | " +
//					value.getP());
//		}  
//		
//		System.out.println("----------------------------------");
//		
//		int len = newRec.size();
//		String[] output = new String[len];
//		
//		int cnt;
//		for(cnt = 0; cnt < len; cnt++){
//			output[cnt] = newRec.get(cnt).getUid() + " | " +
//					newRec.get(cnt).getUname() + " | " +
//					newRec.get(cnt).getDate() + " | " +
//					newRec.get(cnt).getType() + " | " +
//					newRec.get(cnt).getHost() + " | " +
//					newRec.get(cnt).getGuest() + " | " +
//					newRec.get(cnt).isResult() + " | " +
//					newRec.get(cnt).getP();
//			
//			System.out.println(output[cnt]);
//					
//		}
		
		
	}
}
