function getEmpDetail(){
	document.getElementById('empCrudForm').action = '/EmpCRUD/getEmployeeDetailPage';
	document.getElementById('empCrudForm').method = 'get';
	document.getElementById('empCrudForm').submit();
}
function updateEmpDetail(){
	document.getElementById('empCrudForm').action = '/EmpCRUD/updateEmployeeDetailPage';
	document.getElementById('empCrudForm').method = 'get';
	document.getElementById('empCrudForm').submit();
}
function deleteEmpDetail(){
	
}
function createEmpDetail(){
	
}