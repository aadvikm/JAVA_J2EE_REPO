package com.purchaseorder.hibernate;

import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class HQLMainPgm {

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
		    
		    Query q1 =session.createQuery("select p from PurchaseOrder p");
		    List<PurchaseOrder> purchaseOrder =q1.list();
		    for(PurchaseOrder po1 :purchaseOrder){
		    	//System.out.println(po1);
		    }
		    
		    Query q2=session.createQuery("select pi from PurchaseOrderItem pi");
		    List<PurchaseOrderItem> purchaseOrderItem =q2.list();
		    for(PurchaseOrderItem poItem1 : purchaseOrderItem){
		    	//System.out.println(poItem1);
		    }
		    
		    //1)Write a HQL to fetch PO amount greater than 50.
		    Query q4=session.createQuery("select p from PurchaseOrder p where p.totalPOAmount >50");
		    List<PurchaseOrder> purchaseOrder1 =q4.list();
		    for(PurchaseOrder po2 :purchaseOrder1){
		    	//System.out.println(po2);
		    }
		    
		    //2)Write a HQL to fetch PO order date before 2016.
		    Query q5=session.createQuery("select p from PurchaseOrder p where p.purchaseDate < :date");
		    SimpleDateFormat sdf =new SimpleDateFormat("dd/MM/yyyy");
		    q5.setParameter("date", sdf.parse("01/01/2016"));
		    List<PurchaseOrder> purchaseOrder2 =q5.list();
		    for(PurchaseOrder po3 :purchaseOrder2){
		    	//System.out.println(po3);
		    }
		    
		    //3)Write a HQL to get all POItem for passed POId. 
		    Query q3=session.createQuery("select pi from PurchaseOrderItem pi where purchaseId =1015");
		    List<PurchaseOrderItem> purchaseOrderItem1 =q3.list();
		    for(PurchaseOrderItem poItem2 : purchaseOrderItem1){
		    	//System.out.println(poItem2);
		    }
		    
		    //4)Write a NAmed HQL to fetch all POs. 
		   Query q6=session.getNamedQuery("getAllPO");
		   List<PurchaseOrder> purchaseOrder3 =q6.list();
		    for(PurchaseOrder po4 :purchaseOrder3){
		    //	System.out.println(po4);
		    }
		    
		    //5)Write a Criteria Query to fetch PO amount greater than 50.
		    Criteria criteria=session.createCriteria(PurchaseOrder.class);
		    Criterion criterion=Restrictions.gt("totalPOAmount", new Integer(100));
		    criteria.add(criterion);
		    List<PurchaseOrder> poCriteria=criteria.list();
		    for(PurchaseOrder poc :poCriteria){
		    	//System.out.println(poc);
		    }
		  
		    //6)Write a Criteria Query to fetch PO order date before 2016.
		    SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
		    Criterion criterion1=Restrictions.lt("purchaseDate", sdf1.parse("12/01/2016") );
		    criteria.add(criterion1);
		    List<PurchaseOrder> poList1=criteria.list();
		    for(PurchaseOrder po1 :poList1){
		    	//System.out.println(po1);
		    }
		    
		    //7)Write a Criteria Queryto get all POItem for passed POId.
		    Criteria criteria1=session.createCriteria(PurchaseOrderItem.class);
		    Criterion criterion2=Restrictions.eq("purchaseId", 1021);
		    criteria1.add(criterion2);
		    List<PurchaseOrderItem> poList2=criteria1.list();
		    for(PurchaseOrderItem po2 :poList2){
		    	//System.out.println(po2);
		    }
		    //8)Write a Criteria Query to fetch all POs.
		    Criteria criteria3=session.createCriteria(PurchaseOrder.class);
		    List<PurchaseOrder> poList=criteria3.list();
		    for(PurchaseOrder p :poList){
		    	//System.out.println(p);
		    }
		    
		    //9)Write a Native Query to fetch PO amount greater than 50.
		    SQLQuery sqlQuery=session.createSQLQuery("select * from PurchaseOrder where TotalPOAmount >50");
		    sqlQuery.addEntity(PurchaseOrder.class);
		    List<PurchaseOrder> poSql =sqlQuery.list();
		    for(PurchaseOrder poSqlList :poSql){
		    	//System.out.println(poSqlList);
		    }
		    
		    //10)Write a Native Query to fetch PO order date before 2016.
		    SQLQuery sqlQuery1=session.createSQLQuery("select * from PurchaseOrder where PurchaseDate < :purchaseDate");
		    sqlQuery1.addEntity(PurchaseOrder.class);
		    sqlQuery1.setParameter("purchaseDate",  sdf1.parse("12/01/2016"));
		    List<PurchaseOrder> poSql1 =sqlQuery1.list();
		    for(PurchaseOrder poSqlList1 :poSql1){
		    	//System.out.println(poSqlList1);
		    }
		    
		    //11)Write a Native Query to get all POItem for passed POId. 
		    SQLQuery sqlQuery2=session.createSQLQuery("select * from PurchaseOrderItem where PurchaseId =1013");
		    sqlQuery2.addEntity(PurchaseOrderItem.class);
		    List<PurchaseOrderItem> poSql2=sqlQuery2.list();
		    for(PurchaseOrderItem poSqlList2 :poSql2){
		    	//System.out.println(poSqlList2);
		    }
		    
		    //12)Write a Native Query to fetch all POs. 
		    SQLQuery sqlQuery3=session.createSQLQuery("select * from PurchaseOrder");
		    sqlQuery3.addEntity(PurchaseOrder.class);
		    List<PurchaseOrder> poSql3 =sqlQuery3.list();
		    for(PurchaseOrder poSqlList3 :poSql3){
		    	System.out.println(poSqlList3);
		    }
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
