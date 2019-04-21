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
												data-toggle="modal" data-target="#modalBiodata" onclick="insert()">
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

		<!-- Form Batch -->
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
									<input type="hidden" class="form-control" name="id" id="id" placeholder="id">
								</div>
							</div>
							<div class="row">
								<div class="col-xs-6">
									<div class="form-group">
										<input type="text" class="form-control" name="name" id="name" placeholder="Name">
									</div>
								</div>
								<div class="col-xs-6">
									<div class="form-group">
										<select class="custom-select d-block w-100 form-control" name="room"
											id="room">
											<option value="" disabled selected> - Choose Room -</option>
											<option value="1">Alpha</option>
											<option value="2">Beta</option>
											<option value="3">Gamma</option>
											<option value="4">Epsilon</option>
										</select>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-6">
									<div class="form-group">
										<select class="custom-select d-block w-100 form-control" name="technology"
											id="technology">
											<option value="" disabled selected> - Choose Technology -</option>
											<option value="1">Java</option>
											<option value="2">.Net</option>
											<option value="3">Java Script</option>
											<option value="4">Android</option>
										</select>
									</div>
								</div>
								<div class="col-xs-6">
									<div class="form-group">
										<select class="custom-select d-block w-100 form-control" name="trainer"
											id="trainer">
											<option value="" disabled selected> - Choose Trainer -</option>
											<option value="1">I</option>
											<option value="2">Hate</option>
											<option value="3">My</option>
											<option value="4">Life</option>
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
											<input type="text" class="form-control" name="periodTo" id="periodTo" placeholder="Period To">
										</div>
									</div>
								</div>
								<div class="col-xs-6">
									<div class="form-group">
										<div class="input-group date">
											<div class="input-group-addon">
												<i class="fa fa-calendar"></i>
											</div>
											<input type="text" class="form-control" name="periodeForm" id="periodForm" placeholder="Period Form">
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-6">
									<div class="form-group">
										<select class="custom-select d-block w-100 form-control" name="bootcampTestType"
											id="bootcampTestType">
											<option value="" disabled selected> - Choose Bootcamp Test Type -</option>
											<option value="0">Offline</option>
											<option value="1">Online</option>
										</select>
									</div>
								</div>
								<div class="col-xs-6">
									<div class="form-group">
										<textarea class="form-control" rows="2" name="notes" id="notes" placeholder="Notes"></textarea>
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
	</section>
	
	<!-- Proses -->
	<script>
	function insert() {
		modeSubmit = 'insert';
	}
	</script>
</body>
</html>