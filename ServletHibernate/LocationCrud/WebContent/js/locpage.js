function getLocations() {
	$.ajax({
		'url' : '/LocationCrud/locServlet',
		'type' : 'GET',
		'success' : function(result) {
			$("#locations").empty();
			$("#locations").append('<option value=\'\'></option>');
			alert(JSON.stringify(result));
			$.each(result, function(index, location) {
				console.log(index + '----' + location.locId);
				$('#locations').append(
						'<option value=' + location.locId + '>' + location.city
								+ '</option>');
			});

		},
		'error' : function(request, error) {
			alert('Request: ' + request);
			alert('Error: ' + error);
		}
	});
}

function getLocDetails(element) {
	if ($('#locations').val() != null) {
		$.ajax({
			'url' : '/LocationCrud/locDetailServlet',
			'type' : 'GET',
			'data' : {
				'locId' : element.value
			},
			'success' : function(resultData) {
				console.log(JSON.stringify(resultData));
				var compiledLocDetailTemplate = _.template($("#locDetailTempl")
						.html());
				$("#pageContainer").html(compiledLocDetailTemplate({
					locDetail : resultData
				}));
				$("#updateBtn").click(function() {
					updateLoc();
				});

			},
			'error' : function(request, error) {
				alert('Request: ' + request);
				alert('Error: ' + error);
			}
		});
	}
}

function updateLoc() {
	if (validateLocDetail()) {
		var formData = {
			action : 'update',
			locId : $("#locId").val(),
			streetAdd : $("#streetAdd").val(),
			city : $("#city").val(),
			postalCode : $("#postalCode").val(),
			stateProvince : $("#stateProvince").val(),
			countryId : $("#countryId").val()
		};
		this.saveLoc('update', formData);
	}
}

function createLoc() {
	if (validateLocDetailForCreateLoc()) {
		var formData = {
			action : 'create',
			streetAdd : $("#streetAdd").val(),
			city : $("#city").val(),
			postalCode : $("#postalCode").val(),
			stateProvince : $("#stateProvince").val(),
			countryId : $("#countryId").val()
		};
		this.saveLoc('create', formData);
	}
}

function deleteLoc() {
	if (validateLocDetailForDeleteLoc()) {
		var formData = {
			action : 'delete',
			locId : $("#locId").val()
		};
		this.saveLoc('delete', formData);
	}
}

function validateLocDetailForDeleteLoc() {
	if ($('#locId').val() == null || $('#locId').val().trim().length == 0) {
		var compiledErrorTemplate = _.template($('#errMsgTempl').html());
		$('#msgDiv').html(compiledErrorTemplate({
			msg : 'Please enter a Location Id.'
		}));
		return false;
	}
	return true;
}

function validateLocDetailForCreateLoc() {
	if ($('#streetAdd').val() == null
			|| $('#streetAdd').val().trim().length == 0) {
		var compiledErrorTemplate = _.template($('#errMsgTempl').html());
		$('#msgDiv').html(compiledErrorTemplate({
			msg : 'Please enter valid Street Address.'
		}));
		return false;
	}
	if ($('#city').val() == null || $('#city').val().trim().length == 0) {
		var compiledErrorTemplate = _.template($('#errMsgTempl').html());
		$('#msgDiv').html(compiledErrorTemplate({
			msg : 'Please enter valid city.'
		}));
		return false;
	}
	if ($('#postalCode').val() == null
			|| $('#postalCode').val().trim().length == 0) {
		var compiledErrorTemplate = _.template($('#errMsgTempl').html());
		$('#msgDiv').html(compiledErrorTemplate({
			msg : 'Please enter valid Postal code.'
		}));
		return false;
	}
	if ($('#stateProvince').val() == null
			|| $('#stateProvince').val().trim().length == 0) {
		var compiledErrorTemplate = _.template($('#errMsgTempl').html());
		$('#msgDiv').html(compiledErrorTemplate({
			msg : 'Please enter  a State Province.'
		}));
		return false;
	}
	if ($('#countryId').val() == null
			|| $('#countryId').val().trim().length == 0) {
		var compiledErrorTemplate = _.template($('#errMsgTempl').html());
		$('#msgDiv').html(compiledErrorTemplate({
			msg : 'Please enter a Country Id.'
		}));
		return false;
	}
	return true;
}

function validateLocDetail() {
	if ($('#streetAdd').val() == null
			|| $('#streetAdd').val().trim().length == 0) {
		var compiledErrorTemplate = _.template($('#errMsgTempl').html());
		$('#msgDiv').html(compiledErrorTemplate({
			msg : 'Please enter valid Street Address.'
		}));
		return false;
	}
	if ($('#city').val() == null || $('#city').val().trim().length == 0) {
		var compiledErrorTemplate = _.template($('#errMsgTempl').html());
		$('#msgDiv').html(compiledErrorTemplate({
			msg : 'Please enter valid city.'
		}));
		return false;
	}
	if ($('#postalCode').val() == null
			|| $('#postalCode').val().trim().length == 0) {
		var compiledErrorTemplate = _.template($('#errMsgTempl').html());
		$('#msgDiv').html(compiledErrorTemplate({
			msg : 'Please enter valid Postal code.'
		}));
		return false;
	}
	if ($('#stateProvince').val() == null
			|| $('#stateProvince').val().trim().length == 0) {
		var compiledErrorTemplate = _.template($('#errMsgTempl').html());
		$('#msgDiv').html(compiledErrorTemplate({
			msg : 'Please enter  a State Province.'
		}));
		return false;
	}
	if ($('#countryId').val() == null
			|| $('#countryId').val().trim().length == 0) {
		var compiledErrorTemplate = _.template($('#errMsgTempl').html());
		$('#msgDiv').html(compiledErrorTemplate({
			msg : 'Please enter a Country Id.'
		}));
		return false;
	}
	if ($('#locId').val() == null || $('#locId').val().trim().length == 0) {
		var compiledErrorTemplate = _.template($('#errMsgTempl').html());
		$('#msgDiv').html(compiledErrorTemplate({
			msg : 'Please enter a Location Id.'
		}));
		return false;
	}
	return true;
}

function saveLoc(action, formData) {
	if (action != undefined && action != null) {

		$.ajax({
			'url' : '/LocationCrud/locCrud',
			'type' : 'POST',
			'data' : formData,
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
						var compiledLocDetailTemplate = _.template($(
								"#locDetailTempl").html());
						$("#pageContainer").html(
								compiledLocDetailTemplate({
									locDetail : resultData
								}));
						$("#updateBtn").click(function() {
							updateLoc();
						});
						var compiledInfoTemplate = _
								.template($("#infoMsgTempl").html());
						$("#msgDiv").html(compiledInfoTemplate({
							msg : 'Location Detail updated successfully.'
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
						var compiledLocDetailTemplate = _.template($(
								"#locDetailTempl").html());
						$("#pageContainer").html(
								compiledLocDetailTemplate({
									locDetail : resultData
								}));
						$("#updateBtn").click(function() {
							updateLoc();
						});
						var compiledInfoTemplate = _
								.template($("#infoMsgTempl").html());
						$("#msgDiv").html(compiledInfoTemplate({
							msg : 'Location Detail created successfully.'
						}));
						getLocations();
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
						msg : 'Location Detail deleted successfully.'
					}));
					getLocations();
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

function createNewLoc() {
	$.ajax({
		'url' : '/LocationCrud/countryListServlet',
		'type' : 'GET',
		'success' : function(result) {
			console.log(JSON.stringify(result));
			var compiledCreateLocDetailTemplate = _.template($(
					"#createLocDetailTemp").html());
			$("#pageContainer").html(compiledCreateLocDetailTemplate({
				createLocDetail : result
			}));
			$("#saveBtn").click(function() {
				createLoc();
			});
		},
		'error' : function(request, error) {
			alert('Request: ' + request);
			alert('Error: ' + error);
		}
	});
}

function deleteLocation() {
	deleteLoc();
}

function logout(){
	document.getElementById('locPage').action='/LocationCrud/logoutServlet';
	document.getElementById('locPage').method='get';
	document.getElementById('locPage').submit();
}