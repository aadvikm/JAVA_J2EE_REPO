package com.struts2practice.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.struts2practice.domain.Country;
import com.struts2practice.domain.LocationDetail;
import com.struts2practice.domain.LocationEntity;
import com.struts2practice.listener.HibernateListener;

public class LocationDaoImpl implements LocationDao{
	
	private static Logger LOG = Logger.getLogger(LocationDaoImpl.class);
	private SessionFactory sessionFactory;
	
	public LocationDaoImpl(){
		this.sessionFactory = 
		         (SessionFactory) ServletActionContext.getServletContext()
	                     .getAttribute(HibernateListener.KEY_NAME);
	}
	
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public LocationEntity getLocationEntity(Long locationId) throws Exception{
    	LOG.info("Fetching Location Entity....");
    	Session session = sessionFactory.openSession();
    	return (LocationEntity) session.get(LocationEntity.class, locationId);
    }
    
	public LocationEntity saveLocationEntity(LocationEntity locationEntity) throws Exception {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.persist(locationEntity);
		tx.commit();
		session.close();
		LOG.info("Location Entity is saved successfully!!!");
		return locationEntity;
	}

	public LocationEntity updateLocationEntity(LocationEntity locationEntity) throws Exception {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.merge(locationEntity);
		tx.commit();
		session.close();
		LOG.info("Location Entity is updated successfully!!!");
		return locationEntity;
	}

	public void deleteLocationEntity(LocationEntity locationEntity) throws Exception {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(locationEntity);
		tx.commit();
		LOG.info("Location Entity is deleted successfully!!!");
		session.close();
	}

	public LocationDetail getLocationDetail(Long locationId) throws Exception {
		LOG.info("Fetching location detail for location id : "+locationId);
		Session session = sessionFactory.openSession();
		Query query =session.createSQLQuery("Select city as city, street_address as streetAdd, postal_code as postalCode, state_province as stateProvince, country_id as countryId, location_id as locId from locations where state_province is not null and location_id ="+locationId);
		LocationDetail locationDetail = new LocationDetail();
		for(Object obj :query.list()){
			Object[] objArr =(Object[]) obj;
			locationDetail.setCity(String.valueOf(objArr[0]));
			locationDetail.setStreetAdd((String.valueOf(objArr[1])));
			locationDetail.setPostalCode(String.valueOf(objArr[2]));
			locationDetail.setStateProvince(String.valueOf(objArr[3]) ==null? null : String.valueOf(objArr[3]));
			locationDetail.setCountryId(String.valueOf(objArr[4]) ==null ? null : String.valueOf(objArr[4]));
			locationDetail.setLocId(((BigDecimal)objArr[5]).longValue());
		}
		return locationDetail;
	}

	public List<Country> getCountryList() throws Exception {
		LOG.info("Fetching country list...");
		Session session = sessionFactory.openSession();
		SQLQuery query = session.createSQLQuery("Select cast(country_id as varchar2(100)) as countryId, country_name as countryName from countries");
		ArrayList<Country> countryList=new ArrayList<Country>();
		for(Object obj : query.list()){
			Object[] objArr = (Object[]) obj;
			Country coutry =new Country((String)objArr[0] ==null ? null :(String)objArr[0], (String)objArr[1] ==null ? null :(String)objArr[1]);
			countryList.add(coutry);
		}
		return countryList;
	}

	public List<LocationDetail> getLocations() throws Exception {
		LOG.info("Fetching location list...");
		Session session = sessionFactory.openSession();
		SQLQuery query =session.createSQLQuery("Select location_id as locId, city as city from locations");
		ArrayList<LocationDetail> locList =new ArrayList<LocationDetail>();
		for (Object obj : query.list()) {
			Object[] objArr = (Object[]) obj;
			LocationDetail loc =new LocationDetail(((BigDecimal)objArr[0]).longValue(), (String)objArr[1]);
			locList.add(loc);
		}
		return locList;
	}

}
