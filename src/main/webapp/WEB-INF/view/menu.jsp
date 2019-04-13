<!doctype html>
<html lang="en">
<head>

<title>Menu</title>
</head>
<body>
	<!-- Tampilan & input -->
	<section class="content">
		<!--  Form menu -->
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
											placeholder="Search">
										<div class="input-group-btn">
											<button type="button" class="btn btn-default">
												<i class="fa fa-search"></i>
											</button>
										</div>
									</div>
								</div>
								<div class="col-xs-6"></div>
								<div class="col-xs-1">
									<div class="input-group input-group-sm">
										<div class="input-group-btn pull-right">
											<button type="button" class="btn btn-default"
												data-toggle="modal" data-target="#modal-default1">
												<i class="fa fa-plus"></i>
											</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="box-body">
						<table id="tabelMenu" class="table table-bordered table-striped">
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

		<!-- Search Menu -->
		<form id="form-menu">
			<div class="modal fade" id="modal-default1">
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
										<input type="text" class="form-control" name="code"
											id="code" placeholder="Code">
									</div>
								</div>
							</div>	
							<div class="row">
								<div class="col-xs-6">
									<div class="form-group">
										<input type="text" class="form-control" name="title"
											id="title" placeholder="Title">
									</div>
								</div>
								<div class="col-xs-6">
									<div class="form-group">
										<input type="text" class="form-control" name="imageUrl"
											id="imageUrl" placeholder="Image Url">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-6">
									<div class="form-group">
										<textarea class="form-control" rows="6" name="description"
											id="description" placeholder="Description"></textarea>
									</div>
								</div>
								<div class="col-xs-6">
									<div class="form-group">
										<input type="text" class="form-control" name="menuOrder"
											id="menuOrder" placeholder="Menu Order">
									</div>
									<div class="form-group">
										<input type="text" class="form-control" name="menuParent"
											id="menuParent" placeholder="Menu Parent">
										<!-- <select class="form-control" name="menuParent" id="menuParent"></select> -->
									</div>
									<div class="form-group">
										<input type="text" class="form-control" name="menuUrl"
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

		<form id="formedit-menu">
			<div class="modal fade" id="modal-default2">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title">Edit Menu</h4>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<input type="hidden" class="form-control" name="id" id="id">
							</div>
							<div class="row">
								<div class="col-xs-6">
									<div class="form-group">
										<input type="text" class="form-control" name="code2"
											id="code2">
									</div>
								</div>
								<div class="form-group">
									<div class="col-xs-6">
										<input type="text" class="form-control" name="imageUrl2"
											id="imageUrl2">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-6">
									<div class="form-group">
										<input type="text" class="form-control" name="title2"
											id="title2">
									</div>
								</div>
								<div class="col-xs-6">
									<div class="form-group">
										<input type="text" class="form-control" name="menuOrder2"
											id="menuOrder2">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-6">
									<div class="form-group">
										<textarea class="form-control" rows="4" name="description2"
											id="description2"></textarea>
									</div>
								</div>
								<div class="col-xs-6">
									<div class="form-group">
										<input class="form-control" name="menuParent2"
											id="menuParent2">
									</div>
									<div class="form-group">
										<input class="form-control" name="menuUrl2" id="menuUrl2">
									</div>
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default pull-left"
								data-dismiss="modal">Cancel</button>
							<button type="button" class="btn btn-primary">Save</button>
						</div>
					</div>
				</div>
			</div>
		</form>
		<!-- Pop up Delete -->
		<div class="modal modal-warning fade" id="modal-delete">
			<div class="modal-dialog">
				<div class="modal-content">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">Delete</h4>
				</div>
				<div class="modal-body">
					<div class="form-group" align="center">
						<p>Are you sure to delete this data?</p>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default pull-left"
						data-dismiss="modal">No</button>
					<button type="button" class="btn btn-danger">Yes</button>
				</div>
			</div>
		</div>

	</section>
	<!-- Proses -->
	<script>
	var modeSubmit = 'insert';
	var tabelMenu;

	function getFormData($form) {
		var unindexed_array = $form.serializeArray();
		var indexed_array = {};
		$.map(unindexed_array, function(n, i) {
			indexed_array[n['name']] = n['value'];
			});
		return indexed_array;
	}

	function loadData () {
		var search = $('#search').val();
		var url = '';
		if (search == '') {
			url = 'menu/'
		} else {
			url = 'menu/search/?title=' + search	
		}
		$.ajax({
			type: 'get',
			url: url,
			success: function(d) {
				tampilkanData(d);
			},
			error: function(d) {
				console.log('Error');
			}
		});
	}

	function tampilkanData(d) {
		tabelMenu.clear().draw();
		$(d).each(function(index, element) {
			tabelMenu.row.add([
				element.code,
				element.title,
				element.menuParent,
				'<input class="btn btn-default btn-sm" type="button" value="Edit" data-target="#modal-default2" onclick="load(\'' + element.id + '\')"> &nbsp;' +
 				'<input class="btn btn-danger btn-sm" type="button" value="Hapus" onclick="hapus(\'' + element.id + '\')">'
			]).draw();
		})
	}

	function simpan() {
		var method;
		var data = getFormData($('#form-menu'));
		if(modeSubmit == 'insert') {
			method = 'post';
		} else {
			method ='put';
		}
		$.ajax({
			type: method,
			url: 'menu/',
			data: JSON.stringify(data),
			contentType: 'application/json',
			success:  function(d) {
				loadData();
				modeSubmit = 'insert';
				$('#code, #title, #imageUrl, #description, #menuParent, #menuOrder, #menuUrl')
			},
			error: function(d) {
				console.log('Error')
			}
		});
	}

	function hapus(id) {
		$.ajax({
			type: 'delete',
			url: 'menu/' + id,
			success: function(d) {
				loadData();
			},
			error: function(d) {
				console.log('Error')
			}
		});
	}

    function load(id) {
		$.ajax({
			type: 'get',
			url: 'menu/' + menu,
			success: function(d) {
				$('#id').val(d.id);
				$('#Code').val(d.code);
				$('#title').val(d.title);
				$('#description').val(d.description);
				$('#imageUrl').val(d.imageUrl);
				$('#menuOrder').val(d.menuOrder);
				$('#menuParent').val(d.menuParent);
				$('#menuUrl').val(d.menuUrl);
				modeSubmit = 'update';
			},
            error: function(d) {
				console.log('Error');
            }
		});
    }

    $(document).ready(function() {
		loadData();
		tabelMenu = $('#tabelMenu').DataTable({
			'searching' : false,
			'lengthChange' : false,
			'lengthMenu' : [10]
		});
    });
</script>
</body>
</html>