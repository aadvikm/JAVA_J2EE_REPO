function createLoc(){
	document.getElementById('createpage').action = '/LocationCRUDHibernate/createdLocPage';
	document.getElementById('createpage').method = 'get';
	document.getElementById('createpage').submit();
}


function goHome(){
	document.getElementById('createpage').action = '/LocationCRUDHibernate/homePage';
	document.getElementById('createpage').method = 'get';
	document.getElementById('createpage').submit();
}