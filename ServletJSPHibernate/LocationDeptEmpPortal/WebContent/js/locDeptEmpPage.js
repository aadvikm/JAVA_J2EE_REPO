function loadLocationDetail(elementObj){
	$.ajax({
        'url' : '/LocationDeptEmpPortal/deptServlet',
        'type' : 'GET' ,
		'data' : { 
			'locId' : elementObj.value 
		},
		'success' : function(data) {   
		//always clear the employee before loading new departments
		$("#empDetail").empty().append('<option value=\'\'></option>');
		
			$("#deptDetail").html('<option value=\'\'></option>');
			$.each(data, function(index, dept){
				console.log(index+'----'+dept.deptName);
				console.log(JSON.stringify(dept));
				$('#deptDetail').append('<option value='+dept.deptId+'>'+dept.deptName+'</option>');
			});
		},
        'error' : function(request,error){
            alert('Request: '+request);
			alert('Error: '+error);
        }
    });
}

function loadDeptDetail(element){
	$.ajax({
        'url' : '/LocationDeptEmpPortal/empServlet',
        'type' : 'GET' ,
		'data' : { 
			'locId' : $('#locId').val() , 'deptId' : element.value
		},
		'success' : function(data) {   
			$("#empDetail").html('<option value=\'\'> </option>');
			$.each(data, function(index, emp){
				console.log(index+'----'+emp.empName);
				$('#empDetail').append('<option value='+emp.empId+'>'+emp.empName+'</option>');
			});
		},
        'error' : function(request,error){
            alert('Request: '+request);
			alert('Error: '+error);
        }
    });
	
}

function logout(){
	
	document.getElementById('locDeptEmpPage').action='/LocationDeptEmpPortal/logoutServlet';
	document.getElementById('locDeptEmpPage').method='post';
	document.getElementById('locDeptEmpPage').submit();
	
}