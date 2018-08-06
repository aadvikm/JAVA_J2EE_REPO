
public class LocationDAOMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocationDAO locDAO =new LocationDAOImpl();
		
		//ToInsert Data..
		/*LocationEntity locEntity =new LocationEntity();
		locEntity.setLocId(5000);
		locEntity.setStreetAdd("2024, Coolidge Hwy");
		locEntity.setPostalCode("480841");
		locEntity.setCity("Troy");
		locEntity.setStateProvince("Michigan");
		locEntity.setCountryId("US");

		locDAO.saveLocation(locEntity);*/
		
		//To Fetch Data..
		/*LocationEntity locEntity1 =null;
		locEntity1 =locDAO.fetchLocation(5000);
		
		System.out.println("Fetched Value : "+locEntity1);*/
		
		//To Update Data..
		/*LocationEntity locEntity2 = new LocationEntity();
		locEntity2.setLocId(5000);
		locEntity2.setStreetAdd("2024, Coolidge Hwy, APT #204");
		locEntity2.setPostalCode("480841");
		locEntity2.setCity("Troy");
		locEntity2.setStateProvince("Michigan");
		locEntity2.setCountryId("US");
	
		locDAO.updateLocation(locEntity2);*/

		//TO Delete data..
	//	locDAO.deleteLocation(5000);
		
		
		LocationEntity locEntity3 =null;
		locEntity3 =locDAO.fetchLocation(4000);
		System.out.println("Before Value : "+locEntity3);
		locEntity3.setStreetAdd("2024, Coolidge Hwy "+locEntity3.getStreetAdd());
		System.out.println("After Value : "+locEntity3);
		locDAO.updateLocation(locEntity3);
		
		
		
	}

}
