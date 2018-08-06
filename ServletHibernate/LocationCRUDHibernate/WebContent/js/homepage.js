function createLoc(){
	document.getElementById('homepage').action='/LocationCRUDHibernate/createLocation';
	document.getElementById('homepage').method='get';
	document.getElementById('homepage').submit();
}
function updateLoc(){
	document.getElementById('homepage').action='/LocationCRUDHibernate/updateLocation';
	document.getElementById('homepage').method='get';
	document.getElementById('homepage').submit();
}
function deleteLoc(){
	document.getElementById('homepage').action='/LocationCRUDHibernate/deleteLocation';
	document.getElementById('homepage').method='get';
	document.getElementById('homepage').submit();
}
function findLoc(){
	document.getElementById('homepage').action='/LocationCRUDHibernate/findLocation';
	document.getElementById('homepage').method='post';
	document.getElementById('homepage').submit();
}
function logout(){
	document.getElementById('homepage').action='/LocationCRUDHibernate/logoutServlet';
	document.getElementById('homepage').method='post';
	document.getElementById('homepage').submit();
}