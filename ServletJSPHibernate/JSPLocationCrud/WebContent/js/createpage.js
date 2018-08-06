function createLoc(){
	document.getElementById('createpage').action = '/JSPLocationCrud/createdLocPage';
	document.getElementById('createpage').method = 'get';
	document.getElementById('createpage').submit();
}


function goHome(){
	document.getElementById('createpage').action = '/JSPLocationCrud/homePage';
	document.getElementById('createpage').method = 'get';
	document.getElementById('createpage').submit();
}