package cn.oracle.oaec.demo1;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Demo1 {

	public static void main(String[] args) {
		ApplicationContext c=new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("---------------------");
		Person p=(Person)c.getBean("p1");
		System.out.println(p.getName());
		System.out.println(p.getAge());
		System.out.println(p.getScore());
		System.out.println(p.getDept().getName());
	}

	private static void m2() {
		//创建容器工厂的方法
		//方法一
//		ApplicationContext c=new ClassPathXmlApplicationContext("applicationContext.xml");
		//方法二
		BeanFactory bf=new XmlBeanFactory(new ClassPathResource("applicationContext.xml"));
		System.out.println("--------------------");
		Person p=(Person)bf.getBean("p");
		Person p1=(Person)bf.getBean("p");
		System.out.println(p==p1);
		
		
		/**
		 * 方法一：在容器加载的时候就创建了配置的bean对象
		 * 方法二：在容器加载的时候不创建配置的bean对象，在调用getBean()方法时才创建对象
		 * 一般推荐第一种方法
		 */
	}

	private static void m1() {
		//原始方法
//		Person p=new Person();

		//spring提供的方法
		//加载spring容器
		ClassPathXmlApplicationContext c=new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("--------------------");
		//从容器中获取我们想要的对象
		Person p1=(Person)c.getBean("p");
		Person p2=(Person)c.getBean("p");
		System.out.println(p1==p2);
		
		//演示销毁方法
		//1.必须是单例
		//2.调用容器自身的销毁方法
		c.close();
	}

}
