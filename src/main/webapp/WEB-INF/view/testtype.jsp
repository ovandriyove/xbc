<!DOCTYPE html>
<html>
<head>
<title>XBC | Test Type</title>
<script>
var modeSubmit = 'insert';
var tabelTestType;


function getFormData($form) {
  var unindexed_array = $form.serializeArray();
  var indexed_array = {};
  $.map(unindexed_array, function (n, i) {
    indexed_array[n['name']] = n['value'];
  });
  return indexed_array;
}

function loadData() {
	var flag = $(this).attr("data");
	if (flag == "tambah") {
		
		$(this).attr("data"z);
	}
  var search = $('#search').val();
  var url = '';
  if (search == '') {
    url = 'test-type/'
  } else {
    url = 'test-type/search/?name=' + search
  }
  $.ajax({
    type: 'get',
    url: url,
    success: function (d) {
      tampilkanData(d);
    },
    error: function (d) {
      console.log('Error');
    }
  });
}

function tampilkanData(d) {
  tabelTestType.clear().draw();
  $(d).each(function (index, element) {
    tabelTestType.row.add([
      element.name,
      element.createdBy,
      '<div class="dropdown"> <button class="btn btn-primary btn-xs dropdown-toggle" type="button" data-toggle="dropdown"> <i class="fa fa-bars"></i> </button> <ul class="dropdown-menu"> <li><input class="btn btn-default btn-sm" type="button" value="Edit" data-toggle="modal" data-target="#modal-default" onclick="load(\'' + element.id + '\')"> &nbsp;' + 
      '<input class="btn btn-danger btn-sm" type="button" value="Delete" data-toggle="modal" data-target="#modal-delete" onclick="hapus(\'' + element.id + '\')"> </li> </ul> </div>'
    ]).draw();
  })
}

function simpan() {
  var method;
  var data = getFormData($('#formTestType'));
  if (modeSubmit == 'insert') {
    method = 'post';
  } else {
    method = 'put';
  }
  $.ajax({
    type: method,
    url: 'test-type/',
    data: JSON.stringify(data),
    contentType: 'application/json',
    success: function (d) {
      loadData();
      modeSubmit = 'insert';
      kosong();
    },
    error: function (d) {
      console.log('Error');
    }
  });
}
function kosong(){
	$('#id, #name, #notes').val('');	
}
function hapus(id) {
  $.ajax({
    type: 'delete',
    url: 'test-type/' + id,
    success: function (d) {
      loadData();
    },
    error: function (d) {
      console.log('Error');
    }
  });
}

function load(id) {
  $.ajax({
    type: 'get',
    url: 'test-type/' + id,
    success: function (d) {
      $('#id').val(d.id);
      $('#name').val(d.name);
      $('#notes').val(d.notes);
      modeSubmit = 'update';
    },
    error: function (d) {
      console.log('Error');
    }
  });
}

$(document).ready(function () {

	$('#btnCari').attr('data','hapus');
	loadData();
  tabelTestType = $('#tableTestType').DataTable({
    'searching': false,
    'lengthChange': false,
    'lengthMenu': [10]
  });
});
</script>
</head>

<body>
	<!-- Main content -->
	<section class="content">

		<div class="row">
			<div class="col-xs-12">
				<div class="box">
					<div class="box-body">
						<div class="col-xs-3">
							<div class="input-group input-group-sm">
								<input type="text" id="search" class="form-control pull-left"
									placeholder="Search">
								<div class="input-group-btn">
									<button type="button" class="btn btn-default" onclick="loadData()" data="tambah" id="btnCari">
										<i class="fa fa-search"></i>
									</button>
								</div>
							</div>
						</div>
						<div class="col-xs-8"></div>
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
			<form id="formTestType">
				<div class="modal fade" id="modal-default">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
								<h4 class="modal-title">Test Type</h4>
							</div>
							<div class="modal-body">
								<div class="form-group">
									<input type="hidden" class="form-control"
										name="id" id="id">
								</div>
								<div class="form-group">
									<label>Name</label> <input type="text" class="form-control"
										name="name" id="name" placeholder="Name ...">
								</div>
								<div class="form-group">
									<label>Notes</label>
									<textarea class="form-control" rows="3" name="notes" id="notes"
										placeholder="Enter ..."></textarea>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default pull-left"
									data-dismiss="modal" onclick="kosong()">Cancel</button>
								<button type="button" class="btn btn-primary" onclick="simpan()">Save</button>
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
						<table id="tableTestType"
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
<!--  	<div class="modal fade" id="modal-default2">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title">Test Type</h4>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label>Name</label> <input type="text" class="form-control"
								name="name" id="name" value="Teori Java">
						</div>
						<div class="form-group">
							<label>Notes</label>
							<textarea class="form-control" rows="3" name="notes" id="notes"
								value="Ucok"></textarea>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default pull-left"
							data-dismiss="modal">Cancel</button>
						<button type="button" class="btn btn-primary">Save</button>
					</div>
				</div>
				<!-- /.modal-content 
			</div>
			<!-- /.modal-dialog 
		</div>-->
		<div class="modal modal-warning fade" id="modal-delete">
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
							data-dismiss="modal">NO</button>
						<button type="button" class="btn btn-danger">YES</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>
	</section>


</body>
</html>