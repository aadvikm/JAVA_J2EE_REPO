function getEmpDatails(elementObj1, elementObj2){
	$.ajax ({
		'url' : '/LocationMgrEmp/empServlet',
		'type' : 'GET' ,
		'data' : { 
			'mgrId' : elementObj1.value, 'locId' :elementObj2
		},
		'success' : function(data) {   
			$("#empDetail").empty();
			$.each(data, function(index, emp){
				console.log(index+'----'+emp.empId);
				$('#empDetail').append('<option value='+emp.empId+'>'+emp.empName+'</option>');
			});
		},
        'error' : function(request,error){
            alert('Request: '+request);
			alert('Error: '+error);
        }
	});
}


function prev(){
	document.getElementById('mgrEmpPage').action ='/LocationMgrEmp/locationServlet';
	document.getElementById('mgrEmpPage').method='post'
	document.getElementById('mgrEmpPage').submit();
}


function logout(){
	document.getElementById('mgrEmpPage').action ='/LocationMgrEmp/logoutServlet';
	document.getElementById('mgrEmpPage').method='post'
	document.getElementById('mgrEmpPage').submit();
	
}