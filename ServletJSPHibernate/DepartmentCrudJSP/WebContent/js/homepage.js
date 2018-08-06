function createDept(){
	document.getElementById('homepage').action='/DepartmentCrudJSP/createDept?action=loadCreatePage';
	document.getElementById('homepage').method='post';
	document.getElementById('homepage').submit();
}

function updateDept(){
	document.getElementById('homepage').action='/DepartmentCrudJSP/updateDept?action=loadUpdatePage';
	document.getElementById('homepage').method='post';
	document.getElementById('homepage').submit();
}

function findDept(){
	document.getElementById('homepage').action='/DepartmentCrudJSP/findDept?action=loadFindPage';
	document.getElementById('homepage').method='post';
	document.getElementById('homepage').submit();
}

function deleteDept(){
	document.getElementById('homepage').action='/DepartmentCrudJSP/deleteDept?action=loadDeletePage';
	document.getElementById('homepage').method='post';
	document.getElementById('homepage').submit();
}

function logout(){
	
	document.getElementById('homepage').action='/DepartmentCrudJSP/logoutServlet';
	document.getElementById('homepage').method='post';
	document.getElementById('homepage').submit();
	
}