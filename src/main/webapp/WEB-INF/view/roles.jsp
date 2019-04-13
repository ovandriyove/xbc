<!DOCTYPE html>
<html>
<head>
<title>XBC | Data Role</title>
<script>
	
</script>
</head>

<body>
	<!-- Main content -->
	<section class="content">

		<div class="row">
			<div class="col-xs-12">
				<div class="box">
					<div class="box-body">
						<div class="col-xs-5">
							<div class="input-group input-group-sm">
								<input type="text" id="search" onkeyup="myFunction()"
									class="form-control pull-left" placeholder="Search">
								<div class="input-group-btn">
									<button type="b" class="btn btn-default">
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
										data-toggle="modal" data-target="#modal-default">
										<i class="fa fa-plus"></i>
									</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<form id="form-roles">
				<div class="modal fade" id="modal-default">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<h4 class="modal-title">Add Role</h4>
							</div>
							<div class="modal-body">
								<div class="form-group"></div>
								<div class="form-group">
									<input type="text" class="form-control" name="code" id="code"
										placeholder="Code ...">
								</div>
								<div class="form-group">
									<input type="text" class="form-control" name="name" id="name"
										placeholder="Name ...">
								</div>
								<div class="form-group">
									<textarea class="form-control" rows="3" name="description"
										id="description" placeholder="Description ..."></textarea>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default pull-left"
									onclick="kosong()" data-dismiss="modal">Cancel</button>
								<button type="button" onclick="simpan()" class="btn btn-primary">Save</button>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>
			</form>
		</div>

		<div class="row">
			<div class="col-xs-12">
				<div class="box">

					<div class="box-body">
						<table id="testTypeTable"
							class="table table-bordered table-striped">
							<thead>
								<tr>
									<th>Code</th>
									<th>Name</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody id="data_role">

							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>


		<form id="form-roles2">
			<div class="modal fade" id="modal-default2">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h4 class="modal-title">Edit Role</h4>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<input type="hidden" readonly class="form-control" name="id"
									id="aidi"> <input type="hidden" class="form-control"
									name="delete" id="delete">
							</div>
							<div class="form-group">
								<input type="text" readonly class="form-control" name="code"
									id="code2" placeholder="Code ...">
							</div>
							<div class="form-group">
								<input type="text" class="form-control" name="name" id="name2"
									placeholder="Name ...">
							</div>
							<div class="form-group">
								<textarea class="form-control" rows="3" name="description"
									id="description2" placeholder="Description ..."></textarea>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default pull-left"
								data-dismiss="modal">Cancel</button>
							<button type="button" onclick="edit()" class="btn btn-primary">Save</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
		</form>
		<div class="modal modal-danger fade" id="modal-delete">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
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
							data-dismiss="modal" action="kosong()">NO</button>
						<button type="button" class="btn btn-primary" onclick="hapus()">YES</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
	</section>

	<script>


		function getFormData($form) {
			var unindexed_array = $form.serializeArray();
			var indexed_array = {};
			$.map(unindexed_array, function(n, i) {
				indexed_array[n['name']] = n['value'];
			});
			return indexed_array;
		}

		
		function tampilkanData(d) {
			var s = '';
			
			for(var i =0 ; i< d.length; i++){
				if (d[i].delete == false){
					
						s += '<tr>';
						s += '<td>' + d[i].code + '</td>';
						s += '<td>' + d[i].name + '</td>';
						s += '<td>'
								+ '<input class="btn btn-default btn-sm" type="button" value="Edit" data-toggle="modal" data-target="#modal-default2" onclick="load(\''
								+ d[i].id
								+ '\')"> &nbsp;'
								+ '<input class="btn btn-danger btn-sm" type="button" value="Delete" data-toggle="modal" data-target="#modal-delete"onclick="loadHapus(\''
								+ d[i].id
								+ '\')"> &nbsp;'
						s += '</tr>';
					
					}
				}			
						
			$('#data_role').html(s);

		}


	function hapus(id) {
		var data = getFormData($('#form-roles2'));
		$.ajax({
			type : 'put',
			url : 'role/',
			data : JSON.stringify(data),
			contentType : 'application/json',
			success : function(d) {
				loadHapus();
				location.reload();
			},
			error : function(d) {
				console.log('Error');
			}
		});
		}

		
		function loadData() {
			$.ajax({
				type : 'get',
				url : 'role/',
				success : function(d) {
					tampilkanData(d);
				},
				error : function(d) {
					console.log('Error');
				}
			});
		}

		function simpan() {
	
			var data = getFormData($('#form-roles'));
			$.ajax({
				type : 'post',
				url : 'role/',
				data : JSON.stringify(data),
				contentType : 'application/json',
				success : function(d) {
					loadData();
					kosong();
					location.reload();
				},
				error : function(d) {
					console.log('Error');
				}
			});
		}

		function kosong(){
			$('#aidi, #delete,#code, #name, #description').val('');
			}
		
		function edit() {
			
			var data = getFormData($('#form-roles2'));
			$.ajax({
				type : 'put',
				url : 'role/',
				data : JSON.stringify(data),
				contentType : 'application/json',
				success : function(d) {
					loadData();
					location.reload();
				},
				error : function(d) {
					console.log('Error');
				}
			});
		}

		function loadHapus(id) {
			$.ajax({
				type : 'get',
				url : 'role/'+id,
				success : function(d) {
					$('#aidi').val(d.id);
					$('#delete').val(true);
				},
				error : function(d) {
					console.log('Error');
				}
			});
		}
		

		function load(id) {
			$.ajax({
				type : 'get',
				url : 'role/'+id,
				success : function(d) {
					$('#aidi').val(d.id);
					$('#code2').val(d.code);
					$('#name2').val(d.name);
				},
				error : function(d) {
					console.log('Error');
				}
			});
		}

		$(document).ready(function() {
			loadData();
		});


		<!-- FITUR SEARCH  -->

		function myFunction() {
			  var input, filter, table, tr, td, i, txtValue;
			  input = document.getElementById("search");
			  filter = input.value.toUpperCase();
			  table = document.getElementById("testTypeTable");
			  tr = table.getElementsByTagName("tr");
			  for (i = 0; i < tr.length; i++) {
			    td = tr[i].getElementsByTagName("td")[0];
			    if (td) {
			      txtValue = td.textContent || td.innerText;
			      if (txtValue.toUpperCase().indexOf(filter) > -1) {
			        tr[i].style.display = "";
			      } else {
			        tr[i].style.display = "none";
			      }
			    }       
			  }
			}
	</script>
</body>
</html>