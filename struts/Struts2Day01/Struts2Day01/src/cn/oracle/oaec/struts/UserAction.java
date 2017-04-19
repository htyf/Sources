package cn.oracle.oaec.struts;

import cn.oracle.oaec.struts.entity.User;

/**
 * 这是Action类的第一种写法，它是一个普通类
 * @author HWUA
 *
 */
public class UserAction {
	/*
	 * 方法定义规则
	 * 1.修饰符必须是public
	 * 2.必须要有返回类型，并且必须是String类型
	 * 3.参数列表不能有参数
	 */
	public String login(){
		System.out.println("login...Action");
		//获取参数
		
		//调用service层
		User user=new User();
		
		//跳转页面（在struts2框架中，使用“逻辑视图”在做页面的跳转）
		//返回的字符串是“逻辑视图”
		if(user==null){
			return "ok";
		}else{
			return "error";
		}
	}
}
