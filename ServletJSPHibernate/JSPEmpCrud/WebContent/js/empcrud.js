function getEmpDetail(){
	document.getElementById('empCrudForm').action = '/JSPEmpCrud/getEmployeeDetailPage';
	document.getElementById('empCrudForm').method = 'get';
	document.getElementById('empCrudForm').submit();
}
function updateEmpDetail(){
	document.getElementById('empCrudForm').action = '/JSPEmpCrud/updateEmployeeDetailPage';
	document.getElementById('empCrudForm').method = 'get';
	document.getElementById('empCrudForm').submit();
}
function deleteEmpDetail(){
	
}
function createEmpDetail(){
	
}