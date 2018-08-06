function logout(){
	
	document.getElementById('employeepage').action='/EmployeePortal/logoutServlet';
	document.getElementById('employeepage').method='post';
	document.getElementById('employeepage').submit();
	
}

function resetForm(){
	var elements =document.getElementsByName('checkbox');
	for(var i = 0; i < elements.length; i++){
	elements[i].checked=false;
	}
	
}



function validateAndSubmit(){	
	if(validate()){
		document.getElementById('employeepage').action='/EmployeePortal/nextPage';
		document.getElementById('employeepage').method='post';
		document.getElementById('employeepage').submit();
	}
		
}

function validate(){
	var check1 =document.getElementById('checkbox');
	if(check1.checked ==true){
		return true;
	}
	else{
		alert('Please select any one employee to proceed further..!!');
		return false;
	}		
}

function showEmpDetail(){
	var xhttp = new XMLHttpRequest();
	 xhttp.onreadystatechange = displayEmpDetail;
	 xhttp.open("GET", "empDetail.txt", true);
	 xhttp.send();
}


function displayEmpDetail() {
    if (this.readyState == 4 && this.status == 200) {
     document.getElementById("empDetail").innerHTML = this.responseText;
    }
};

/*function loadEmployee(offset, limit){
	var xhttp = new XMLHttpRequest();
		 xhttp.onreadystatechange = loadEmpDetail;
		 xhttp.open("GET", "/EmployeePortal/ajaxServlet?offset="+offset+"&limit="+limit, true);
		 xhttp.send();
	}

function loadEmpDetail(){
	if (this.readyState == 4 && this.status == 200) {
		//document.getElementById("empTBody").innerHTML = '';
	     //document.getElementById("empTBody").innerHTML = this.responseText;
		 $("#empTBody").html(this.responseText);
		 $(".button").hide();
	}
}
*/
function loadEmployee(offset, limit){
	$.ajax({
        'url' : '/EmployeePortal/ajaxServlet',
        'type' : 'GET' ,
		'data' : {
            'offset' : offset,
			'limit'  : limit
        },
		'success' : function(data) {              
			$("#empTBody").html(data);
        },
        'error' : function(request,error)
        {
            alert("Request: "+request);
			alert("Error: "+error);
        }
    });
}

function loadEmployeeUsingJqueryAndJson(offset, limit){
	$.ajax({
        'url' : '/EmployeePortal/jsonServlet',
        'type' : 'GET' ,
		'data' : {
            'offset' : offset,
			'limit'  : limit
        },
		'success' : function(data) {              
			$("#empTBody").html('');//to clear the existing rows...
			$.each(data, function(index, employee){
			console.log(index+'----'+employee);
			$("#empTBody").append("<tr><td align ='center'> <input type='checkbox' id='checkbox_'"+employee.id+" name ='checkbox' /> </td><td align ='center'>"+employee.name+"</td><td align ='center'>"+employee.mgrName+"</td><td align ='center'>"+employee.location+"</td><td align ='left'>"+employee.salary+"</td></tr>")
			});
			$("#empTBody").append("<tr nowrap><td colspan = 5 align='right'><input type='button' style='width:80px' onclick='loadEmployeeUsingJqueryAndJson("+(offset-5)+","+(limit-5)+")' value='Prev'/>"+offset+"-"+limit+"<input type='button' style='width:80px' onclick='loadEmployeeUsingJqueryAndJson("+(offset+5)+","+(limit+5)+")' value='Next'/></td></tr>");
        },
        'error' : function(request,error)
        {
            alert('Request: '+request);
			alert('Error: '+error);
        }
    });
}

function showEmpDetailUsingJquery(){
	$.ajax({
        'url' : 'empDetail.txt',
        'type' : 'GET',
        'success' : function(data) {    
			var jsObj = {deptId:'10',dname : 'Account'};
			var json = JSON.stringify(jsObj);
			alert(JSON.parse(json));
			
			
		
			$('#empDetailJquery').html(data);
        },
        'error' : function(request,error)
        {
            alert('Request: '+request);
			alert('Error: '+error);
        }
    });
}
