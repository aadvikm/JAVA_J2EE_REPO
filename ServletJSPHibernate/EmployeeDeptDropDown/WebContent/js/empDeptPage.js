function getDepartmentDetail(elementObj){
	$.ajax({
        'url' : '/EmployeeDeptDropDown/jsonServlet',
        'type' : 'GET' ,
		'data' : { 
			'deptId' : elementObj.value 
		},
		'success' : function(data) {   
			$("#empDetail").html('');
			$.each(data, function(index, employee){
				console.log(index+'----'+employee.name);
				//$('#empDetail').append($('<option>').text(employee).attr('value', employee));
				$('#empDetail').append('<option value='+employee.name+'>'+employee.name+'</option>');
			});
		},
        'error' : function(request,error){
            alert('Request: '+request);
			alert('Error: '+error);
        }
    });
}

function logout(){
	
	document.getElementById('empDeptPage').action='/EmployeeDeptDropDown/logoutServlet';
	document.getElementById('empDeptPage').method='post';
	document.getElementById('empDeptPage').submit();
	
}