package cn.oracle.oaec.demo1;

public class Dept {
	private String name;

	public Dept() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dept(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Dept [name=" + name + "]";
	}
	
	public void init(){
		System.out.println("我是Dept初始化方法");
	}
	public void destory(){
		System.out.println("我是Dept销毁方法");
	}
	
}
