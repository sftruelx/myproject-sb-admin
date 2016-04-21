<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">已挂号病人列表</h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
    <div class="row">
        <div class="col-lg-12">
            <div class="panel-heading">
                <div id="toolbar">
                    <div class="form-inline" role="form">
                        <div class="form-group">
                            <div class="btn-group" role="group" aria-label="...">
                                <button onclick="onAddUserClicked()" type="button" class="btn btn-success">新增</button>
                                <button type="button" class="btn btn-warning">删除</button>
                            </div>
                        </div>
                        <div class="form-group">
                            <select id="queryStatus" name="queryStatus" class="form-control">
                                <option value="1">未缴费</option>
                                <option value="2">已缴费</option>
                                <option value="3">sd3</option>
                                <option value="4">s4</option>
                                <option value="5">d5</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <input name="name" class="form-control" type="text" placeholder="姓名">
                        </div>
                        <button id="ok" type="submit" class="btn btn-info">查询</button>
                    </div>
                </div>
                <table id="table"
                       data-toggle="table"
                       data-height="600"
                       data-toolbar="#toolbar"
                       data-show-toggle="true"
                       data-query-params="queryParams"
                       data-show-columns="true"
                       data-show-refresh="true"
                       data-url="/demo/getPatient"
                       data-height="400"
                       data-side-pagination="server"
                       data-pagination="true"
                       data-page-list="[10]"
                       data-sort-name="createDateStr"
                       data-sort-order="desc">
                    <thead>
                    <tr>
                        <th data-field="id">门诊号码</th>
                        <th data-field="name">姓名</th>
                        <th data-field="age">年龄</th>
                        <th data-field="birthdayStr">出生日期</th>
                        <th data-field="department">挂号科室</th>
                        <th data-field="status">状态</th>
                        <th data-field="createDateStr" data-sortable="true">挂号日期</th>
                        <th data-field="other" data-formatter="otherFormatter">功能</th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>
</div>
<div style="margin: 150px auto;" id="user-dialog" class="modal modal_align fade bs-example-modal-lg" tabindex="-1"
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

                    <div class="form-group">
                        <label for="no" class="col-sm-2 control-label">门诊号码</label>

                        <div class="col-sm-4">
                            <input type="text" class="form-control input-sm" name="no" id="no"/>
                        </div>

                        <label for="name" class="col-sm-2 control-label">姓名</label>

                        <div class="col-sm-4">
                            <input name="name" type="text" class="form-control input-sm" id="name"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="col-sm-2 control-label">性别</label>

                        <div class="col-sm-4">
                            <select name="gender" class="form-control" id="gender">
                                <option value="1">男</option>
                                <option value="2">女</option>
                            </select>
                        </div>

                        <label for="birthday" class="col-sm-2 control-label">出生年月</label>

                        <%--<div class="input-group birthday form_datetime col-md-4">--%>
                        <%--<input id="birthday" class="form-control input-sm" size="16" type="text" value="" readonly>--%>
                        <%--<span class="input-group-addon"><span id="dateClose"--%>
                        <%--class="glyphicon glyphicon-remove"></span></span>--%>
                        <%--</div>--%>

                        <div class="input-append birthday form_datetime col-sm-4">
                            <input name="birthdayStr" id="birthday" class="form-control input-sm" size="16" type="text">
                            <span class="add-on"><i class="icon-remove"></i></span>
                            <span class="add-on"><i class="icon-th"></i></span>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="age" class="col-sm-2 control-label">年龄</label>

                        <div class="col-sm-4">
                            <input name="age" type="text" class="form-control input-sm" id="age"/>
                        </div>

                        <label class="col-sm-2 control-label">挂号科室</label>
                        <div class="col-sm-4">
                            <select class="form-control" name="department" id="department">
                                <option value="儿童健康科">儿童健康科</option>
                                <option value="内科">内科</option>
                                <option value="外科">外科</option>
                                <option value="妇科">妇科</option>
                            </select>
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
        $('#birthday').datetimepicker({
            weekStart: 1,
            todayBtn: 1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            forceParse: 0,
            showMeridian: 1,
            autoclose: true,
            todayBtn: true,
            minuteStep: 10,
            minView: "month", //选择日期后，不会再跳转去选择时分秒
            format: "yyyy-mm-dd", //选择日期后，文本框显示的日期格式
            language: 'zh-CN', //汉化
            autoclose: true //选择日期后自动关闭
        });

        $ok.click(function () {
            $table.bootstrapTable('refresh');

        });
    })

    $('#dateClose').click(function () {
        $('#birthday').val('');
    });

    function onAddUserClicked() {
        $('#modalTitle').html("新增挂号病人");
        $('#no').val('');
        $('#name').val('');
        $('#gender').val('1');
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
        if (row.status == 1) {
            return '<button type="button" class="btn btn-success btn-sm" onclick="gotow(' + row.id + ' )" >分诊</button>'
        } else if (row.status == 2) {
            return '<button type="button" class="btn btn-success">指引单</button>'
        } else if (row.status == 3) {
            return '<button type="button" class="btn btn-success">收费</button>'
        } else {
            return '<button type="button" class="btn btn-success">其他</button>'
        }

        return row.name + row.status;
    }


    function gotow(id) {
//        alert(id);
        window.location.href = "/demo/guide?id=" + id;
    }

    function birthdayFormatter(value) {
        // 16777215 == ffffff in decimal
        var color = '#' + Math.floor(Math.random() * 6777215).toString(16);
        return '<div  style="color: ' + color + '">' +
                '<i class="glyphicon glyphicon-usd"></i>' +
                value +
                '</div>';
    }

    function onSubmitModal() {
        $.ajax({
            url: '<%=request.getContextPath()%>/demo/addPatient',
            type: 'post',
            data: $("#addForm").serialize(),
            success: function (result) {
                console.log(result);
                if (result.id != null) {
                    $table.bootstrapTable('refresh');
                    modalDialog.modal('hide');
                } else {
                    bootbox.alert("保存失败");
                }
            }
        });
    }


</script>
</body>
</html>
