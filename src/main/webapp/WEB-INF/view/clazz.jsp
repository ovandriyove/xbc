<!doctype html>
<html lang="en">
<head>
<title>Class</title>
</head>
<body>
	<!-- Tampilan & input -->
	<section class="content">
		<!--  Search -->
		<div class="row">
			<div class="col-xs-12">
				<div class="box">
					<div class="box-body">
						<h3 class="box-title">Class</h3>
						<br> <br>
						<div class="row">
							<div class="box-tools">
								<div class="col-xs-5">
									<div class="input-group input-group-sm">
										<input type="text" id="search" class="form-control pull-left"
											placeholder="Search by Batch">
										<div class="input-group-btn">
											<button type="button" class="btn btn-default"
												onclick="refreshTabel()">
												<i class="fa fa-search"></i>
											</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="box-body">
						<table id="tabel-clazz"
							class="table table-bordered table-striped">
							<thead>
								<tr>
									<th>Batch</th>
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

		<div class="modal modal-default fade" id="modalDelete">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title">DELETE</h4>
					</div>
					<div class="modal-body">
						<div class="row">
							<div class="col-xs-12">
								<div class="form-group">
									<input type="text" class="form-control" name="id" id="id">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12">
								<div class="form-group">
									<input type="text" class="form-control" name="batchId" id="batchId">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12">
								<div class="form-group">
									<input type="text" class="form-control" name="biodataId" id="biodataId">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="form-group" align="center">
								<p>Are you sure to delete this data?</p>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default pull-left"
							data-dismiss="modal">NO</button>
						<button type="button" class="btn btn-danger" onclick="hapus()">YES</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
	</section>
	
	<!-- Proses -->	
	<script>
	var modeSubmit = 'insert';
	
	function refreshTabel() {
		$.ajax({
			type: 'get',
			url: 'clazz/',
			data: {
				name: $('#search').val()
			},
			success: function(d) {
				tabelClazz.clear().draw();
				$(d).each(function(index, element){
					tabelClazz.row.add([
						element.batch.technology.name + ' ' + element.batch.name,
						element.biodata.name,
						'<div class="input-group-btn">' +
						'<button type="button" class="btn btn-default btn-sm pull-left" data-toggle="dropdown">' +
						'<i class="fa fa-navicon"></i>' +
                        '</button>' +
                        '<ul class="dropdown-menu pull-left">' +
                        '<li><a href="javascript:void(0)" value="Delete" onclick="loadHapus(\'' + element.id + '\')">Delete</a></li>' +
                        '</ul>' +
                        '</div>'
                    	//'<input class="btn btn-default btn-sm" type="button" value="Edit" data-toggle="modal" data-target="#modalEdit" onclick="loadEdit(\'' + element.id + '\')"> &nbsp;' +
    	 				//'<input class="btn btn-danger btn-sm" type="button" value="Hapus" data-toggle="modal" dataId ="'+element.id+'" onclick="hapus(\'' + element.id + '\')">'
					]).draw();
				})			
			},
			error: function(d) {
				console.log('Error');
			}
		});
	}

	function loadHapus(id){
	    $.ajax({
	        type : 'get',
	        url : 'clazz/' + id,
	        success : function(d) {
	            $('#id').val(d.id);
	            $('#batchId').val(d.batchId);
	            $('#biodataId').val(d.biodata.Id)
	        },
	        error : function(d) {
	            console.log('Error');
	        }
	    });
	}   

	function hapus() {
		var id = $('#id').val();
		$('#modal-delete').modal('hide');
	      $.ajax({
	        type: 'delete',
	        url: 'clazz' + id,
	        success: function (d) {
	          refreshTable();
	         
	        },
	        error: function (d) {
	          console.log('Error');
	        }
	      });
	  }
	  
	function loadBatch() {
        $.ajax({
            type: 'GET',
            url: 'batch/findAll',
            success: function(d) {
            	console.log('Success - loadBatch');
            },
            error: function(d) {
				console.log('Error - loadBatch');
            }
        });
    }

	function loadBiodata() {
        $.ajax({
            type: 'GET',
            url: 'biodata/findAll',
            success: function(d) {
            	console.log('Success - loadBiodata');
            },
            error: function(d) {
				console.log('Error - loadBiodata');
            }
        });
    }

	var tabelClazz;
	$(document).ready(function() {
		tabelClazz = $('#tabel-clazz').DataTable({
			'searching' : false,
			'lengthChange' : false,
			'lengthMenu' : [ 10 ]
		});
		refreshTabel();
		loadBiodata();
		loadBatch();
	});
	</script>
</body>
</html>