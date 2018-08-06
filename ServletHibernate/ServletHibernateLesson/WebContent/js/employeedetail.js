function updateEmp(){
document.getElementById('empForm').method = 'post';
document.getElementById('empForm').action = '/ServletHibernateLesson/updateEmployee';
document.getElementById('empForm').submit();
}
function deleteEmp(){
	document.getElementById('empForm').method = 'post';
	document.getElementById('empForm').action = '/ServletHibernateLesson/deleteEmployee';
	document.getElementById('empForm').submit();
}
function saveEmp(){
	document.getElementById('empForm').method = 'post';
	document.getElementById('empForm').action = '/ServletHibernateLesson/saveEmployee';
	document.getElementById('empForm').submit();
}
function clearEmp(){
	alert('Add code to clear the form...');
}
function createEmployee(){
	document.getElementById('empForm').method = 'get';
	document.getElementById('empForm').action = '/ServletHibernateLesson/createEmployee';
	document.getElementById('empForm').submit();
}