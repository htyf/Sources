package cn.oracel.oaec.entity;

import java.util.HashSet;
import java.util.Set;

public class Emp {
	private Integer uid;
	private String uname;	
	private Set<Privilege> pris=new HashSet<Privilege>();

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emp(Integer uid, String uname, Set<Privilege> pris) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.pris = pris;
	}
	public Emp(String uname) {
		this.uname = uname;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public Set<Privilege> getPris() {
		return pris;
	}

	public void setPris(Set<Privilege> pris) {
		this.pris = pris;
	}

	@Override
	public String toString() {
		return "Emp [uid=" + uid + ", uname=" + uname + ", pris=" + pris + "]";
	}


}
