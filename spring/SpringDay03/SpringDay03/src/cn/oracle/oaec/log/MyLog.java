package cn.oracle.oaec.log;

import org.springframework.stereotype.Component;

@Component(value="log")
public class MyLog {
	public void log(){
		System.out.println("��¼��־");
	}
}
