package cn.oracel.oaec.entity;

import java.util.HashSet;
import java.util.Set;

public class Privilege {
	private Integer pid;
	private String pname;	
	private Set<Emp> emps=new HashSet<Emp>();

	public Privilege() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Privilege(Integer pid, String pname, Set<Emp> emps) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.emps = emps;
	}
	
	public Privilege( String pname) {
		this.pname = pname;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Set<Emp> getEmps() {
		return emps;
	}

	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}

	@Override
	public String toString() {
		return "Privilege [pid=" + pid + ", pname=" + pname + ", emps=" + emps + "]";
	}
	
	
}
