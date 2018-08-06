package com.hibernate.lesson;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OrmRelationshipLesson {

	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		try {
			//Employee emp = (Employee) session.get(Employee.class, 100L);
			DepartmentEntity deptEntity = (DepartmentEntity) session.get(DepartmentEntity.class, 20);
			System.out.println(deptEntity);
		}catch (Exception exception) {
			System.out.println("Errored....");
			exception.printStackTrace();
		}finally {
			if (session != null)
				session.close();
		}

	}

}
