<!doctype html>
<html lang="en">
<head>
<title>Trainer</title>
</head>
<body>
	<!-- Search dan tampilan tabel  -->
	<section class="content">
		<!--  Search -->
		<div class="row">
			<div class="col-xs-12">
				<div class="box">
					<div class="box-body">
						<h3 class="box-title">Trainer</h3>
						<br> <br>
						<div class="row">
							<div class="box-tools">
								<div class="col-xs-5">
									<div class="input-group input-group-sm">
										<input type="text" id="search" class="form-control pull-left"
											placeholder="Search by Trainer Name">
										<div class="input-group-btn">
											<button type="button" class="btn btn-default" onclick="refreshTabel()">
												<i class="fa fa-search"></i>
											</button>
										</div>
									</div>
								</div>
								<div class="col-xs-6"></div>
								<div class="col-xs-1">
									<div class="input-group input-group-sm">
										<div class="input-group-btn pull-right">
											<button type="button" class="btn btn-primary btn-sm pull-right"
												data-toggle="modal" data-target="#modalTrainer" onclick="insert()">
												<i class="fa fa-plus"></i>
											</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="box-body">
						<table id="tabel-trainer" class="table table-bordered table-striped">
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
			</div>
		</div>

		<!-- Pop up Biodata -->
		<form id="form-trainer">
			<div class="modal fade" id="modalTrainer">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title">Trainer</h4>
						</div>
						<div class="modal-body">
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
										<textarea class="form-control" name="notes"
											id="notes" placeholder="Notes"></textarea>
									</div>
								</div>
							</div>
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
	
	function cekHuruf(a) {
        valid = /^[A-Za-z]{1,}$/;
        return valid.test(a);
     }
    
    function cekAngka(a) {
        valid = /^[0-9]{1,}$/;
        return valid.test(a);
     }

    //Fungsi Refresh Tabel
	function refreshTabel() {
		$.ajax({
			type: 'get',
			url: 'trainer/',
			data: {
				name: $('#search').val()
			},
			success: function(d) {
				tabelTrainer.clear().draw();
				$(d).each(function(index, element){
					tabelTrainer.row.add([
						element.name,
						'<div class="input-group-btn">' +
						'<button type="button" class="btn btn-default btn-sm pull-left" data-toggle="dropdown">' +
						'<i class="fa fa-navicon"></i>' +
                        '</button>' +
                        '<ul class="dropdown-menu pull-left">' +
                        '<li><a href="javascript:void(0)" value="Edit" onclick="loadEdit(\'' + element.id + '\')">Edit</a></li>' +
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
			var data = $('#form-trainer').serializeJSON();
			
			method = 'post';
		} else {
			var data = $('#form-trainer').serializeJSON();
			
			method = 'put';
		}
		if (data.name.trim().length == 0) {
	          $.notify("Input name tidak boleh kosong", "warn");
	    } else {
			$.ajax({
				type : method,
				url : 'trainer/',
				data : JSON.stringify(data),
				contentType : 'application/json',
				success : function(d) {
					refreshTabel();
					modeSubmit = 'insert';
					$('#form-trainer').trigger("reset");
					$('#form-trainer input[type=hidden]').val('');
					if (method == 'post') {
						$.notify("Data successfully saved !", "success");
					}
					if (method == 'put') {
						$.notify("Data successfully update !", "success");
					}
					$('#modalTrainer').modal('hide');
				},
				error : function(d) {
					console.log('Error')
				}
			});
		}
	}

	//Load data untuk diedit
	function loadEdit(id) {
		$.ajax({
			type : 'get',
			url : 'trainer/' + id,
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
		$('#modalTrainer').modal('show');
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
				url : 'trainer/' + id,
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
	var tabelTrainer;
	$(document).ready(function() {
		tabelTrainer = $('#tabel-trainer').DataTable({
			'searching' : false,
			'lengthChange' : false,
			'length' : [ 10 ]
		});
		refreshTabel();
	});
	
	</script>
</body>
</html>