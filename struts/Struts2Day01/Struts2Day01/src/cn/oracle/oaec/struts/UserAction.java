package cn.oracle.oaec.struts;

import cn.oracle.oaec.struts.entity.User;

/**
 * ����Action��ĵ�һ��д��������һ����ͨ��
 * @author HWUA
 *
 */
public class UserAction {
	/*
	 * �����������
	 * 1.���η�������public
	 * 2.����Ҫ�з������ͣ����ұ�����String����
	 * 3.�����б����в���
	 */
	public String login(){
		System.out.println("login...Action");
		//��ȡ����
		
		//����service��
		User user=new User();
		
		//��תҳ�棨��struts2����У�ʹ�á��߼���ͼ������ҳ�����ת��
		//���ص��ַ����ǡ��߼���ͼ��
		if(user==null){
			return "ok";
		}else{
			return "error";
		}
	}
}
