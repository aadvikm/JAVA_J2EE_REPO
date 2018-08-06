import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class DepartmentJAXB {

	public static void main(String[] args) {
		try{
			DepartmentDao deptDao = new DepartmentDaoImpl();
			DepartmentEntity deptEntity1 = deptDao.fetchDepartment(10);
			JAXBContext jaxbContext = JAXBContext.newInstance(DepartmentEntity.class);
			
	
			File f = new File("C:\\Users\\Brindha\\MyNewWorkSpace\\XMLParsersExercise\\src\\deptEntity.xml");
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(deptEntity1, System.out);
			marshaller.marshal(deptEntity1, f);
			
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}

	}

}
