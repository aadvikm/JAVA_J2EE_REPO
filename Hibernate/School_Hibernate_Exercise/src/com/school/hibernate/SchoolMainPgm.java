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
		    	//System.out.println(class3);
		    }
		    
		    //1) Write an HQL to get classes that teach English.
		    Query q3 =session.createQuery("select c from Class c, ClassDetail cd, Subject s where c.classId=cd.classId and cd.subjectId =s.subjectId and s.subjectName ='English'");
		    List<Class> classList1=q3.list();
		    for(Class clList :classList1){
		    	//System.out.println(clList);
		    }
		    
		    //2) Write an HQL to get teachers who were born in 1982.
		    Query q4 =session.createQuery("select t from Teacher t where t.tDOB =:dob");
		    SimpleDateFormat sdf =new SimpleDateFormat("dd/MM/yyyy");
		    q4.setParameter("dob", sdf.parse("13/09/1982"));
		    List<Teacher> tech=q4.list();
		    for(Teacher techList :tech){
		    	//System.out.println(techList);
		    }
		    
		    //3) Write an HQL that give class_name, student_name for the teached name (pass teacher name as parameter).
		    Query q5=session.createQuery("select c.className as CLASSNAME, s.studentName as STUDENTNAME, t.teacherName as TeacherName from Class c, Student s, Teacher t, ClassDetail cd where c.classId=s.classId and t.teacherId=cd.teacherId and c.classId=cd.classId and t.teacherName ='Madhu'");
		    List<Object[]> listObj =q5.list();
		    for(Object[] obj :listObj){
		    	//System.out.println("ClassName :"+obj[0] +" || "+"StudentName :"+obj[1] +" || "+"TeacherName :"+obj[2]);
		    }
		    
		    //4) Write an HQL that gives Students who belong to the class_name that is passed as parameter.
		    Query q6=session.createQuery("select s from Class c, Student s where c.classId=s.classId and c.className =:cName");
		    q6.setParameter("cName", "FIRST");
		    List<Student> sList1 =q6.list();
		    for(Student stud :sList1){
		    //	System.out.println(stud);
		    }
		    
		    //5) Write an HCQL to find the students born between 2008 to 2016.
		    Criteria criteria1=session.createCriteria(Student.class);
		    SimpleDateFormat sdf1 =new SimpleDateFormat("dd/MM/yyyy");
		    Criterion criterion3=Restrictions.between("sDOB", sdf1.parse("01/01/2008"), sdf1.parse("31/12/2016"));
		    criteria1.add(criterion3);
		    List<Student> studCriteria=criteria1.list();
		    for(Student studCri :studCriteria){
		    	//System.out.println(studCri);
		    }
		    
		    //6) Write an HCQL that give class_name, student_name for the teached name (pass teacher name as parameter).
		    
		    //7) Write an HCQL to get classes that teach Engligh.
		    Query q7=session.createQuery("select s.subjectId from Subject s where s.subjectName='English'");
		   Criteria criteria2=session.createCriteria(ClassDetail.class);
		  // System.out.println(q7.list());
		    Criterion criterion4=Restrictions.eq("subjectId",new Integer(501));
		    criteria2.add(criterion4);
		    List<ClassDetail> cdList2 =criteria2.list();
		    for(ClassDetail cdSub :cdList2){
		    	//System.out.println(cdSub);
		    }
		    
		    //8) Write a native query to get classes that teach English.
		    SQLQuery sQuery=session.createSQLQuery("select c.*  from Class c, ClassDetail cd, Subject s where c.classId=cd.classId and s.subjectId=cd.subjectId and s.subjectName='English'");
		    sQuery.addEntity(Class.class);
		    List<Class> sqlClass=sQuery.list();
		    for(Class classSql :sqlClass){
		    	//System.out.println(classSql);
		    }
		    
		    //9) Write a native query to get teachers who were born in 1982.
		    SQLQuery sQuery1=session.createSQLQuery("select * from Teacher where tDOB =:dob");
		    SimpleDateFormat sdf2 =new SimpleDateFormat("dd/MM/yyyy");
		    sQuery1.setParameter("dob", sdf2.parseObject("13/09/1982"));
		    sQuery1.addEntity(Teacher.class);
		    List<Teacher> techList =sQuery1.list();
		    for(Teacher t :techList){
		    //	System.out.println(t);
		    }
		    
		    //10) Write a native query that give class_name, student_name for the teached name (pass teacher name as parameter).
		    SQLQuery sQuery2=session.createSQLQuery("select c.ClassName as CLASSNAME, s.StudentName as STUDENTNAME,t.teacherName as TEACHERNAME from Class c, Student s, Teacher t, ClassDetail cd where c.ClassId=s.ClassId and t.TeacherId=cd.TeacherId and c.ClassId=cd.ClassId and t.TeacherName='Preethi'");
		    List<Object[]> techList1 =sQuery2.list();
		    for(Object[] obj1 :techList1){
		    	//System.out.println("ClassName :"+obj1[0]+" || "+"StudentName :"+obj1[1]+" || "+"TeacherName :"+obj1[2]);
		    }
		    
		    //11) Write a native query that gives Students who belong to the class_name that is passed as parameter.
		    SQLQuery sQuery3 =session.createSQLQuery("select s.* from Class c, Student s where c.ClassId=s.ClassId and c.ClassName ='FIRST'");
		    sQuery3.addEntity(Student.class);
		    List<Student> sList =sQuery3.list();
		    for(Student studList :sList){
		    	//System.out.println(studList);
		    }
		    
		    //12) Write a native query to find the students born between 2008 to 2015.
		    SQLQuery sQuery4 =session.createSQLQuery("select * from Student where SDOB between '01-JAN-2008' and '31-DEC-2015'");
		    sQuery4.addEntity(Student.class);
		    List<Student> sList2 =sQuery4.list();
		    for(Student studList2 :sList2){
		    	//System.out.println(studList2);
		    }
		    
		    //13) Learn from online how to do left outer join in HQL and demo it using HR Schema Employee and Department tables. 
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			System.out.println("Finally Block..!!!");
		}
	}

}
