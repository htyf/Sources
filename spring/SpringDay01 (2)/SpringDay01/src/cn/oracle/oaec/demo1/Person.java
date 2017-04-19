package cn.oracle.oaec.demo1;

public class Person {
	private String name;
	private Integer age;
	private int score;
	private Dept dept;
	
	
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", score=" + score  + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public Person(String name, Integer age, int score, Dept dept) {
		super();
		this.name = name;
		this.age = age;
		this.score = score;
		this.dept = dept;
	}
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void init(){
		System.out.println("我是Person初始化方法");
	}
	public void destory(){
		System.out.println("我是Person销毁方法");
	}
	
}
