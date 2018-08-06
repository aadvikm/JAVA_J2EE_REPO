package com.purchaseorder.hibernate;

import java.text.SimpleDateFormat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class CURD_MainPgm {

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
		    
		    /*******-------ITEM---------*******/
		    
		    //To Save
		    /* Item item =new Item();
		    item.setItemName("PencilBox");
		    item.setItemPrice(50);
		    
		    Transaction tx = session.beginTransaction();
		    session.save(item);
		    System.out.println("Committed..!!!!");
		    System.out.println(item);
		    tx.commit();*/
		    
		    //To Fetch
		    //Transaction tx = session.beginTransaction();
		    Item item1=(Item)session.get(Item.class, new Integer(112));
		   // System.out.println(item1);
		    
		    //To Update
		   /* Transaction tx = session.beginTransaction();
		    item1.setItemPrice(45);
		    session.update(item1);
		    tx.commit();
		    System.out.println(item1);*/
		    
		    //To Delete
		   /* System.out.println(item1);
		    session.delete(item1);
		    tx.commit();
		    System.out.println("Deleted Successfully..!!");*/
		    
		    
		  /********------PurchaseOrder--------***/
		    //To Save..
		    /*PurchaseOrder purchaseOrder =new PurchaseOrder();
		    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		    purchaseOrder.setPurchaseDate(sdf.parse("10/09/2013"));
		    purchaseOrder.setCustomerId(207);
		    purchaseOrder.setTotalPOAmount(80);
		    
		    Transaction tx = session.beginTransaction();
		    session.save(purchaseOrder);
		    tx.commit();
		    System.out.println("New PurchaseID :"+purchaseOrder.getPurchaseId());*/
		    
		    //To Fetch..
		    /*PurchaseOrder po1=(PurchaseOrder)session.get(PurchaseOrder.class, new Integer(1027));
		    Transaction tx = session.beginTransaction();
		    System.out.println(po1);
		    
		    //To Update
		    po1.setTotalPOAmount(60);
		    session.update(po1);
		    tx.commit();
		    System.out.println(po1);*/
		    
		    /********---PurchaseOrderItem------*********/
		    //To Save
		    /*PurchaseOrderItem poItem =new PurchaseOrderItem();
		    Transaction tx = session.beginTransaction();
		   	poItem.setItemId(item1.getItemId());
		    poItem.setPrice(item1.getItemPrice());
		    poItem.setPurchaseId(1027);
		    poItem.setQuantity(3);
		    session.save(poItem);
		    tx.commit();
		    System.out.println(poItem);
		    System.out.println(poItem.getPoItemId());*/
		    
		   // To Fetch...
			  PurchaseOrderItem poItem1 =(PurchaseOrderItem)session.get(PurchaseOrderItem.class, new Integer(319));
			  Transaction tx = session.beginTransaction();
			  System.out.println(poItem1);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			System.out.println("Finally Block..!!");
		}
	}

}
