<!doctype html>
<html lang="en">
<head>
<title>Technology</title>
<style>
	hr { 
 	 display: block;
  	 margin-top: 0.5em;
 	 margin-bottom: 0.5em;
  	 margin-left: auto;
  	 margin-right: auto;
  	 border-style: inset;
  	 border-width: 1px;
	} 
</style>
</head>
<body>
	<!-- Search dan tampilan tabel  -->
	<section class="content">
		<!--  Search -->
		<div class="row">
			<div class="col-xs-12">
				<div class="box">
					<div class="box-body">
						<h3 class="box-title">Technology</h3>
						<br> <br>
						<div class="row">
							<div class="box-tools">
								<div class="col-xs-5">
									<div class="input-group input-group-sm">
										<input type="text" id="search" class="form-control pull-left"
											placeholder="Search by Technology Name">
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
												data-toggle="modal" data-target="#modalTechnology"
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
						<table id="tabel-technology"
							class="table table-bordered table-striped">
							<thead>
								<tr>
									<th>Name</th>
									<th>Created By</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody></tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

		<!-- Pop up Technology -->
		<form id="form-technology">
			<div class="modal fade" id="modalTechnology">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title">Technology</h4>
						</div>
						<div class="modal-body">
							<div class="row">
								<div class="col-xs-12">
									<div class="form-group">
										<input type="hidden" class="form-control" name="id" id="id"
											placeholder="ID">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="form-group">
										<input type="text" class="form-control" name="name" id="name"
											placeholder="Name">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="form-group">
										<textarea class="form-control" name="notes" id="notes"
											placeholder="Notes"></textarea>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="form-group">
										<hr>
									</div>
								</div>
							</div>
						<!-- <div class="row">
								<div class="col-xs-10"></div>
								<div class="col-xs-2">
									<div class="form-group">
										<button type="button" class="btn btn-primary">+
											Trainer</button>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="box">
									<div class="box-body">
										<table id="tabel-add-trainer"
											class="table table-bordered table-striped">
											<thead>
												<tr>
												 <th>Name</th>
												 <th>Action</th>
												</tr>
											</thead>
											<tbody></tbody>
										</table>
									</div>
								</div>
							</div> -->
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default pull-left"
								data-dismiss="modal">Cancel</button>
							<button type="button" onclick="simpan()" class="btn btn-primary">Save</button>
						</div>
					</div>
				</div>
			</div>
		</form>
	</section>

	<!-- Proses -->
	<script>
	var modeSubmit = 'insert';

    //Fungsi Refresh Tabel
	function refreshTabel() {
		$.ajax({
			type: 'get',
			url: 'technology/',
			data: {
				name: $('#search').val()
			},
			success: function(d) {
				tabelTechnology.clear().draw();
				$(d).each(function(index, element){
					tabelTechnology.row.add([
						element.name,
						element.user.username,
						'<div class="input-group-btn">' +
						'<button type="button" class="btn btn-default btn-sm pull-left" data-toggle="dropdown">' +
						'<i class="fa fa-navicon"></i>' +
                        '</button>' +
                        '<ul class="dropdown-menu pull-left">' +
                        '<li><a href="javascript:void(0)" value="Edit" onclick="loadEdit(\'' + element.id + '\')">Edit</a></li>' +
                        '<li><a href="javascript:void(0)" value="Delete" onclick="addTrainer(\'' + element.id + '\')">Add Trainer</a></li>' +
                        '<li><a href="javascript:void(0)" value="Delete" onclick="hapus(\'' + element.id + '\')">Delete</a></li>' +
                        '</ul>' +
                        '</div>'
                    ]).draw();
				})
				
			},
			error: function(d) {
				console.log('Error');
			}
		});
	}

    //Save awal dan edit
	function simpan() {
		var method;
		if (modeSubmit == 'insert') {
			var data = $('#form-technology').serializeJSON();
			method = 'post';
		} else {
			var data = $('#form-technology').serializeJSON();		
			method = 'put';
		}
		if (data.name.trim().length == 0) {
	          $.notify("Input name tidak boleh kosong", "warn");
	    } else {
			$.ajax({
				type : method,
				url : 'technology/',
				data : JSON.stringify(data),
				contentType : 'application/json',
				success : function(d) {
					refreshTabel();
					modeSubmit = 'insert';
					$('#form-technology').trigger("reset");
					$('#form-technology input[type=hidden]').val('');
					if (method == 'post') {
						$.notify("Data successfully saved !", "success");
					}
					if (method == 'put') {
						$.notify("Data successfully update !", "success");
					}
					$('#modalTechnology').modal('hide');
				},
				error : function(d) {
					console.log('Error')
				}
			});
		}
	}

//	Add Trainer
/* 	function loadTrainer(id) {
		$.ajax({
			type : 'get',
			url : 'technology-trainer/trainer-tersedia/' + id,
			success : function(d) {
				refreshTabel();
				$('#batchIdAdd').val(id);
				showBiodata(d);
			},
			error : function(d) {
				console.log('Error');
			}
		});
		$('#form-addTrainer').trigger("reset");
		$('#form-addTrainer input[type=hidden]').val('');
		$('#modalAddTrainer').modal('show');
	} */

	//Load data untuk diedit
	function loadEdit(id) {
		$.ajax({
			type : 'get',
			url : 'technology/' + id,
			success : function(d) {
				refreshTabel();
				$('#id').val(d.id);
				$('#name').val(d.name);
				$('#notes').val(d.notes);
				modeSubmit = 'update';
			},
			error : function(d) {
				console.log('Error');
			}
		});
		$('#modalTechnology').modal('show');
	}

	//Ubah modeSubmit menjadi insert untuk save 
	function insert() {
		modeSubmit = 'insert';
	}

	//Fungsi Hapus
	function hapus(id) {
		if (confirm("Are you sure to delete this data?")) {
			$.ajax({
				type : 'delete',
				url : 'technology/' + id,
				success : function(d) {
					$.notify("Data successfully deleted !", "success");
					refreshTabel();
				},
				error : function(d) {
					console.log('Error');
				}
			});
		}
	}
	
	//Document Ready
	var tabelTechnology;
	$(document).ready(function() {
		tabelTechnology = $('#tabel-technology').DataTable({
			'searching' : false,
			'lengthChange' : false,
			'length' : [ 10 ]
		});
		refreshTabel();
	});

/* 	var tabelAddTrainer;
	$(document).ready(function(){
		tabelAddTrainer = $('#tabel-add-trainer').DataTable({
			'lengthChange' : false,
			'length' : [ 5 ]
		});
		refreshTrainer();	
	}); */
	
	</script>
</body>
</html>