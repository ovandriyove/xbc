<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Menu</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
	<!--CSS File-->
	<!-- Font Awesome -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/font-awesome440.min.css">
	<!-- Bootstrap 3.3.7 -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">
	<!-- Font Awesome -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/font-awesome.min.css">
	<!-- Ionicons -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/ionicons.min.css">
	<!-- DataTables -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/dataTables.bootstrap.min.css">
	<!-- bootstrap datepicker -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap-datepicker.min.css">
	<!-- Theme style -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/AdminLTE.min.css">
	<!-- AdminLTE Skins -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/skin-black.min.css">
	<!-- Google font -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/fonts.googleapis.css">

	<!-- JS File -->
	<!-- jQuery 3 -->
	<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
	<!-- Bootstrap 3.3.7 -->
	<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
	<!-- DataTables -->
	<script src="${pageContext.request.contextPath}/assets/js/jquery.dataTables.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/dataTables.bootstrap.min.js"></script>
	<!-- bootstrap datepicker -->
	<script src="${pageContext.request.contextPath}/assets/js/bootstrap-datepicker.min.js"></script>
	<!-- AdminLTE App -->
	<script src="${pageContext.request.contextPath}/assets/js/adminlte.min.js"></script>
	
	<!-- Plugin File -->
	<!-- Bootstrap WYSIHTML5 -->
	<script src="${pageContext.request.contextPath}/assets/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
	<!-- iCheck -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/plugins/iCheck/flat/blue.css">
	<!-- jvectormap -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
	<!-- bootstrap wysihtml5 - text editor -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
	
	<!-- dist file -->
	<!-- skin -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/dist/css/skins/_all-skins.min.css">
	
</head>
<body>
	<!--  Form menu -->
	<div class="row">
		<div class="col-xs-12">
			<div class="box">
				<div class="box-header">
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
											data-toggle="modal" data-target="#modal-default">
											<i class="fa fa-plus"></i>
										</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="box-body">
					<table id="tabelBarang" class="table table-bordered table-striped">
						<thead>
							<tr>
								<th>Code</th>
								<th>Title</th>
								<th>Menu Parent</th>
								<th>Action</th>
							</tr>
						</thead>
					</table>
				</div>
			</div>
		</div>
	</div>

	<!-- Search Menu -->
	<div class="modal fade" id="modal-default">
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
								<input type="text" class="form-control" name="name" id="name"
									placeholder="Title">
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
								<select class="form-control" name="menuParent" id="menuParent"></select>
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
					<button type="button" class="btn btn-primary">Save</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>