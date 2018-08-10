$(document).ready(function() {
    getManagers();
});

function getManagers(){
	$.ajax ({
		'url' : './getmanagers',
		'type' : 'GET' ,
		'success' : function(result) {   
			$("#managerSelectId").empty();
			$("#managerSelectId").append('<option value=\'\'></option>');
			alert(JSON.stringify(result));
			console.log(result);
			$.each(result, function(index, manager){
				$('#managerSelectId').append('<option value='+manager.employeeId+'>'+manager.firstName+'</option>');
			});
		
		},
        'error' : function(request,error){
            alert('Request: '+request);
			alert('Error: '+error);
        }
	});
}

function getEmployeeDetail(element) {
	if ($('#managerSelectId').val() != null) {
		$.ajax({
			'url' : './getemployees',
			'type' : 'GET',
			'data' : {
				'mgrId' : element.value
			},
			'success' : function(resultData) {
				console.log(JSON.stringify(resultData));
				if(resultData.errorMessage != null){
					var compiledErrorTemplate = _.template($('#errMsgTempl').html());
					$('#msgDiv').html(compiledErrorTemplate({
						msg : resultData.errorMessage
					}));
				}
				else{
					 $('#empGrid').DataTable({
					  data: resultData,
					  columns: [
						{ "title": "Employee Id", "data" : "employeeId" },
						{ "title": "First Name", "data" : "firstName" },
						{ "title": "Last Name", "data" : "lastName" },
						{ "title": "Salary", "data" : "salary"},
						{ "title": "Hire Date", "data" : "hireDate"},
						{ "title": "Department", "data" : "department"},
						{ "title": "Location", "data" : "location"}
					  ]
					 });
				}
			},
			'error' : function(request, error) {
				alert('Request: ' + request);
				alert('Error: ' + error);
			}
		});
	}
}


function updateDept() {
	if (validateDeptDetail()) {
		var formData = {
			deptId : $("#deptId").val(),
			deptName : $("#deptName").val(),
			locId: $("#locId").val(),
			mgrId : $("#mgrId").val(),
		};
		this.saveDept('update', formData,'./updatedept');
	}
}

function validateDeptDetail() {
	if ($('#deptName').val() == null
			|| $('#deptName').val().trim().length == 0) {
		var compiledErrorTemplate = _.template($('#errMsgTempl').html());
		$('#msgDiv').html(compiledErrorTemplate({
			msg : 'Please enter valid Department Name.'
		}));
		return false;
	}
	if ($('#mgrId').val() == null || $('#mgrId').val().trim().length == 0) {
		var compiledErrorTemplate = _.template($('#errMsgTempl').html());
		$('#msgDiv').html(compiledErrorTemplate({
			msg : 'Please enter valid Manager Id.'
		}));
		return false;
	}
	if ($('#locId').val() == null
			|| $('#locId').val().trim().length == 0) {
		var compiledErrorTemplate = _.template($('#errMsgTempl').html());
		$('#msgDiv').html(compiledErrorTemplate({
			msg : 'Please enter valid Location Id.'
		}));
		return false;
	}
	
	return true;
}

function createDept() {
	if (validateDeptDetailForCreateDept()) {
		var formData = {
			deptName: $("#deptName").val(),
			mgrId : $("#mgrId").val(),
			locId : $("#locId").val(),
		};
		this.saveDept('create', formData,'./savedept');
	}
}

function validateDeptDetailForCreateDept() {
	if ($('#deptName').val() == null
			|| $('#deptName').val().trim().length == 0) {
		var compiledErrorTemplate = _.template($('#errMsgTempl').html());
		$('#msgDiv').html(compiledErrorTemplate({
			msg : 'Please enter valid Department Name'
		}));
		return false;
	}
	if ($('#mgrId').val() == null || $('#mgrId').val().trim().length == 0) {
		var compiledErrorTemplate = _.template($('#errMsgTempl').html());
		$('#msgDiv').html(compiledErrorTemplate({
			msg : 'Please enter valid mgrId.'
		}));
		return false;
	}
	if ($('#locId').val() == null
			|| $('#locId').val().trim().length == 0) {
		var compiledErrorTemplate = _.template($('#errMsgTempl').html());
		$('#msgDiv').html(compiledErrorTemplate({
			msg : 'Please enter valid locId.'
		}));
		return false;
	}
	return true;
}

function deleteDept() {
	if (validateDeptDetailForDeleteDept()) {
		this.saveDept('delete', '', './deletedept/'+$("#deptId").val());
	}
}

function validateDeptDetailForDeleteDept() {
	if ($('#deptId').val() == null || $('#deptId').val().trim().length == 0) {
		var compiledErrorTemplate = _.template($('#errMsgTempl').html());
		$('#msgDiv').html(compiledErrorTemplate({
			msg : 'Please enter a Dept Id.'
		}));
		return false;
	}
	return true;
}
function saveDept(action, formData, actionUrl) {
	if (action != undefined && action != null) {

		$.ajax({
			'url' : actionUrl,
			'type' : 'POST',
			'data' : JSON.stringify(formData),
			'headers' : { 
				'Accept': 'application/json',
				'Content-Type': 'application/json' 
			},
			'success' : function(resultData) {
				if (action == 'update') {
					console.log(JSON.stringify(resultData));
					if (JSON.stringify(resultData).indexOf(
							"Exception Occurred.") != -1) {
						var compiledErrorTemplate = _
								.template($('#errMsgTempl').html());
						$('#msgDiv').html(compiledErrorTemplate({
							msg : resultData
						}));
					} else {
						var compiledDeptDetailTemplate = _.template($(
								"#deptDetailTempl").html());
						$("#pageContainer").html(
								compiledDeptDetailTemplate({
									deptDetail : JSON.parse(resultData.jsonData)
								}));
						$("#updateBtn").click(function() {
							updateDept();
						});
						var compiledInfoTemplate = _
								.template($("#infoMsgTempl").html());
						$("#msgDiv").html(compiledInfoTemplate({
							msg : 'Department Detail updated successfully.'
						}));
					}
				} else if (action == 'create') {
					console.log(JSON.stringify(resultData));
					if (JSON.stringify(resultData).indexOf(
							"Exception Occurred.") != -1) {
						var compiledErrorTemplate = _
								.template($('#errMsgTempl').html());
						$('#msgDiv').html(compiledErrorTemplate({
							msg : resultData
						}));
					} else {
						var compiledDeptDetailTemplate = _.template($(
								"#deptDetailTempl").html());
						$("#pageContainer").html(
								compiledDeptDetailTemplate({
									deptDetail : JSON.parse(resultData.jsonData)
								}));
						$("#updateBtn").click(function() {
							updateDept();
						});
						var compiledInfoTemplate = _
								.template($("#infoMsgTempl").html());
						$("#msgDiv").html(compiledInfoTemplate({
							msg : 'Department Detail created successfully.'
						}));
						getDepartments();
					}
				} else if (action == 'delete') {
					if (JSON.stringify(resultData).indexOf(
							"Exception Occurred.") != -1) {
						var compiledErrorTemplate = _
								.template($('#errMsgTempl').html());
						$('#msgDiv').html(compiledErrorTemplate({
							msg : resultData
						}));
					} else {
					var compiledInfoTemplate = _.template($("#infoMsgTempl")
							.html());
					$("#msgDiv").html(compiledInfoTemplate({
						msg : 'Department Detail deleted successfully.'
					}));
					getDepartments();
					$("#pageContainer").empty();
					}
					
				}
			},
			'error' : function(request, error) {
				alert('Request: ' + request);
				alert('Error: ' + error);
			}
		});
	}
}


function createNewDept() {
	$.ajax({
		'url' : './getmanagerandlocationdetail',
		'type' : 'GET',
		'success' : function(result) {
			console.log(JSON.stringify(result));
			var compiledCreateDeptDetailTemplate = _.template($(
					"#createDeptDetailTemp").html());
			$("#pageContainer").html(compiledCreateDeptDetailTemplate({
				createDeptDetail : JSON.parse(result.jsonData)
			}));
			$("#saveBtn").click(function() {
				createDept();
			});
		},
		'error' : function(request, error) {
			alert('Request: ' + request);
			alert('Error: ' + error);
		}
	});
}

function deleteDepartment() {
	deleteDept();
}
