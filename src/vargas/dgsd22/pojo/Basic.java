package vargas.dgsd22.pojo;

public class Basic extends SimpleBasic {

	private String number;
	private String weather;
	private String r;
	private String hostLgeRnk;
	private String guestLgeRnk;
	
	public Basic(){
		super();
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getR() {
		return r;
	}

	public void setR(String r) {
		this.r = r;
	}

	public String getHostLgeRnk() {
		return hostLgeRnk;
	}

	public void setHostLgeRnk(String hostLgeRnk) {
		this.hostLgeRnk = hostLgeRnk;
	}

	public String getGuestLgeRnk() {
		return guestLgeRnk;
	}

	public void setGuestLgeRnk(String guestLgeRnk) {
		this.guestLgeRnk = guestLgeRnk;
	}
}
