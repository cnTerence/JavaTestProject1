package vargas.dgsd22.pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleBasic {

	private String date;
	private String type;
	
	private String host;
	private String guest;
	
	private String hostLge;
	private String guestLge;
	
	private String score;
	private String halfScore;
	
	private Map<String, List<EP>> ep;
	private Map<String, List<AP>> ap;
	
	public SimpleBasic(){
		this.ep = new HashMap<String, List<EP>>();
		this.ap = new HashMap<String, List<AP>>();
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getGuest() {
		return guest;
	}

	public void setGuest(String guest) {
		this.guest = guest;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getHalfScore() {
		return halfScore;
	}

	public void setHalfScore(String halfScore) {
		this.halfScore = halfScore;
	}

	public String getHostLge() {
		return hostLge;
	}

	public void setHostLge(String hostLge) {
		this.hostLge = hostLge;
	}

	public String getGuestLge() {
		return guestLge;
	}

	public void setGuestLge(String guestLge) {
		this.guestLge = guestLge;
	}

	public Map<String, List<EP>> getEp() {
		return ep;
	}

	public void setEp(Map<String, List<EP>> ep) {
		this.ep = ep;
	}

	public Map<String, List<AP>> getAp() {
		return ap;
	}

	public void setAp(Map<String, List<AP>> ap) {
		this.ap = ap;
	}
}
