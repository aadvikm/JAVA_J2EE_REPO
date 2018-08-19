package org.springpractice.controller;

import java.util.ArrayList;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springpractice.domain.DepartmentDetail;
import org.springpractice.domain.DepartmentEntity;
import org.springpractice.domain.JsonResponse;
import org.springpractice.exception.DepartmentException;
import org.springpractice.service.DepartmentService;

@Controller
public class DepartmentController {
	private static Logger LOG = Logger.getLogger(DepartmentController.class);
	@Autowired
	private DepartmentService departmentService;

	public DepartmentController() {
	}

	@RequestMapping(value = { "/" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public String deptPage() {
		return "deptPage";
	}

	@RequestMapping(value = { "/getdepartments" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.GET })
	@ResponseBody
	public JsonResponse getDepartments() {
		LOG.info("Inside get Dept detail controller mapping...");
		try {
			ArrayList<DepartmentDetail> departmentDetailList = departmentService.getDepartments();
			return getJsonResponse(departmentDetailList);
		} catch (DepartmentException departmentException) {
			LOG.error("Error occurred in getDepartmentDetail...", departmentException);
			JsonResponse response = new JsonResponse();
			response.setErrorMessage("Error Occurred. Please try again later.");
			return response;
		} catch (Exception exception) {
			LOG.error("Error occurred in getDepartmentDetail...", exception);
			JsonResponse response = new JsonResponse();
			response.setErrorMessage("Error Occurred. Please try again later.");
			return response;
		}
	}

	@RequestMapping(value = { "/getdeptdetail" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.POST })
	@ResponseBody
	public JsonResponse getDeptDetail(@RequestParam("deptId") Long deptId) {
		LOG.info("Inside get department detail controller mapping...");
		try {
			DepartmentDetail departmentDetail = departmentService.getDeptDetail(deptId);
			return getJsonResponse(departmentDetail);
		} catch (DepartmentException departmentException) {
			LOG.error("Error occurred in getdeptDetail...", departmentException);
			JsonResponse response = new JsonResponse();
			response.setErrorMessage("Error Occurred. Please try again later.");
			return response;
		} catch (Exception exception) {
			LOG.error("Error occurred in getDeptDetail...", exception);
			JsonResponse response = new JsonResponse();
			response.setErrorMessage("Error Occurred. Please try again later.");
			return response;
		}
	}

	@RequestMapping(value = { "/updatedept" }, method = { org.springframework.web.bind.annotation.RequestMethod.POST })
	@ResponseBody
	public JsonResponse updateDept(@RequestBody DepartmentDetail departmentDetail) {
		LOG.info("Inside update department controller mapping...");
		try {
			DepartmentEntity departmentEntity = departmentService.updateDept(departmentDetail);
			departmentDetail = departmentService.getDeptDetail(departmentEntity.getDeptId());
			return getJsonResponse(departmentDetail);
		} catch (DepartmentException departmentException) {
			LOG.error("Error occurred in updateDepartment.", departmentException);
			JsonResponse response = new JsonResponse();
			response.setErrorMessage("Error Occurred. Please try again later.");
			return response;
		} catch (Exception exception) {
			LOG.error("Error occurred in updateDepartment...", exception);
			JsonResponse response = new JsonResponse();
			response.setErrorMessage("Error Occurred. Please try again later.");
			return response;
		}
	}

	@RequestMapping(value = { "/savedept" }, method = { org.springframework.web.bind.annotation.RequestMethod.POST })
	@ResponseBody
	public JsonResponse saveDept(@RequestBody DepartmentDetail departmentDetail) {
		LOG.info("Inside save Dept controller mapping...");
		try {
			DepartmentEntity departmentEntity = departmentService.saveDept(departmentDetail);
			departmentDetail = departmentService.getDeptDetail(departmentEntity.getDeptId());
			return getJsonResponse(departmentDetail);
		} catch (DepartmentException departmentException) {
			LOG.error("Error occurred in saveDept...", departmentException);
			JsonResponse response = new JsonResponse();
			response.setErrorMessage("Error Occurred. Please try again later.");
			return response;
		} catch (Exception exception) {
			LOG.error("Error occurred in saveDept...", exception);
			JsonResponse response = new JsonResponse();
			response.setErrorMessage("Error Occurred. Please try again later.");
			return response;
		}
	}

	@RequestMapping(value = { "/deletedept/{deptId}" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.POST })
	@ResponseBody
	public JsonResponse deleteDept(@PathVariable("deptId") Long deptId) {
		LOG.info("Inside delete Department controller mapping...");
		try {
			departmentService.deleteDept(deptId);
			return new JsonResponse();
		} catch (DepartmentException departmentException) {
			LOG.error("Error occurred in deleteDept...", departmentException);
			JsonResponse response = new JsonResponse();
			response.setErrorMessage("Error Occurred. Please try again later.");
			return response;
		} catch (Exception exception) {
			LOG.error("Error occurred in deleteDept...", exception);
			JsonResponse response = new JsonResponse();
			response.setErrorMessage("Error Occurred. Please try again later.");
			return response;
		}
	}

	@RequestMapping(value = { "/getmanagerandlocationdetail" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.GET })
	@ResponseBody
	public JsonResponse getManagerAndLocationDetail() {
		LOG.info("Inside the Manager and Location Detail..");
		try {
			DepartmentDetail departmentDetail = departmentService.getManagerAndLocationDetail();
			return getJsonResponse(departmentDetail);
		} catch (DepartmentException departmentException) {
			LOG.error("Error occurred in ManagerAndLocation Detail...", departmentException);
			JsonResponse response = new JsonResponse();
			response.setErrorMessage("Error Occurred. Please try again later.");
			return response;
		} catch (Exception exception) {
			LOG.error("Error occurred in ManagerAndLocation Detail...", exception);
			JsonResponse response = new JsonResponse();
			response.setErrorMessage("Error Occurred. Please try again later.");
			return response;
		}
	}

	private JsonResponse getJsonResponse(DepartmentDetail departmentDetail) throws Exception {
		JsonResponse response = new JsonResponse();
		ObjectMapper objectMapper = new ObjectMapper();
		response.setJsonData(objectMapper.writeValueAsString(departmentDetail));
		return response;
	}

	private <T> JsonResponse getJsonResponse(ArrayList<T> list) throws Exception {
		JsonResponse response = new JsonResponse();
		ObjectMapper objectMapper = new ObjectMapper();
		response.setJsonData(objectMapper.writeValueAsString(list));
		return response;
	}
}
