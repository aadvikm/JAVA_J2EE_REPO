package com.school.hibernate;

import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class SchoolMainPgm {

	public static void main(String[] args) {
		try{
			//creating configuration object  
		    Configuration cfg=new AnnotationConfiguration();  
		    //populates the data of the configuration file
		    cfg.configure("hibernate.cfg.xml");   
		    //creating session factory object  
		    SessionFactory factory=cfg.buildSessionFactory();  
		    //creating session object  
		    Session session=factory.openSession();
		    
		    /*******-------Class---------*******/
		    
		    //To Save
		   /* Class class1 =new Class();
		    Transaction tx =session.beginTransaction();
		   //class1.setClassName("UKG");
		  //  class1.setClassName("FIRST");
		    class1.setClassName("SECOND");
		    session.save(class1);
		    tx.commit();
		    System.out.println(class1);*/
		    
		    /*******-------Subject---------*******/
		   /* Subject sub =new Subject();
		    Transaction tx =session.beginTransaction();
		    //sub.setSubjectName("English");
		    //sub.setSubjectName("Mathematics");
		    sub.setSubjectName("Science");
		    session.save(sub);
		    tx.commit();
		    System.out.println(sub);*/
		    
		    /*******-------Teacher---------*******/
		    /* Teacher teacher =new Teacher();
		    Transaction tx =session.beginTransaction();
		   	teacher.setTeacherName("Madhu");
		    teacher.setSalary(new BigDecimal(12000));
		    SimpleDateFormat sdf =new SimpleDateFormat("MM/dd/yyyy");
		    teacher.settDOB(sdf.parse("06/28/1983"));
		    session.save(teacher);
		    tx.commit();*/
		    
		    /*teacher.setTeacherName("Sangeetha");
		    teacher.setSalary(new BigDecimal(13500));
		    SimpleDateFormat sdf =new SimpleDateFormat("MM/dd/yyyy");
		    teacher.settDOB(sdf.parse("09/13/1982"));
		    session.save(teacher);
		    tx.commit();*/
		    
		    /*teacher.setTeacherName("Preethi");
		    teacher.setSalary(new BigDecimal(16000));
		    SimpleDateFormat sdf =new SimpleDateFormat("MM/dd/yyyy");
		    teacher.settDOB(sdf.parse("12/01/1979"));
		    session.save(teacher);
		    tx.commit();
		    System.out.println(teacher);*/
		    
		    
		    /*******-------Student---------*******/
		  /*  Student student =new Student();
		   Transaction tx =session.beginTransaction();
		    /*student.setStudentName("Aadvik");
		    SimpleDateFormat sdf =new SimpleDateFormat("MM/dd/yyyy");
		    student.setsDOB(sdf.parse("01/25/2017"));
		    student.setClassId(new Integer(1101));
		    session.save(student);
		    tx.commit();*/
		    
		   /* student.setStudentName("Harshu");
		    SimpleDateFormat sdf =new SimpleDateFormat("MM/dd/yyyy");
		    student.setsDOB(sdf.parse("06/08/2016"));
		    student.setClassId(new Integer(1102));
		    session.save(student);
		    tx.commit();*/
		    
		    /*student.setStudentName("Eshwar");
		    SimpleDateFormat sdf =new SimpleDateFormat("MM/dd/yyyy");
		    student.setsDOB(sdf.parse("06/01/2014"));
		    student.setClassId(new Integer(1103));
		    session.save(student);
		    tx.commit();
		    System.out.println(student);*/
		    
		    /*student.setStudentName("Samson");
		    SimpleDateFormat sdf =new SimpleDateFormat("MM/dd/yyyy");
		    student.setsDOB(sdf.parse("07/12/2014"));
		    student.setClassId(new Integer(1103));
		    session.save(student);
		    tx.commit();
		    System.out.println(student);*/
		    
		    
		   /*	student.setStudentName("Hanshika");
		    SimpleDateFormat sdf =new SimpleDateFormat("MM/dd/yyyy");
		    student.setsDOB(sdf.parse("09/25/2009"));
		    student.setClassId(new Integer(1105));
		    session.save(student);
		    tx.commit();
		    System.out.println(student);*/
		    
			/*student.setStudentName("Nikshitha");
		    SimpleDateFormat sdf =new SimpleDateFormat("MM/dd/yyyy");
		    student.setsDOB(sdf.parse("09/25/2009"));
		    student.setClassId(new Integer(1105));
		    session.save(student);
		    tx.commit();
		    System.out.println(student);*/
		    
		    
		    /*******-------ClassDetail---------*******/
		     ClassDetail cDetail =new ClassDetail();
		    Transaction tx =session.beginTransaction();
		  	/*cDetail.setClassId(new Integer(1101));
		    cDetail.setSubjectId(new Integer(502));
		    cDetail.setTeacherId(new Integer(401));
		    session.save(cDetail);
		    tx.commit();*/
		    
		    /*cDetail.setClassId(new Integer(1102));
		    cDetail.setSubjectId(new Integer(503));
		    cDetail.setTeacherId(new Integer(402));
		    session.save(cDetail);
		    tx.commit();*/
		    
		    /*cDetail.setClassId(new Integer(1103));
		    cDetail.setSubjectId(new Integer(501));
		    cDetail.setTeacherId(new Integer(403));
		    session.save(cDetail);
		    tx.commit();
		    System.out.println(cDetail); 
		    */
		    
		   /* cDetail.setClassId(new Integer(1103));
		    cDetail.setSubjectId(new Integer(503));
		    cDetail.setTeacherId(new Integer(402));
		    session.save(cDetail);
		    tx.commit();*/
		    
		    /*cDetail.setClassId(new Integer(1101));
		    cDetail.setSubjectId(new Integer(501));
		    cDetail.setTeacherId(new Integer(403));
		    session.save(cDetail);
		    tx.commit();*/
		    
		    /*cDetail.setClassId(new Integer(1102));
		    cDetail.setSubjectId(new Integer(502));
		    cDetail.setTeacherId(new Integer(401));
		    session.save(cDetail);
		    tx.commit();
		    System.out.println(cDetail);*/
		    
		    
		    /*cDetail.setClassId(new Integer(1105));
		    cDetail.setSubjectId(new Integer(502));
		    cDetail.setTeacherId(new Integer(401));
		    session.save(cDetail);
		    tx.commit();*/
		    
		    
		    /*cDetail.setClassId(new Integer(1105));
		    cDetail.setSubjectId(new Integer(501));
		    cDetail.setTeacherId(new Integer(403));
		    session.save(cDetail);
		    tx.commit();
		    System.out.println(cDetail);*/
		    
		    //To Fetch
		   // ClassDetail cDetail2=(ClassDetail)session.get(ClassDetail.class, new Integer(301));
		   // System.out.println(cDetail2);
		    
		    //HQL
		    Query q1 =session.createQuery("select c from Class c");
		    List<Class> class1 =q1.list();
		    for(Class c1 :class1){
		    	//System.out.println(c1);
		    }
		    
		    //Native Query
		    SQLQuery sqlQuery1 =session.createSQLQuery("select * from ClassDetail where ClassId =1105");
		    sqlQuery1.addEntity(ClassDetail.class);
		    List<ClassDetail> classDetail1=sqlQuery1.list();
		    for(ClassDetail cd :classDetail1){
		    	//System.out.println(cd);
		    }
		    
		    //HCQL
		    Criteria criteria=session.createCriteria(Class.class);
		    Criterion criterion1 = Restrictions.eq("className", new String("SECOND"));
		    criteria.add(criterion1);
		    List<Class> classCriteria =criteria.list();
		    for(Class cCriteria :classCriteria){
		    //	System.out.println(cCriteria);
		    }
		    
		    //Named Query
		    Query q2 =session.getNamedQuery("gtAllClassDetails");
		    List<Class> cl2 =q2.list();
		    for(Class class3 : cl2){
		    	System.out.println(class3);
		    }
		    
	
		    
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			System.out.println("Finally Block..!!!");
		}
	}

}
