function getDepartments(){
	$.ajax ({
		'url' : '/UpdateDepartment/deptServlet',
		'type' : 'GET' ,
		'success' : function(result) {   
			$("#departments").empty();
			$("#departments").append('<option value=\'\'></option>');
			$.each(result, function(index, dept){
				console.log(index+'----'+dept.deptId);
				$('#departments').append('<option value='+dept.deptId+'>'+dept.deptName+'</option>');
			});
		
		},
        'error' : function(request,error){
            alert('Request: '+request);
			alert('Error: '+error);
        }
	});
}

function getDeptDetails(element){
	if($('#departments').val() !=null){
		$.ajax ({
			'url' : '/UpdateDepartment/deptDetailServlet',
			'type' : 'GET' ,
			'data' : {'deptId' : element.value},
				'success' : function(resultData) {   
					console.log(JSON.stringify(resultData));
					var compiledDeptDetailTemplate = _.template($("#deptDetailTempl").html());
					$("#departmentDetailDiv").html(compiledDeptDetailTemplate({deptDetail : resultData}));
					$("#updateBtn").click(function(){
						updateDept();
					});
					
				},
		        'error' : function(request,error){
		            alert('Request: '+request);
					alert('Error: '+error);
		        }
		});
	}
}

function validateDeptDetail(){
	if($('#deptName').val() == null && $('#deptName').val().trim().length() == 0){
		var compiledErrorTemplate = _.template($('#errMsgTempl').html());
		$('#msgDiv').html(compiledErrorTemplate({msg : 'Please enter valid Dept Name.'}));
		return false;
	}
	if($('#managerId').val() ==null && $('#managerId').val().trim().length() ==0){
		var compiledErrorTemplate = _.template($('#errMsgTempl').html());
		$('#msgDiv').html(compiledErrorTemplate({msg : 'Please select a manager.'}));
		return false;
	}
	if($('#locationId').val() == null && $('#locationId').val().trim().length() ==0){
		var compiledErrorTemplate = _.template($('#errMsgTempl').html());
		$('#msgDiv').html(compiledErrorTemplate({msg : 'Please select a location.'}));
		return false;
	}
	return true;
}

function updateDept(){
		if(validateDeptDetail()){
			var formData = {action : 'update', deptId: $("#deptId").val(), deptName : $("#deptName").val(), managerId : $("#managerId").val(), locationId : $("#locationId").val()};
			this.saveDept('update', formData);
		}
}

function createDept(){
		if(validateDeptDetail()){
			var formData = {action : 'create', deptId: '', deptName : $("#deptName").val(), managerId : $("#managerId").val(), locationId : $("#locationId").val()};
			this.saveDept('create', formData);
		}
}

function deleteDept(){
		var formData = {action : 'create', deptId: $("#deptId").val()};
		this.saveDept('delete', formData);
}

function saveDept(action, formData){

	if(action != undefined && action != null){
		
		$.ajax ({
			'url' : '/UpdateDepartment/deptCrud',
			'type' : 'POST' ,
			'data' : formData,
				'success' : function(resultData) {
					if(action == 'update'){
						console.log(JSON.stringify(resultData));
						var compiledDeptDetailTemplate = _.template($("#deptDetailTempl").html());
						$("#departmentDetailDiv").html(compiledDeptDetailTemplate({deptDetail : resultData}));
						$("#updateBtn").click(function(){
							updateDept();
						});
						var compiledInfoTemplate = _.template($("#infoMsgTempl").html());
						$("#msgDiv").html(compiledInfoTemplate({msg : 'Department Detail updated successfully.'}));
					}
					else if(action == 'delete'){
						var compiledInfoTemplate = _.template($("#infoMsgTempl").html());
						$("#msgDiv").html(compiledInfoTemplate({msg : 'Department Detail deleted successfully.'}));
					}
					else if(action == 'create'){
						var compiledInfoTemplate = _.template($("#infoMsgTempl").html());
						$("#msgDiv").html(compiledInfoTemplate({msg : 'Department Detail created successfully.'}));
					}
				},
		        'error' : function(request,error){
		            alert('Request: '+request);
					alert('Error: '+error);
		        }
		});
	}
}