package cn.oracel.oaec.entity;


public class Emp {
	private Integer uid;
	private String uname;	
	
	private Dept dept;

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emp(Integer uid, String uname) {
		super();
		this.uid = uid;
		this.uname = uname;
	}
	
	
	public Emp(Integer uid, String uname, Dept dept) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.dept = dept;
	}
	public Emp(String uname, Dept dept) {
		this.uname = uname;
		this.dept = dept;
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

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Emp [uid=" + uid + ", uname=" + uname+"]";
	}
	
	
}
