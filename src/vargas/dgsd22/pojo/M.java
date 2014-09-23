package vargas.dgsd22.pojo;

import java.util.ArrayList;
import java.util.List;

public class M {

	private String code;
	private Basic basic;
	
	private List<SimpleBasic> hostPrev;
	private List<SimpleBasic> guestPrev;
	private List<SimpleBasic> hostNext;
	private List<SimpleBasic> guestNext;
	private List<SimpleBasic> battle;
	
	private ODR eOdr;
	private ODR aOdr;
	
	public M(){
		this.basic = new Basic();
		this.hostPrev = new ArrayList<SimpleBasic>();
		this.guestPrev = new ArrayList<SimpleBasic>();
		this.hostNext = new ArrayList<SimpleBasic>();
		this.guestNext = new ArrayList<SimpleBasic>();
		this.battle = new ArrayList<SimpleBasic>();
		this.eOdr = new ODR();
		this.aOdr = new ODR();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Basic getBasic() {
		return basic;
	}

	public void setBasic(Basic basic) {
		this.basic = basic;
	}

	public List<SimpleBasic> getHostPrev() {
		return hostPrev;
	}

	public void setHostPrev(List<SimpleBasic> hostPrev) {
		this.hostPrev = hostPrev;
	}

	public List<SimpleBasic> getGuestPrev() {
		return guestPrev;
	}

	public void setGuestPrev(List<SimpleBasic> guestPrev) {
		this.guestPrev = guestPrev;
	}

	public List<SimpleBasic> getHostNext() {
		return hostNext;
	}

	public void setHostNext(List<SimpleBasic> hostNext) {
		this.hostNext = hostNext;
	}

	public List<SimpleBasic> getGuestNext() {
		return guestNext;
	}

	public void setGuestNext(List<SimpleBasic> guestNext) {
		this.guestNext = guestNext;
	}

	public List<SimpleBasic> getBattle() {
		return battle;
	}

	public void setBattle(List<SimpleBasic> battle) {
		this.battle = battle;
	}

	public ODR geteOdr() {
		return eOdr;
	}

	public void seteOdr(ODR eOdr) {
		this.eOdr = eOdr;
	}

	public ODR getaOdr() {
		return aOdr;
	}

	public void setaOdr(ODR aOdr) {
		this.aOdr = aOdr;
	}
}
