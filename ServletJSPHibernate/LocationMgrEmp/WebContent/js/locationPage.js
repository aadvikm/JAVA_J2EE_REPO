function next(){
	if( validate()){
		document.getElementById('locationPage').action ='/LocationMgrEmp/managerServlet';
		document.getElementById('locationPage').method='post'
		document.getElementById('locationPage').submit();		
	}
}

function validate(){
	if(document.getElementById('locId').value == null || document.getElementById('locId').value.trim().length==0){
		alert('Please Enter a valid Location..!!');
		return false;
	}
	return true;
}