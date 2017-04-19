package cn.oracel.oaec.entity;

import java.util.HashSet;
import java.util.Set;

public class Dept {
	private Integer did;
	private String dname;
	
	//这是多的一方,集合一定要创建对象，否则框架会报错
	private Set<Emp> emps=new HashSet<Emp>();

	public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dept(String dname) {
		this.dname = dname;
	}
	public Dept(Integer did, String dname, Set<Emp> emps) {
		super();
		this.did = did;
		this.dname = dname;
		this.emps = emps;
	}

	
	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public Set<Emp> getEmps() {
		return emps;
	}

	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}

	@Override
	public String toString() {
		return "Dept [did=" + did + ", dname=" + dname+"]";
	}
	
	
	

	
}
