<!doctype html>
<html lang="en">
<head>
<title>Batch</title>
</head>
<body>
	<!-- Tampilan & input -->
	<section class="content">
		<!--  Search -->
		<div class="row">
			<div class="col-xs-12">
				<div class="box">
					<div class="box-body">
						<h3 class="box-title">Batch</h3>
						<br> <br>
						<div class="row">
							<div class="box-tools">
								<div class="col-xs-5">
									<div class="input-group input-group-sm">
										<input type="text" id="search" class="form-control pull-left"
											placeholder="Search by Technology or Name">
										<div class="input-group-btn">
											<button type="button" class="btn btn-default"
												onclick="refreshTabel()">
												<i class="fa fa-search"></i>
											</button>
										</div>
									</div>
								</div>
								<div class="col-xs-6"></div>
								<div class="col-xs-1">
									<div class="input-group input-group-sm">
										<div class="input-group-btn pull-right">
											<button type="button"
												class="btn btn-primary btn-sm pull-right"
												data-toggle="modal" data-target="#modalBatch"
												onclick="insert()">
												<i class="fa fa-plus"></i>
											</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="box-body">
						<table id="tabel-batch" class="table table-bordered table-striped">
							<thead>
								<tr>
									<th>Technology</th>
									<th>Name</th>
									<th>Trainer</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody></tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

		<!-- Pop up Batch -->
		<form id="form-batch">
			<div class="modal fade" id="modalBatch">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title">Batch</h4>
						</div>
						<div class="modal-body">
							<div class="row">
								<div class="col-xs-12">
									<input type="hidden" class="form-control" name="id" id="id"
										placeholder="id">
								</div>
							</div>
							<div class="row">
								<div class="col-xs-6">
									<div class="form-group">
										<input type="text" class="form-control" name="name" id="name"
											placeholder="Name">
									</div>
								</div>
								<div class="col-xs-6">
									<div class="form-group">
										<select class="custom-select d-block w-100 form-control"
											name="roomId" id="roomId">
										</select>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-6">
									<div class="form-group">
										<select class="custom-select d-block w-100 form-control"
											name="technologyId" id="technologyId" onchange = 'loadTechnologyTrainer()'>
										</select>
									</div>
								</div>
								<div class="col-xs-6">
									<div class="form-group">
										<select class="custom-select d-block w-100 form-control"
											name="trainerId" id="trainerId">
											<option value="" disabled selected> - Choose Trainer -</option>
										</select>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-6">
									<div class="form-group">
										<div class="input-group date">
											<div class="input-group-addon">
												<i class="fa fa-calendar"></i>
											</div>
											<input type="text" class="form-control" name="periodFrom"
												id="periodFrom" placeholder="Period From">
										</div>
									</div>
								</div>
								<div class="col-xs-6">
									<div class="form-group">
										<div class="input-group date">
											<div class="input-group-addon">
												<i class="fa fa-calendar"></i>
											</div>
											<input type="text" class="form-control" name="periodTo"
												id="periodTo" placeholder="Period To">
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-6">
									<div class="form-group">
										<select class="custom-select d-block w-100 form-control"
											name="bootcampTypeId" id="bootcampTypeId">
										</select>
									</div>
								</div>
								<div class="col-xs-6">
									<div class="form-group">
										<textarea class="form-control" rows="2" name="notes"
											id="notes" placeholder="Notes"></textarea>
									</div>
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default pull-left"
								data-dismiss="modal">Cancel</button>
							<button type="button" class="btn btn-primary" onclick="simpan()">Save</button>
						</div>
					</div>
				</div>
			</div>
		</form>

		<!-- Pop up Add Participant -->
		<form id="form-addParticipant">
			<div class="modal fade" id="modalAddParticipant">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title">Add Particpant</h4>
						</div>
						<div class="modal-body">
							<div class="row">
								<div class="col-xs-12">
									<div class="form-group">
										<input type="hidden" class="form-control" name="batchId"
											id="batchIdAdd">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="form-group">
										<select class="custom-select d-block w-100 form-control"
											name="biodataId" id="biodataId"></select>
									</div>
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default pull-left"
								data-dismiss="modal">Cancel</button>
							<button type="button" class="btn btn-primary"
								onclick="simpanPartcipant()">Save</button>
						</div>
					</div>
				</div>
			</div>
		</form>

		<!-- Pop up Setup Test -->
		<form id="form-setupTest">
			<div class="modal fade" id="modalSetupTest">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title">Setup Test</h4>
						</div>
						<div class="row">
								<div class="col-xs-12">
									<input type="hidden" class="form-control" name="batchId" id="batchIdTest"
										placeholder="BatchId">
								</div>
							</div>
						<div class="modal-body">
							<div id="setupTest"></div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-primary" onclick="simpanSetupTest()">Close</button>
						</div>
					</div>
				</div>
			</div>
		</form>
		
	</section>

	<!-- Proses -->
	<script>
	var modeSubmit = 'insert';
	
	function refreshTabel() {
		$.ajax({
			type: 'get',
			url: 'batch/',
			data: {
				name: $('#search').val()
			},
			success: function(d) {
				tabelBatch.clear().draw();
				$(d).each(function(index, element){
					tabelBatch.row.add([
						element.technology.name,
						element.name,
						element.trainer.name,
						'<div class="input-group-btn">' +
						'<button type="button" class="btn btn-default btn-sm pull-left" data-toggle="dropdown">' +
						'<i class="fa fa-navicon"></i>' +
                        '</button>' +
                        '<ul class="dropdown-menu pull-left">' +
                        '<li><a href="javascript:void(0)" value="Edit" onclick="loadEdit(\'' + element.id + '\')">Edit</a></li>' +
                        '<li><a href="javascript:void(0)" value="Delete" onclick="loadParticipant(\'' + element.id + '\')">Add Participant</a></li>' +
                        '<li><a href="javascript:void(0)" value="Delete" onclick="loadTest(\'' + element.id + '\')">Setup Test</a></li>' +
                        '</ul>' +
                        '</div>'
						//'<input class="btn btn-default btn-sm" type="button" value="Edit" data-toggle="modal" data-target="#modalBatch" onclick="loadEdit(\'' + element.id + '\')"> &nbsp;' +
						//'<input class="btn btn-danger btn-sm" type="button" value="Add Participant" data-toggle="modal" data-target="#modalAddParticipant" onclick="loadParticipant(\'' + element.id + '\')"> &nbsp;' +
						//'<input class="btn btn-primary btn-sm" type="button" data-toggle="modal" data-target="#modalSetupTest" value="Setup Test" onclick="loadTest(\'' + element.id + '\')"> '
					]).draw();
				})	
			},
			error: function(d) {
				console.log('Error');
			}
		});
	}

	function loadTest(id) {
		$.ajax({
			type: 'GET',
			url: 'test/',
			success: function(d) {
				$('#batchIdTest').val(id);
				showTest(d);
			},
			error: function(d) {
				console.log('Error - loadTest');
			}
		});
	}

	function showTest(d) {
		var s = '';
		$(d).each(function(index, element) {
			s+= '<div class="row">'+
					'<div class="col-xs-12">'+
						'<div class="input-group input-group-sm">'+
							'<input type="text" class="form-control" value="' + element.name + '" readonly>'+ 
							'<span class="input-group-btn">'+
								'<input type="checkbox" value="' + element.id + '" name="testId[]" id="cek' + element.id + '">'+
							'</span>'+
						'</div>'+
					'</div>'+
				'</div>'
		});
		$('#setupTest').html(s);	
	}

	function simpanSetupTest() {
		var data = $('#form-setupTest').serializeJSON();
		$.ajax({
			type : 'post',
			url : 'batchTest/',
			data : JSON.stringify(data),
			contentType : 'application/json',
			success : function(d) {
				refreshTabel();
				
			},
			error : function(d) {
				console.log('Error')
			} 
		}); 
	}

	function simpan() {
		var method;
		if (modeSubmit == 'insert') {
			var data = $('#form-batch').serializeJSON();
			method = 'post';
		} else {
		var data = $('#form-batch').serializeJSON();
			$('#modalBatch').modal('hide');
			method = 'put';
		}
		if (data.name.trim().length == 0) {
	          $.notify("Input name tidak boleh kosong", "warn");
	    } else if ($('#periodFrom').val() >= $('#periodTo').val()) {
			$.notify("Period From Harus Lebih Kecil dari Period To", "warn");
		} else {
			$.ajax({
				type : method,
				url : 'batch/',
				data : JSON.stringify(data),
				contentType : 'application/json',
				success : function(d) {
					refreshTabel();	
					modeSubmit = 'insert';	
					$('#form-batch').trigger("reset");
					$('#form-batch input[type=hidden]').val('');
					$('#modalBatch').modal('hide');
					if (method == 'post') {
						$.notify("Data successfully saved !", "success");
					}
					if (method == 'put') {
						$.notify("Data successfully update !", "success");
					}	
				},
				error : function(d) {
					$.notify(d.responseText, "warn");
				}
			});
		}
	}

	//	Add Participant
	function loadParticipant(id) {
		$.ajax({
			type : 'get',
			url : 'clazz/biodata-tersedia/' + id,
			success : function(d) {
				refreshTabel();
				$('#batchIdAdd').val(id);
				showBiodata(d);
			},
			error : function(d) {
				console.log('Error');
			}
		});
		$('#form-addParticipant').trigger("reset");
		$('#form-addParticipant input[type=hidden]').val('');
		$('#modalAddParticipant').modal('show');
	}

	function simpanPartcipant() {
		var data = $('#form-addParticipant').serializeJSON();
		$('#modalAddParticipant').modal('hide');
		$.ajax({
			type : 'post',
			url : 'clazz/',
			data : JSON.stringify(data),
				contentType : 'application/json',
				success : function(d) {
					refreshTabel();
					$.notify("Data has been added !", "success");
				},
				error : function(d) {
					console.log('Error');
				}
		});
	}

	//Ubah modeSubmit inser untuk save data awal
	function insert() {
		modeSubmit = 'insert';
		$('#form-batch').trigger("reset");
		$('#form-batch input[type=hidden]').val('');
	}

	//load data untuk diedit
	function loadEdit(id) {
		$.ajax({
			type : 'get',
			url : 'batch/' + id,
			success : function(d) {
				refreshTabel();
				$('#id').val(d.id);
				$('#name').val(d.name);
				$('#roomId').val(d.roomId);
				$('#technologyId').val(d.technologyId);
				$('#trainerId').val(d.trainerId);
				$('#periodFrom').val(d.periodFrom);
				$('#periodTo').val(d.periodTo);
				$('#bootcampTypeId').val(d.bootcampTypeId);
				$('#notes').val(d.notes);
				modeSubmit = 'update';
			},
			error : function(d) {
				console.log('Error');
			}
		});
		$('#modalBatch').modal('show');
	}

	//Load dan show dropdown
	function loadRoom() {
		$.ajax({
			type : 'GET',
			url : 'room/',
			success : function(d) {
				showRoom(d);
			},
			error : function(d) {
				console.log('Error - loadRoom');
			}
		});
	}

	function showRoom(d) {
		var s = '<option value="" disabled selected> - Choose Room -</option>';
		$(d).each(function(index, element) {
			s += '<option value="' + element.id 
              + '" data-nama="' + element.name + '">'
			  + element.name + '</option>';
		});
		$('#roomId').html(s);
	}

	function loadTechnologyTrainer() {
		var id=$('#technologyId').val();
		$.ajax({
			type : 'GET',
			url : 'technology-trainer/' + id,
			success : function(d) {
				showTrainer(d);
			},
			error : function(d) {
				console.log('Error - loadTechnologyTrainer');
			}
		});
	} 
	
		
	function loadTechnology() {
		$.ajax({
			type : 'GET',
			url : 'technology/',
			success : function(d) {
				showTechnology(d);
			},
			error : function(d) {
				console.log('Error - loadTechnology');
			}
		});
	}

	function showTechnology(d) {
		var s = '<option value="" disabled selected> - Choose Technology -</option>';
		$(d).each(function(index, element) {
			s += '<option value="' + element.id 
           	  + '" data-nama="' + element.name + '">'
			  + element.name + '</option>';
		});
		$('#technologyId').html(s);
	}

/*  	function loadTrainer() {
		$.ajax({
			type : 'GET',
			url : 'trainer/',
			success : function(d) {
				showTrainer(d);
			},
			error : function(d) {
				console.log('Error - loadTrainer');
			}
		});
	} */
	 
	function showTrainer(d) {
		var s = '<option value="" disabled selected> - Choose Trainer -</option>';
		$(d).each(function(index, element) {
			s += '<option value="' + element.trainerId 
              + '" data-nama="' + element.trainer.name + '">'
			  + element.trainer.name + '</option>';
		});
		$('#trainerId').html(s);
	}

	function loadBootcampType() {
		$.ajax({
			type : 'GET',
			url : 'bootcampType/',
			success : function(d) {
				showBootcampType(d);
			},
			error : function(d) {
				console.log('Error - loadBootcampType');
			}
		});
	}

	function showBootcampType(d) {
		var s = '<option value="" disabled selected> - Choose BootcampType -</option>';
		$(d).each(function(index, element) {
			s += '<option value="' + element.id 
              + '" data-nama="' + element.name + '">'
			  + element.name + '</option>';
		});
		$('#bootcampTypeId').html(s);
	}

/* 	function loadBiodata() {
		$.ajax({
			type : 'GET',
			url : 'bootcampType/findAll/',
			success : function(d) {
				showBiodata(d);
			},
			error : function(d) {
				console.log('Error - loadBiodata');
			}
		});
	} */

	function showBiodata(d) {
		var s = '<option value="" disabled selected> - Add Participant -</option>';
		$(d).each(function(index, element) {
			s += '<option value="' + element.id 
           	  + '" data-nama="' + element.name + '">'
		      + element.name + '</option>';
		});
		$('#biodataId').html(s);
	}
		
	var tabelBatch;
	$(document).ready(function() {
		tabelBatch = $('#tabel-batch').DataTable({
			'searching' : false,
			'lengthChange' : false,
			'lengthMenu' : [ 10 ]
		});
		$('#periodFrom').datepicker({
			autoclose : true,
			format : 'yyyy-mm-dd'
		});
		$('#periodTo').datepicker({
			autoclose : true,
			format : 'yyyy-mm-dd'
		});
		refreshTabel();
			loadRoom();
			loadTechnology();
			//loadTrainer();
			loadBootcampType();
			//loadBiodata();
		});
	</script>
</body>
</html>