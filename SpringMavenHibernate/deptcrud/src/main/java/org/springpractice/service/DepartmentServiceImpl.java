package org.springpractice.service;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springpractice.dao.DepartmentDao;
import org.springpractice.domain.DepartmentDetail;
import org.springpractice.domain.DepartmentEntity;
import org.springpractice.domain.Employee;
import org.springpractice.domain.Location;
import org.springpractice.exception.DepartmentException;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	private static Logger LOG = Logger.getLogger(DepartmentServiceImpl.class);
	@Autowired
	private DepartmentDao departmentDao;

	public DepartmentServiceImpl() {
	}

	public DepartmentEntity saveDept(DepartmentDetail deptDetail) throws DepartmentException {
		try {
			DepartmentEntity departmentEntity = convertDeptDetailToEntity(deptDetail);
			return departmentDao.saveDepartmentEntity(departmentEntity);
		} catch (Exception exception) {
			LOG.error("Error occurred in save dept...", exception);
			throw new DepartmentException(exception);
		}
	}

	public DepartmentEntity updateDept(DepartmentDetail deptDetail) throws DepartmentException {
		try {
			DepartmentEntity departmentEntity = departmentDao.getDepartmentEntity(deptDetail.getDeptId());
			departmentEntity = convertDeptDetailToEntity(departmentEntity, deptDetail);
			return departmentDao.updateDepartmentEntity(departmentEntity);
		} catch (Exception exception) {
			LOG.error("Error occurred in update dept...", exception);
			throw new DepartmentException(exception);
		}
	}

	public void deleteDept(Long deptId) throws DepartmentException {
		try {
			DepartmentEntity departmentEntity = departmentDao.getDepartmentEntity(deptId);
			departmentDao.deleteDepartmentEntity(departmentEntity);
		} catch (Exception exception) {
			LOG.error("Error occurred in delete dept...", exception);
			throw new DepartmentException(exception);
		}
	}

	public DepartmentDetail getDeptDetail(Long deptId) throws DepartmentException {
		try {
			DepartmentDetail deptDetail = departmentDao.getDeptDetail(deptId);
			deptDetail.setMgrList(getManagerList());
			deptDetail.setLocList(getLocationList());
			return deptDetail;
		} catch (Exception exception) {
			LOG.error("Error occurred in get dept detail...", exception);
			throw new DepartmentException(exception);
		}
	}

	public ArrayList<Employee> getManagerList() throws DepartmentException {
		try {
			return (ArrayList) departmentDao.getManagerList();
		} catch (Exception exception) {
			LOG.error("Error occurred in get manager list...", exception);
			throw new DepartmentException(exception);
		}
	}

	public ArrayList<Location> getLocationList() throws DepartmentException {
		try {
			return (ArrayList) departmentDao.getLocationList();
		} catch (Exception exception) {
			LOG.error("Error occurred in get location list...", exception);
			throw new DepartmentException(exception);
		}
	}

	public ArrayList<DepartmentDetail> getDepartments() throws DepartmentException {
		try {
			return (ArrayList) departmentDao.getDepartments();
		} catch (Exception exception) {
			LOG.error("Error occurred in get Department list...", exception);
			throw new DepartmentException(exception);
		}
	}

	private DepartmentEntity convertDeptDetailToEntity(DepartmentEntity departmentEntity,
			DepartmentDetail departmentDetail) throws Exception {
		departmentEntity.setDeptName(departmentDetail.getDeptName());
		departmentEntity.setMgrId(departmentDetail.getMgrId());
		departmentEntity.setLocId(departmentDetail.getLocId());
		return departmentEntity;
	}

	private DepartmentEntity convertDeptDetailToEntity(DepartmentDetail departmentDetail) throws Exception {
		DepartmentEntity departmentEntity = new DepartmentEntity();
		departmentEntity.setDeptId(departmentDetail.getDeptId());
		return convertDeptDetailToEntity(departmentEntity, departmentDetail);
	}

	public DepartmentDetail getManagerAndLocationDetail() throws DepartmentException {
		try {
			DepartmentDetail departmentDetail = new DepartmentDetail();
			departmentDetail.setMgrList(getManagerList());
			departmentDetail.setLocList(getLocationList());
			return departmentDetail;
		} catch (Exception exception) {
			LOG.error("Error occurred in getManagerAndLocationDetail.", exception);
			throw new DepartmentException(exception);
		}
	}
}