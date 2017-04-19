package cn.oracle.oaec.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component(value="myTransaction")
public class MyTransaction {
	
	public void begingTransaction(){
		System.out.println("��������...");
	}
	public void commitTransaction(){
		System.out.println("�ύ����...");
	}
	public void rollbackTransaction(){
		//��־
		System.out.println("�ع�����...");
	}
	
	public void transaction(ProceedingJoinPoint joinPoint){
		try {
			System.out.println("��������...");
			/*
			 * Session s=hiernate.getCurrentSession();
			 * Transaction tr=s.begingTransaction();
			 */
			//�͵�ͬ�ڵ���cn.oracle.oaec.service.impl.UserServiceImpl.save();
			
			joinPoint.proceed();
			System.out.println("�ύ����...");
			
			/*
			 * tr.commit();
			 */
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/*
			 * ��־
			 * tr.rollback();
			 */
		}
	}
}
