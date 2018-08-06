function createDept(){
	document.getElementById('homepage').action='/DeptCrudJSP/createDept?action=loadCreatePage';
	document.getElementById('homepage').method='post';
	document.getElementById('homepage').submit();
}
function updateDept(){
	document.getElementById('homepage').action='/DeptCrudJSP/updateDept?action=loadUpdatePage';
	document.getElementById('homepage').method='post';
	document.getElementById('homepage').submit();
}
function deleteDept(){
	document.getElementById('homepage').action='/DeptCrudJSP/deleteDept?action=loadDeletePage';
	document.getElementById('homepage').method='post';
	document.getElementById('homepage').submit();
}
function findDept(){
	document.getElementById('homepage').action='/DeptCrudJSP/findDept?action=loadFindPage';
	document.getElementById('homepage').method='post';
	document.getElementById('homepage').submit();
}
function logout(){
	document.getElementById('homepage').action='/DeptCrudJSP/logoutServlet';
	document.getElementById('homepage').method='post';
	document.getElementById('homepage').submit();
}