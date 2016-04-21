<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>智护训练</title>
    <style>
        .input_text {
            background-color: #efefef;
            border-color: #000000;
            border-style: solid;
            border-top-width: 0px;
            border-right-width: 0px;
            border-bottom-width: 1px;
            border-left-width: 0px;
        }

    </style>
    <link href="${ctx}/scripts/demo/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="${ctx}/scripts/demo/bower_components/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${ctx}/scripts/demo/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
</head>
<body>
<div id="page-wrapper" style="padding-left: 25%">
    <div class="row">
        <div class="col-lg-12">
            <h3 class="page-header">打印检查指引单</h3>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
    <form:form action="#" method="post" commandName="patient" class="form-horizontal">
        <div class="row">
            <div class="col-lg-6">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <div class="form-group">
                            <label class="col-sm-2 control-label">姓名：</label>
                            <div class="col-sm-2">
                                <label class="control-label">${patient.name}</label>
                            </div>
                            <label class="col-sm-2 control-label">性别：</label>
                            <div class="col-sm-2">
                                <label class="control-label">${patient.genderStr}</label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">年龄：</label>
                            <div class="col-sm-2">
                                <label class="control-label"> ${patient.age}</label>
                            </div>
                            <label class="col-sm-2 control-label">挂号科室：</label>
                            <div class="col-sm-4">
                                <label class="control-label"> ${patient.department}</label>
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-sm-2 control-label">状态：</label>
                            <div class="col-sm-2">
                                <label class="control-label">${patient.statusStr}</label>
                            </div>
                            <label class="col-sm-2 control-label">日期：</label>
                            <div class="col-sm-4">
                                <label class="control-label"> ${patient.createDateStr}</label>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div style="height: 50px"></div>
                    <div class="row">
                        <div class="col-lg-2 col-sm-2 control-label">
                            <label class="control-label">项目：</label>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-lg-1"></div>
                        <div class="form-group col-sm-12">
                            <div class="col-lg-1"></div>
                            <div class="checkbox col-sm-2">
                                <label>
                                    <input type="checkbox" checked="checked" value="">智护训练
                                </label>
                            </div>

                            <label class="col-sm-2 control-label">诊室：</label>
                            <div class="col-sm-2">
                                <label class="control-label">212诊室</label>
                            </div>

                            <label class="col-sm-2 control-label">护士：</label>
                            <div class="col-sm-2">
                                <label class="control-label">赵敏</label>
                            </div>
                        </div>

                        <div class="form-group col-sm-12">
                            <div class="col-lg-1"></div>
                        212诊室在本栋楼2楼212房，无特殊事项
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-lg-2 col-sm-2 control-label">
                            <label class="control-label">备注：</label>
                        </div>
                        <textarea style="width: 460px;"></textarea>
                    </div>
                    <div class="row">
                        <div style="height: 50px"></div>
                        <div class="col-sm-12">
                            <div class="col-lg-1"></div>
                            <div class="col-sm-5">
                                <label class="control-label">申请人：小昭</label>
                            </div>

                            <div class="col-sm-5">
                                <label class="control-label">时间：</label> <label class="control-label"> ${dateStr}</label>
                            </div>
                        </div>
                    </div>
                    <div style="height: 50px"></div>
                </div>
            </div>
        </div>
    </form:form>
</div>

</body>
</html>
