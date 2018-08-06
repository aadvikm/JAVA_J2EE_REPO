function getEmpDetail(){
	document.getElementById('empCrudForm').action = '/EmpCrudJSP/getEmployeeDetailPage';
	document.getElementById('empCrudForm').method = 'get';
	document.getElementById('empCrudForm').submit();
}
function updateEmpDetail(){
	document.getElementById('empCrudForm').action = '/EmpCrudJSP/updateEmployeeDetailPage';
	document.getElementById('empCrudForm').method = 'get';
	document.getElementById('empCrudForm').submit();
}
function deleteEmpDetail(){
	document.getElementById('empCrudForm').action = '/EmpCrudJSP/deleteEmployeeDetailPage';
	document.getElementById('empCrudForm').method = 'get';
	document.getElementById('empCrudForm').submit();
}
function createEmpDetail(){
	document.getElementById('empCrudForm').action = '/EmpCrudJSP/createEmployeeDetailPage';
	document.getElementById('empCrudForm').method = 'get';
	document.getElementById('empCrudForm').submit();
}