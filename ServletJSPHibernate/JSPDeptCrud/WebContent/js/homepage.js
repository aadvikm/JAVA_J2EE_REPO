function createDept(){
	document.getElementById('homepage').action='/JSPDeptCrud/createDept?action=loadCreatePage';
	document.getElementById('homepage').method='post';
	document.getElementById('homepage').submit();
}
function updateDept(){
	document.getElementById('homepage').action='/JSPDeptCrud/updateDept?action=loadUpdatePage';
	document.getElementById('homepage').method='post';
	document.getElementById('homepage').submit();
}
function deleteDept(){
	document.getElementById('homepage').action='/JSPDeptCrud/deleteDept?action=loadDeletePage';
	document.getElementById('homepage').method='post';
	document.getElementById('homepage').submit();
}
function findDept(){
	document.getElementById('homepage').action='/JSPDeptCrud/findDept?action=loadFindPage';
	document.getElementById('homepage').method='post';
	document.getElementById('homepage').submit();
}
function logout(){
	document.getElementById('homepage').action='/JSPDeptCrud/logoutServlet';
	document.getElementById('homepage').method='post';
	document.getElementById('homepage').submit();
}