
public interface LocationDAO {

	public void saveLocation(LocationEntity locEntity);
	
	public LocationEntity fetchLocation(int locId);
	
	public void updateLocation(LocationEntity locEntity);
	
	public void deleteLocation(int locId);

}
