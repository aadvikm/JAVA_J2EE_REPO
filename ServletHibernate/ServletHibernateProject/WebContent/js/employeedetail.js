function updateEmp(){
document.getElementById('empForm').method = 'post';
document.getElementById('empForm').action = '/ServletHibernateProject/updateEmployee';
document.getElementById('empForm').submit();
}
function deleteEmp(){
	document.getElementById('empForm').method = 'post';
	document.getElementById('empForm').action = '/ServletHibernateProject/deleteEmployee';
	document.getElementById('empForm').submit();
}
function saveEmp(){
	document.getElementById('empForm').method = 'post';
	document.getElementById('empForm').action = '/ServletHibernateProject/saveEmployee';
	document.getElementById('empForm').submit();
}
function clearEmp(){
	alert('Add code to clear the form...');
}
function createEmployee(){
	document.getElementById('empForm').method = 'get';
	document.getElementById('empForm').action = '/ServletHibernateProject/createEmployee';
	document.getElementById('empForm').submit();
}