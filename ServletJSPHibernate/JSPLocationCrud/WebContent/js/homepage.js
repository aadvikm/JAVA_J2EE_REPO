function createLoc(){
	document.getElementById('homepage').action='/JSPLocationCrud/createLocation';
	document.getElementById('homepage').method='get';
	document.getElementById('homepage').submit();
}
function updateLoc(){
	document.getElementById('homepage').action='/JSPLocationCrud/updateLocation?action=loadUpdatePage';
	document.getElementById('homepage').method='post';
	document.getElementById('homepage').submit();
}
function deleteLoc(){
	document.getElementById('homepage').action='/JSPLocationCrud/deleteLocation';
	document.getElementById('homepage').method='get';
	document.getElementById('homepage').submit();
}
function findLoc(){
	document.getElementById('homepage').action='/JSPLocationCrud/findLocation';
	document.getElementById('homepage').method='post';
	document.getElementById('homepage').submit();
}
function logout(){
	document.getElementById('homepage').action='/JSPLocationCrud/logoutServlet';
	document.getElementById('homepage').method='post';
	document.getElementById('homepage').submit();
}