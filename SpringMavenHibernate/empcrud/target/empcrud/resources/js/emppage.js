function getEmployees() {
	$.ajax({
		'url' : './getemployees',
		'type' : 'GET',
		'success' : function(result) {
			$("#employees").empty();
			$("#employees").append('<option value=\'\'></option>');
			alert(JSON.stringify(result));
			$.each(JSON.parse(result.jsonData), function(index, employee) {
				console.log(index + '----' + employee.empId);
				$('#employees').append(
						'<option value=' + employee.empId + '>'
								+ employee.firstName + '</option>');
			});

		},
		'error' : function(request,error){
            alert('Request: '+request);
			alert('Error: '+error);
        }
	});
}

function getEmployeeDetail(element) {
	if ($('#employees').val() != null) {
		$.ajax({
			'url' : './getempdetail',
			'type' : 'POST',
			'data' : {
				'empId' : element.value
			},
			'success' : function(resultData) {
				console.log(JSON.stringify(resultData));
				if (resultData.errorMessage != null) {
					var compiledErrorTemplate = _.template($('#errMsgTempl')
							.html());
					$('#msgDiv').html(compiledErrorTemplate({
						msg : resultData.errorMessage
					}));
				} else {
					var compiledEmpDetailTemplate = _.template($(
							"#empDetailTempl").html());
					$("#pageContainer").html(compiledEmpDetailTemplate({
						empDetail : JSON.parse(resultData.jsonData)
					}));
					$("#updateBtn").click(function() {
						updateEmp();
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

function updateEmp() {
	if (validateEmpDetail()) {
		var formData = {
			empId : $("#empId").val(),
			firstName : $("#firstName").val(),
			lastName : $("#lastName").val(),
			salary : $("#salary").val(),
			hireDate : $("#hireDate").val(),
			managerId : $("#managerId").val(),
			deptId : $("#deptId").val()
		};
		this.saveEmp('update', formData,'./updateemp');
	}
}

function createEmp() {
	if (validateEmpDetailForCreateEmp()) {
		var formData = {
			firstName : $("#firstName").val().trim(),
			lastName : $("#lastName").val().trim(),
			salary : $("#salary").val().trim(),
			hireDate : $("#hireDate").val().trim(),
			managerId : $("#managerId").val().trim(),
			deptId : $("#deptId").val().trim()
		};
		this.saveEmp('create', formData, './saveemp');
	}
}

function deleteEmp() {
	if (validateEmpDetailForDeleteEmp()) {
		this.saveEmp('delete', '', './deleteemp/'+$("#empId").val());
	}
}
function validateEmpDetail() {
	if ($('#firstName').val() == null
			|| $('#firstName').val().trim().length == 0) {
		var compiledErrorTemplate = _.template($('#errMsgTempl').html());
		$('#msgDiv').html(compiledErrorTemplate({
			msg : 'Please enter valid Employee FirstName.'
		}));
		return false;
	}
	if ($('#lastName').val() == null
			|| $('#lastName').val().trim().length == 0) {
		var compiledErrorTemplate = _.template($('#errMsgTempl').html());
		$('#msgDiv').html(compiledErrorTemplate({
			msg : 'Please enter valid Employee LastName.'
		}));
		return false;
	}
	if ($('#salary').val() == null || $('#salary').val().trim().length == 0) {
		var compiledErrorTemplate = _.template($('#errMsgTempl').html());
		$('#msgDiv').html(compiledErrorTemplate({
			msg : 'Please enter valid salary.'
		}));
		return false;
	}
	if ($('#hireDate').val() == null || $('#hireDate').val().trim().length == 0) {
		var compiledErrorTemplate = _.template($('#errMsgTempl').html());
		$('#msgDiv').html(compiledErrorTemplate({
			msg : 'Please enter valid Hiredate.'
		}));
		return false;
	}
	if ($('#managerId').val() == null || $('#managerId').val().trim().length == 0) {
		var compiledErrorTemplate = _.template($('#errMsgTempl').html());
		$('#msgDiv').html(compiledErrorTemplate({
			msg : 'Please select a manager.'
		}));
		return false;
	}
	if ($('#deptId').val() == null || $('#deptId').val().trim().length == 0) {
		var compiledErrorTemplate = _.template($('#errMsgTempl').html());
		$('#msgDiv').html(compiledErrorTemplate({
			msg : 'Please select a department.'
		}));
		return false;
	}
	if ($('#empId').val() == null || $('#empId').val().trim().length == 0) {
		var compiledErrorTemplate = _.template($('#errMsgTempl').html());
		$('#msgDiv').html(compiledErrorTemplate({
			msg : 'Please select a employee id.'
		}));
		return false;
	}
	return true;
}


function validateEmpDetailForCreateEmp(){
	if ($('#firstName').val() == null
			|| $('#firstName').val().trim().length == 0) {
		var compiledErrorTemplate = _.template($('#errMsgTempl').html());
		$('#msgDiv').html(compiledErrorTemplate({
			msg : 'Please enter valid Employee FirstName.'
		}));
		return false;
	}
	if ($('#lastName').val() == null
			|| $('#lastName').val().trim().length == 0) {
		var compiledErrorTemplate = _.template($('#errMsgTempl').html());
		$('#msgDiv').html(compiledErrorTemplate({
			msg : 'Please enter valid Employee LastName.'
		}));
		return false;
	}
	if ($('#salary').val() == null || $('#salary').val().trim().length == 0) {
		var compiledErrorTemplate = _.template($('#errMsgTempl').html());
		$('#msgDiv').html(compiledErrorTemplate({
			msg : 'Please enter valid salary.'
		}));
		return false;
	}
	if ($('#hireDate').val() == null || $('#hireDate').val().trim().length == 0) {
		var compiledErrorTemplate = _.template($('#errMsgTempl').html());
		$('#msgDiv').html(compiledErrorTemplate({
			msg : 'Please enter valid Hiredate.'
		}));
		return false;
	}
	if ($('#managerId').val() == null || $('#managerId').val().trim().length == 0) {
		var compiledErrorTemplate = _.template($('#errMsgTempl').html());
		$('#msgDiv').html(compiledErrorTemplate({
			msg : 'Please select a manager.'
		}));
		return false;
	}
	if ($('#deptId').val() == null || $('#deptId').val().trim().length == 0) {
		var compiledErrorTemplate = _.template($('#errMsgTempl').html());
		$('#msgDiv').html(compiledErrorTemplate({
			msg : 'Please select a department.'
		}));
		return false;
	}
	return true;
}

function validateEmpDetailForDeleteEmp(){
	if ($('#empId').val() == null || $('#empId').val().trim().length == 0) {
		var compiledErrorTemplate = _.template($('#errMsgTempl').html());
		$('#msgDiv').html(compiledErrorTemplate({
			msg : 'Please select a employee id.'
		}));
		return false;
	}
	return true;
}

function saveEmp(action, formData, actionUrl) {
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
					}  else {
						var compiledEmpDetailTemplate = _.template($(
								"#empDetailTempl").html());
						$("#pageContainer").html(
								compiledEmpDetailTemplate({
									empDetail : JSON.parse(resultData.jsonData)
								}));
						$("#updateBtn").click(function() {
							updateEmp();
						});
						var compiledInfoTemplate = _
								.template($("#infoMsgTempl").html());
						$("#msgDiv").html(compiledInfoTemplate({
							msg : 'Employee Detail updated successfully.'
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
						var compiledCreateEmpDetailTemplate = _.template($(
								"#empDetailTempl").html());
						$("#pageContainer").html(
								compiledCreateEmpDetailTemplate({
									empDetail : JSON.parse(resultData.jsonData)
								}));
						$("#updateBtn").click(function() {
							updateEmp();
						});
						var compiledInfoTemplate = _
								.template($("#infoMsgTempl").html());
						$("#msgDiv").html(compiledInfoTemplate({
							msg : 'New employee created successfully.'
						}));
						getEmployees();
					}
				} else if (action == 'delete') {
					var compiledInfoTemplate = _.template($("#infoMsgTempl")
							.html());
					$("#msgDiv").html(compiledInfoTemplate({
						msg : 'Employee detail deleted successfully.'
					}));
					getEmployees();
					$("#pageContainer").empty();
					}
				
			},
			'error' : function(request,error){
            alert('Request: '+request);
			alert('Error: '+error);
        }
	});

	}
}

function createNewEmp() {
	$.ajax({
		'url' : './getmanageranddeptdetail',
		'type' : 'GET',
		'success' : function(result) {
			console.log(JSON.stringify(result));
			var compiledCreateEmpDetailTemplate = _.template($(
					"#createEmpDetailTemp").html());
			$("#pageContainer").html(compiledCreateEmpDetailTemplate({
				empDetail : JSON.parse(result.jsonData)
			}));
			$("#saveBtn").click(function() {
				createEmp();
			});
		},
		'error' : function(request, error) {
			alert('Request: ' + request);
			alert('Error: ' + error);
		}
	});
}


function deleteEmployee() {
	deleteEmp();
}