package vargas.dgsd22;

import java.util.HashMap;
import java.util.Map;

import vargas.dgsd22.fetcher.ExpertFetcher;
import vargas.dgsd22.pojo.Expert;
import vargas.dgsd22.prop.PropertyManagerExpert;
import vargas.dgsd22.prop.PropertyManagerMatch;

public class TestClass1 {

	public static void main(String[] args){
		
		PropertyManagerExpert.init();
		PropertyManagerMatch.init();
		
		Map<String, Expert> lastPubRec = new HashMap<String, Expert>();
		ExpertFetcher fetcher = new ExpertFetcher();
		fetcher.getAllPojo(lastPubRec);
	}
}
