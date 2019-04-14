<!doctype html>
<html lang="en">
<head>
<title>Biodata</title>
</head>
<body>
	<!-- Tampilan & input -->
	<section class="content">
		<!--  Form menu -->
		<div class="row">
			<div class="col-xs-12">
				<div class="box">
					<div class="box-body">
						<h3 class="box-title">Biodata</h3>
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
									<th>Name</th>
									<th>Majors</th>
									<th>GPA</th>
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
							<h4 class="modal-title">Add Biodata</h4>
						</div>
						<div class="modal-body">
							<div class="row">
								<div class="form-group">
									<input type="text" class="form-control" name="name" id="name"
										placeholder="Name">
								</div>
							</div>
							<div class="row">
								<div class="form-group">
									<input type="text" class="form-control" name="lastEducation"
										id="lastEducation" placeholder="Last Education">
								</div>
							</div>
							<div class="row">
								<div class="form-group">
									<input type="text" class="form-control" name="educationLevel"
										id="educationLevel" placeholder="Education Level">
								</div>
							</div>
							<div class="row">
								<div class="form-group">
									<input class="form-control" name="graduationYear"
										id="graduationYear" placeholder="Graduation Year">
								</div>
							</div>
							<div class="row">
								<div class="form-group">
									<input type="text" class="form-control" name="majors"
										id="majors" placeholder="Majors">
								</div>
							</div>
							<div class="row">
								<div class="form-group">
									<input type="text" class="form-control" name="gpa" id="gpa"
										placeholder="GPA">
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
							<h4 class="modal-title">Edit Biodata</h4>
						</div>
						<div class="modal-body">
							<div class="row">
								<div class="form-group">
									<div class="col-xs-4">
										<input type="text" class="form-control" name="name" id="name"
											placeholder="Name">
									</div>
								</div>
								<div class="form-group">
									<div class="col-xs-4">
										<input type="text" class="form-control" name="gender" id="gender"
											placeholder="Gender">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group">
									<div class="col-xs-4">
										<input type="text" class="form-control" name="educationLevel" id="educationLevel"
											placeholder="Education Level">
									</div>
								</div>
								<div class="form-group">
									<div class="col-xs-4">
										<input type="text" class="form-control" name="bootcampTestType" id="bootcampTestType"
											placeholder="Bootcamp Test Type">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group">
									<div class="col-xs-4">
										<input type="text" class="form-control" name="lastEducation" id="lastEducation"
											placeholder="Last Education">
									</div>
								</div>
								<div class="form-group">
									<div class="col-xs-1">
										<input type="text" class="form-control" name="iq" id="iq"
											placeholder="IQ">
									</div>
								</div>
								<div class="form-group">
									<div class="col-xs-1">
										<input type="text" class="form-control" name="du" id="du"
											placeholder="DU">
									</div>
								</div>
								<div class="form-group">
									<div class="col-xs-1">
										<input type="text" class="form-control" name="nestedLogic" id="nestedLogic"
											placeholder="NL">
									</div>
								</div>
								<div class="form-group">
									<div class="col-xs-1">
										<input type="text" class="form-control" name="joinTable" id="joinTable"
											placeholder="JT">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group">
									<div class="col-xs-4">
										<input type="text" class="form-control" name="graduationYear" id="graduationYear"
											placeholder="Graduation Year">
									</div>
								</div>
								<div class="form-group">
									<div class="col-xs-4">
										<input type="text" class="form-control" name="arithmetic" id="arithmetic"
											placeholder="Arithmetic">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group">
									<div class="col-xs-4">
										<input type="text" class="form-control" name="majors" id="majors"
											placeholder="Majors">
									</div>
								</div>
								<div class="form-group">
									<div class="col-xs-4">
										<input type="text" class="form-control" name="tro" id="tro"
											placeholder="TRO">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group">
									<div class="col-xs-4">
										<input type="text" class="form-control" name="gpa" id="gpa"
											placeholder="GPA">
									</div>
								</div>
								<div class="form-group">
									<div class="col-xs-4">
										<input type="text" class="form-control" name="interviewer" id="interviewer"
											placeholder="Interviewer">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="form-group">
									<div class="col-xs-8">
										<textarea type="text" class="form-control" rows="3" name="notes" id="notes"
											placeholder="Notes"></textarea>
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

		function loadData() {
			var search = $('#search').val();
			var url = '';
			if (search == '') {
				url = 'menu/'
			} else {
				url = 'menu/search/?name=' + search
			}
			$.ajax({
				type : 'get',
				url : url,
				success : function(d) {
					tampilkanData(d);
				},
				error : function(d) {
					console.log('Error');
				}
			});
		}

		function tampilkanData(d) {
			tabelMenu.clear().draw();
			$(d).each(function(index, element) {
				tabelMenu.row.add([
					element.name,
					element.majors,
					element.gpa,
						'<input class="btn btn-default btn-sm" type="button" value="Edit" data-target="#modal-default2" onclick="load(\''
						+ element.id
						+ '\')"> &nbsp;'
						+ '<input class="btn btn-danger btn-sm" type="button" value="Hapus" onclick="hapus(\''
						+ element.id
						+ '\')">' ])
						.draw();
			})
		}

		function simpan() {
			var method;
			var data = getFormData($('#form-menu'));
			if (modeSubmit == 'insert') {
				method = 'post';
			} else {
				method = 'put';
			}
			$.ajax({
				type : method,
				url : 'menu/',
				data : JSON.stringify(data),
				contentType : 'application/json',
				success : function(d) {
					loadData();
					modeSubmit = 'insert';
					$('#name, #lastEduaction, #graduationYear, #majors, #gpa')
				},
				error : function(d) {
					console.log('Error')
				}
			});
		}

		function hapus(id) {
			$.ajax({
				type : 'delete',
				url : 'menu/' + id,
				success : function(d) {
					loadData();
				},
				error : function(d) {
					console.log('Error')
				}
			});
		}

		function load(id) {
			$.ajax({
				type : 'get',
				url : 'menu/' + menu,
				success : function(d) {
					$('#name').val(d.name);
					$('#lastEducation').val(d.lastEduacation);
					$('#educationLevel').val(d.educationLevel);
					$('#graduationYear').val(d.graduationYear);
					$('#majors').val(d.majors);
					$('#gpa').val(d.gpa);
					modeSubmit = 'update';
				},
				error : function(d) {
					console.log('Error');
				}
			});
		}

		$(document).ready(function() {
			loadData();
			tabelMenu = $('#tabelMenu').DataTable({
				'searching' : false,
				'lengthChange' : false,
				'lengthMenu' : [ 10 ]
			});
		});
	</script>
</body>
</html>