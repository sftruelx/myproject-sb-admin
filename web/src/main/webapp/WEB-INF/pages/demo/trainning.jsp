<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="page-wrapper">
    <br>
    <!-- /.row -->
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3>已挂号病人列表</h3>
                </div>
                <div class="panel-body">
                    <div class="dataTable_wrapper">
                        <div id="toolbar">
                            <div class="form-inline" role="form">
                                <div class="form-group">
                                    <select id="queryStatus" name="queryStatus" class="form-control">
                                        <option value="2">已缴费</option>
                                        <option value="3">已结束</option>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <input name="name" class="form-control" type="text" placeholder="姓名">
                                    <input name="department" hidden type="text" value="幼儿保健科">
                                </div>
                                <button id="ok" type="submit" class="btn btn-info">查询</button>
                            </div>
                        </div>
                        <table id="table"
                               data-classes="table table-no-bordered"
                               data-toggle="table"
                               data-height="660"
                               data-toolbar="#toolbar"
                               data-show-toggle="true"
                               data-query-params="queryParams"
                               data-show-columns="true"
                               data-show-refresh="true"
                               data-url="/demo/getPatient"
                               data-height="400"
                               data-side-pagination="server"
                               data-pagination="true"
                               data-page-list="[5, 10, 20]"
                               data-sort-name="createDateStr"
                               data-sort-order="desc">
                            <thead>
                            <tr>
                                <th data-field="no">门诊号码</th>
                                <th data-field="name">姓名</th>
                                <th data-field="age">年龄</th>
                                <th data-field="birthdayStr">出生日期</th>
                                <th data-field="department">挂号科室</th>
                                <%--                         <th data-field="status">状态</th>--%>
                                <th data-field="createDateStr" data-sortable="true">挂号日期</th>
                                <th data-field="other" data-formatter="otherFormatter">功能</th>
                            </tr>
                            </thead>
                        </table>
                        <%-- </div>--%>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div style="margin: 150px auto;height: 800px" id="user-dialog" class="modal modal_align fade bs-example-modal-lg"
     tabindex="-1"
     role="dialog"
     aria-labelledby="myLargeModalLabel" style="display:none;">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="modalTitle"></h4>
            </div>
            <div class="modal-body">
                <form id="addForm" role="form" class="form-horizontal">
                    <input type="hidden" id="submit-type" value="0"/>
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">姓名</label>
                                <div class="col-sm-4">
                                    <input type="text" hidden name="patient_id" id="patient_id"/>
                                    <input type="text" class="form-control input-sm" name="name" id="name"/>
                                </div>


                                <label class="col-sm-2 control-label">性别</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control input-sm" name="gender" id="gender"/>
                                </div>
                                <%--

                                                                --%>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">门诊号码</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control input-sm" name="no" id="no"/>
                                </div>
                                <label class="col-sm-2 control-label">手机号码</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control input-sm" name="mobile" id="mobile"/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">出生日期</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control input-sm" name="birthday" id="birthday"/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">身高（CM）出生</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control input-sm" name="heightBefore"
                                           id="heightBefore"/>
                                </div>
                                <label class="col-sm-2 control-label">现在</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control input-sm" name="heightNow" id="heightNow"/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">体重（KG） 出生</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control input-sm" name="weightBefore"
                                           id="weightBefore"/>
                                </div>
                                <label class="col-sm-2 control-label">现在</label>
                                <div class="col-sm-4">
                                    <input type="text" class="form-control input-sm" name="weightNow" id="weightNow"/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">训练内容</label>
                                <div class="col-sm-10">
                                    <textarea class="form-control" rows="3" name="content" id="content"></textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">训练结果</label>
                                <div class="col-sm-10">
                                    <textarea class="form-control" rows="3" name="result" id="result"></textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-12">
                            <div class="form-group">
                                <label class="col-sm-2 control-label">建议</label>
                                <div class="col-sm-10">
                                    <textarea class="form-control" rows="3" name="advise" id="advise"></textarea>
                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="submit" class="btn btn-primary" onclick="onSubmitModal();">提交
                </button>
            </div>
        </div>
    </div>
</div>
<script>
    var modalDialog;
    var $table = $('#table'),
            $ok = $('#ok');

    $(function () {
        modalDialog = $("#user-dialog");

        $ok.click(function () {
            $table.bootstrapTable('refresh');

        });
    })

    $('#dateClose').click(function () {
        $('#birthday').val('');
    });

    function sendLedControl(dev_id, cur_status) {
        $.ajax({
            url: '/demo/getPatientByID/' + dev_id, // /api/leds/1
            async: true,
            dataType: 'json',
            type: 'PUT',
            data: JSON.stringify({status: cur_status}),

            success: function (data, textStatus) {
                console.log("success" + data.name + data.age);
                $('#modalTitle').html("智护训练");
                $('#patient_id').val(data.id);
                $('#no').val(data.no);
                $('#name').val(data.name);
                $('#gender').val('男');
                $('#birthday').val(data.birthdayStr);
                $('#age').val(data.age);
                $('#department').val(data.department);

                modalDialog.find("input[type='hidden']").prop("value", 0);
                modalDialog.modal('show');

            },

            error: function (jqXHR, textStatus, errorThrown) {
                console.log("error");
            },

        });
    }
    function onAddUserClicked(id) {
        sendLedControl(id);
        $('#modalTitle').html("新增挂号病人");
        $('#no').val('');
        $('#name').val('');
        $('#gender').val('男');
        $('#birthday').val('');
        $('#age').val('');
        $('#department').val('儿童健康科');

        modalDialog.find("input[type='hidden']").prop("value", 0);
        modalDialog.modal('show');
    }

    function queryParams(params) {
        $('#toolbar').find('input[name]').each(function () {
            params[$(this).attr('name')] = $(this).val();
        });

        params["status"] = $('#queryStatus').val();
        return params;
    }

    function responseHandler(res) {
        return res.rows;
    }

    function otherFormatter(value, row) {
        return '<button type="button"  onclick="onAddUserClicked(' + row.id + ')" class="btn btn-success btn-sm"  >训练</button>'
    }


    function onSubmitModal() {
        $.ajax({
            url: '<%=request.getContextPath()%>/demo/addTrainning',
            type: 'post',
            dataType: 'json',
            data: $("#addForm").serialize(),
            success: function (result) {
                modalDialog.modal('hide');
            }
        });
    }


</script>
</body>
</html>
