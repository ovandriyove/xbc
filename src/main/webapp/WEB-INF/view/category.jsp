<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Xsis Bootcamp Core</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

  <jsp:include page="_includes.jsp" />

</head>

<body class="hold-transition skin-blue sidebar-mini">
  <div class="wrapper">

    <jsp:include page="_header.jsp" />

    <jsp:include page="_sidebar.jsp">
      <jsp:param name="page" value="category" />
    </jsp:include>


    <div class="content-wrapper">

      <section class="content-header">
        <h1>
          Data Barang
          <small>Halaman data barang</small>
        </h1>
      </section>

      <!-- Main content -->
      <section class="content">



        <div class="row">
          <div class="col-xs-12">
            <div class="box">
              <div class="box-body">

                <div class="row">
                  <div class="col-xs-4">
                    <div class="input-group input-group-sm">
                      <input type="text" id="search" class="form-control" placeholder="Search by code / name">
                      <div class="input-group-btn">
                        <button type="button" class="btn btn-default" onclick="refreshTabel()">
                          <i class="fa fa-search"></i>
                        </button>
                      </div>
                    </div>
                  </div>
                  <div class="col-xs-8">
                    <button type="button" class="btn btn-primary btn-sm pull-right" onclick="loadForm()">
                      Add &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <i class="fa fa-plus"></i>
                    </button>
                  </div>
                </div>

                <table id="tabel-category" class="table table-bordered table-striped">
                  <thead>
                    <tr>
                      <th>Code</th>
                      <th>Name</th>
                      <th>#</th>
                    </tr>
                  </thead>
                  <tbody>
                  </tbody>
                </table>

              </div>
            </div>
          </div>
        </div>




        <div class="modal fade" role="dialog" id="modal-category">
          <div class="modal-dialog" role="document">
            <div class="modal-content">
              <div class="modal-header">
                <h4 class="modal-title">Modal title</h4>
              </div>
              <div class="modal-body">
                <form id="form-category">

                  <input type="hidden" class="form-control" placeholder="ID" name="id">
   
                  <div class="row" id="input-code">
                    <div class="col-md-12">
                      <div class="form-group">
                        <label>Code</label>
                        <input type="text" class="form-control" placeholder="Code" name="code" readonly>
                      </div>
                    </div>
                  </div>

                  <div class="row">
                    <div class="col-md-12">
                      <div class="form-group">
                        <label>Name</label>
                        <input type="text" class="form-control" placeholder="Name" name="name" required>
                      </div>
                    </div>
                  </div>

                  <div class="row">
                    <div class="col-md-12">
                      <div class="form-group">
                        <label>Description</label>
                        <textarea class="form-control" rows="3" placeholder="Description" name="description"></textarea>
                      </div>
                    </div>
                  </div>

                </form>
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Cancel</button>
                <button type="button" class="btn btn-primary btn-sm" onclick="submitForm()">Save</button>
              </div>
            </div>
          </div>
        </div>



      </section>
      <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

  </div>
  <!-- ./wrapper -->

  <!-- REQUIRED JS SCRIPTS -->


  <jsp:include page="_message.jsp" />

  
  <script>

    function refreshTabel() {
      $.ajax({
        type: 'get',
        url: 'category/',
        data: {
          name : $('#search').val()
        },
        success: function(d) {
          tabelCategory.clear().draw();
          $(d).each(function (index, element) {
            tabelCategory.row.add([
              element.code,
              element.name,
              '<div class="input-group-btn">' +
                '<button type="button" class="btn btn-default btn-sm pull-right" data-toggle="dropdown">' +
                  '<i class="fa fa-navicon"></i>' +
                '</button>' +
                '<ul class="dropdown-menu pull-right">' +
                  '<li><a href="javascript:void(0)" onclick="loadForm(' + element.id + ')">Edit</a></li>' +
                  '<li><a href="javascript:void(0)" onclick="hapus(' + element.id + ')">Delete</a></li>' +
                '</ul>' +
              '</div>'
            ]).draw();
          })
        },
        error: function(d) {
          messageInfo(d);
        }
      });
    }

    function loadForm(id) {
      if (id == null) {
        $('#input-code').hide();
        $('#form-category').trigger("reset");
      } else {
        $('#input-code').show();
        $.ajax({
          type: 'get',
          url: 'category/' + id,
          success: function(d) {
            $('input[name=id]').val(d.id);
            $('input[name=code]').val(d.code);
            $('input[name=name]').val(d.name);
            $('textarea[name=description]').val(d.description);
          },
          error: function(d) {
            messageInfo(d);
          }
        });
      }
      $('#modal-category').modal('show');
    } 	

    function submitForm() {
      var unindexed_data = $('#form-category').serializeArray();
      var data = {};
      $.map(unindexed_data, function (n, i) {
        data[n['name']] = n['value'];
      });

      var method;
      if (data.id == '') {
        method = 'POST';
      } else {
        method = 'PUT';
      }

      $.ajax({
        type: method,
        url: 'category/',
        data: JSON.stringify(data),
        contentType: 'application/json',
        success: function (d) {
          refreshTabel();
          $('#modal-category').modal('hide');
        },
        error: function (d) {
          console.log('Error');
        }
      });
    }

    function hapus(id) {
        $.ajax({
          type: 'DELETE',
          url: 'category/' + id,
          success: function (d) {
            refreshTabel();
          },
          error: function (d) {
            console.log('Error');
          }
        });
    }

    var tabelCategory;
    $(document).ready(function () {
      tabelCategory = $('#tabel-category').DataTable({
        'searching': false,
        'lengthChange': false,
        'lengthMenu': [10]
      });
      refreshTabel();
    });

  </script>

</body>
</html>