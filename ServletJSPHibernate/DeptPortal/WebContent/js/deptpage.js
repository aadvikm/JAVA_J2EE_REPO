function logout(){
	
	document.getElementById('deptpage').action='/DeptPortal/logoutServlet';
	document.getElementById('deptpage').method='post';
	document.getElementById('deptpage').submit();
	
}

function resetForm(){
	var elements =document.getElementsByName('checkbox');
	for(var i = 0; i < elements.length; i++){
	elements[i].checked=false;
	}
	
}

function loadDepts(offset, limit){
var xhttp = new XMLHttpRequest();
	 xhttp.onreadystatechange = loadDeptDetail;
	 xhttp.open("GET", "/DeptPortal/deptDetail?offset="+offset+"&limit="+limit, true);
	 xhttp.send();
}

function loadDeptDetail(){
if (this.readyState == 4 && this.status == 200) {
document.getElementById("deptTBody").innerHTML = '';
     document.getElementById("deptTBody").innerHTML = this.responseText;
    }
}

function validateAndSubmit(){	
	if(validate()){
		document.getElementById('deptpage').action='/DeptPortal/nextPage';
		document.getElementById('deptpage').method='post';
		document.getElementById('deptpage').submit();
	}
		
}

function validate(){
	var check1 =document.getElementById('checkbox');
	if(check1.checked ==true){
		return true;
	}
	else{
		alert('Please select any one department to proceed further..!!');
		return false;
	}		
}