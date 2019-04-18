<!doctype html>
<html lang="en">
<head>
	<title>Menu</title>
</head>
<body>
	<!-- Search & Input -->
	<section class="content">
		<!-- Search -->
		<div class="row">
			<div class="col-xs-12">
				<div class="box">
					<div class="box-body">
						<h3 class="box-title">Menu</h3>
						<br> <br>
						<div class="row">
							<div class="box-tools">
								<div class="col-xs-5">
									<div class="input-group input-group-sm">
										<input type="text" id="search" class="form-control pull-left"
											placeholder="Search by Title">
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
												data-toggle="modal" data-target="#modalMenu" onclick='insert()'>
												<i class="fa fa-plus"></i>
											</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="box-body">
						<table id="tabel-menu" class="table table-bordered table-striped">
							<thead>
								<tr>
									<th>Code</th>
									<th>Title</th>
									<th>Menu Parent</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody></tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

		<!-- Form Menu -->
		<form id="form-menu">
			<div class="modal fade" id="modalMenu">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title">Add Menu</h4>
						</div>
						<div class="modal-body">	
							<div class="row">
								<div class="col-xs-6">
									<div class="form-group">
										<input type="text" class="form-control" name="title:string"
											id="title" placeholder="Title">
									</div>
								</div>
								<div class="col-xs-6">
									<div class="form-group">
										<input type="text" class="form-control" name="imageUrl:string"
											id="imageUrl" placeholder="Image Url">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-6">
									<div class="form-group">
										<textarea class="form-control" rows="6" name="description:string"
											id="description" placeholder="Description"></textarea>
									</div>
								</div>
								<div class="col-xs-6">
									<div class="form-group">
										<input type="text" class="form-control" name="menuOrder:number"
											id="menuOrder" placeholder="Menu Order">
									</div>
									<div class="form-group">
										<select class="custom-select d-block w-100 form-control" id="menuParent"
												name="menuParent">
										</select>
									</div>
									<div class="form-group">
										<input type="text" class="form-control" name="menuUrl:string"
											id="menuUrl" placeholder="Menu Url">
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

		<!-- Form Edit Menu -->
		<form id="form-editMenu">
			<div class="modal fade" id="modalEdit">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button  class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title">Edit Menu</h4>
						</div>
						<div class="modal-body">
							<div class="col-xs-12">
								<div class="form-group">
									<input type="hidden" class="form-control" name="id:number"
										id="idEdit">
								</div>
							</div>
							<div class="row">
								<div class="col-xs-6">
									<div class="form-group">
										<input type="text" class="form-control" name="code:string"
											id="codeEdit" readonly>
									</div>
								</div>
								<div class="form-group">
									<div class="col-xs-6">
										<input type="text" class="form-control" name="imageUrl:string"
											id="imageUrlEdit">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-6">
									<div class="form-group">
										<input type="text" class="form-control" name="title:string"
											id="titleEdit">
									</div>
								</div>
								<div class="col-xs-6">
									<div class="form-group">
										<input type="text" class="form-control" name="menuOrder:number"
											id="menuOrderEdit">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-6">
									<div class="form-group">
										<textarea class="form-control" rows="4" name="description:string"
											id="descriptionEdit"></textarea>
									</div>
								</div>
								<div class="col-xs-6">
									<div class="form-group">
										<select class="custom-select d-block w-100 form-control" id="menuParentEdit"
												name="menuParent">
										</select>
									</div>
									<div class="form-group">
										<input class="form-control" name="menuUrl:string" id="menuUrlEdit">
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

		<!-- Form Delete -->
		<div class="modal fade" id="modalDelete">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Delete Menu</h4>
					</div>
					<div class="modal-body">
						<!--<form id="form-delete">
							<div class="row">
								<div class="col-xs-6">
									<div class="form-group">
										<input type="hidden" class="form-control" name="id:number"
											id="idHapus">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-6">
									<div class="form-group">
										<input type="text" class="form-control"
											name="delete:boolean" id="deleteHapus">
									</div>
								</div>
							</div> 
						</form>-->
						<div class="form-group" align="center">
							<p>Are you sure to delete this data?</p>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default pull-left"
							data-dismiss="modal">No</button>
						<button type="button" class="btn btn-danger" onclick="hapus(dataId)">Yes</button>
					</div>
				</div>
			</div>
		</div>

	</section>
	<!-- Proses -->
	<script>
	var modeSubmit = 'insert';
	
	function refreshTabel() {
		$.ajax({
			type: 'get',
			url: 'menu/',
			data: {
				title: $('#search').val()
			},
			success: function(d) {
				var s = '<option>Silahkan Pilih</option>' +
					'<option value="0">Master</option>';
				tabelMenu.clear().draw();
				$(d).each(function(index, element){
					tabelMenu.row.add([
						element.code,
						element.title,
						element.menuParent,
						'<input class="btn btn-default btn-sm" type="button" value="Edit" data-toggle="modal" data-target="#modalEdit" onclick="loadEdit(\'' + element.id + '\')"> &nbsp;' +
		 				'<input class="btn btn-danger btn-sm" type="button" value="Hapus" data-toggle="modal" dataId ="'+element.id+'" onclick="hapus(\'' + element.id + '\')">'
					]).draw();

					s += '<option value="' + element.id + '" data-title="' + element.title + '">'
					+ element.title + '</option>';
					
				})
				$('#menuParent').html(s);
			},
			error: function(d) {
				console.log('Error');
			}
		});
	}

	function simpan() {	
		var method;

		if(modeSubmit == 'insert') {
			var data = $('#form-menu').serializeJSON();	
			$('#modalMenu').modal('hide');
			method = 'post';
		} else {
			var data  = $('#form-editMenu').serializeJSON();
			$('#modalEdit').modal('hide');
			method ='put';
		}
		$.ajax({
			type: method,
			url: 'menu/',
			data: JSON.stringify(data),
			contentType: 'application/json',
			success:  function(d) {
				refreshTabel();
				modeSubmit = 'insert';
				//$('#code, #title, #imageUrl, #description, #menuParent, #menuOrder, #menuUrl').val('');
				$('#form-menu').trigger("reset");
				$('#form-menu input[type=hidden]').val('');	
				$('#form-editMenu').trigger("reset");
				$('#form-editMenu input[type=hidden]').val('');	
			},
			error: function(d) {
				console.log('Error')
			}
		});
	}

    function loadEdit(id) {
		$.ajax({
			type: 'get',
			url: 'menu/' + id,
			success: function(d) {
				refreshTabel();
				var s = '';
				$(d).each(function(index, element){
					s += '<option value="' + element.menuParent + '" data-title="' + element.title + '">'
					+ element.menuParent + '</option>';
					s += '<option value="' + element.id + '" data-title="' + element.title + '">'
					+ element.title + '</option>';
				})
				$('#menuParentEdit').html(s);
				
				$('#idEdit').val(d.id);
				$('#codeEdit').val(d.code);
				$('#titleEdit').val(d.title);
				$('#descriptionEdit').val(d.description);
				$('#imageUrlEdit').val(d.imageUrl);
				$('#menuOrderEdit').val(d.menuOrder);
				$('#menuParentEdit').val(d.menuParent);
				$('#menuUrlEdit').val(d.menuUrl);
				modeSubmit ='update';
			},
            error: function(d) {
				console.log('Error');
            }
		});
    }

//	function loadHapus(id) {
//		$.ajax({
//			type : 'get',
//			url : 'menu/' + id,
//			success : function(d) {	
//				refreshTabel();
//				$('#idHapus').val(d.id);
//				$('#deleteHapus').val(true);
//			},
//			error : function(d) {
//				console.log('Error');
//			}
//		});
//	}

//	function hapus2nd(id) {
//		$('#modalDelete').modal('hide');
//		var data  = $('#form-delete').serializeJSON();
//		$.ajax({
//			type: 'delete',
//			url: 'menu/' + id,
//			data: JSON.stringify(data),
//			contentType: 'application/json',
//			success: function(d) {
//				refreshTabel();
//			},
//			error: function(d) {
//				console.log('Error')
//			}
//		});
//	}

	function insert() {
		modeSubmit = 'insert';
	}

    function hapus(id) {
        if (confirm("Are you sure to delete this data?")) {
          $.ajax({
            type: 'delete',
            url: 'menu/' + id,
            success: function (d) {
              refreshTabel();
            },
            error: function (d) {
              console.log('Error');
            }
          });
        }
     }
	
    var tabelMenu;
    $(document).ready(function () {
      tabelMenu = $('#tabel-menu').DataTable({
        'searching': false,
        'lengthChange': false,
        'lengthMenu': [10]
      });
      refreshTabel();
    });
</script>
</body>
</html>