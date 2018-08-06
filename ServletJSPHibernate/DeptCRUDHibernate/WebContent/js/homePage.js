function createDept(){
	document.getElementById('homePage').action='/DeptCRUDHibernate/createDepartment';
	document.getElementById('homePage').method='post';
	document.getElementById('homePage').submit();
}

function findDept(){
	document.getElementById('homePage').action='/DeptCRUDHibernate/findDepartment';
	document.getElementById('homePage').method='get';
	document.getElementById('homePage').submit();
}

function updateDept(){
	document.getElementById('homePage').action='/DeptCRUDHibernate/updateDepartment';
	document.getElementById('homePage').method='get';
	document.getElementById('homePage').submit();
}
function deleteDept(){
	document.getElementById('homePage').action='/DeptCRUDHibernate/deleteDepartment';
	document.getElementById('homePage').method='post';
	document.getElementById('homePage').submit();
}