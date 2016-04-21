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
</head>
<body>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h3 class="page-header">打印检查指引单</h3>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <!-- /.row -->
    <form:form action="#" method="post" commandName="patient" class="form-horizontal">
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <div class="form-group">
                            <label class="col-sm-1 control-label">姓名</label>
                            <div class="col-sm-2">
                                <input class="input_text" type="text" value="张三" readonly/>
                            </div>
                            <label class="col-sm-1 control-label">性别</label>
                            <div class="col-sm-2">
                                <form:input cssClass="form-control input-sm input_text" path="birthdayStr"/>
                            </div>
                            <label class="col-sm-1 control-label">出生日期</label>
                            <div class="col-sm-2">
                                <form:input cssClass="form-control input-sm" path="birthdayStr"/>
                            </div>
                            <label class="col-sm-1 control-label">年龄</label>
                            <div class="col-sm-2">
                                <form:input cssClass="form-control input-sm" path="age"/>
                            </div>
                        </div>


                        <div class="form-group">
                            <label class="col-sm-1 control-label">挂号科室</label>
                            <div class="col-sm-2">
                                <form:input cssClass="form-control input-sm" path="department"/>
                            </div>
                            <label class="col-sm-1 control-label">状态</label>
                            <div class="col-sm-2">
                                <form:input cssClass="form-control input-sm" path="status"/>
                            </div>
                            <label class="col-sm-1 control-label">日期</label>
                            <div class="col-sm-2">
                                <form:input cssClass="form-control input-sm" path="createDateStr"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="row">
                        <div class="col-lg-1 col-sm-2 control-label">
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

                            <label class="col-sm-1 control-label">诊室</label>
                            <div class="col-sm-2">
                                212诊室
                            </div>

                            <label class="col-sm-1 control-label">护士</label>
                            <div class="col-sm-2">
                                赵敏
                            </div>
                        </div>

                        <div class="form-group col-sm-12">
                            <div class="col-lg-1"></div>
                            <textarea style="width: 600px;">212诊室在本栋楼2楼212房，无特殊事项</textarea>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-lg-1 col-sm-2 control-label">
                            <label class="control-label">备注：</label>
                        </div>
                        <textarea style="width: 600px;"></textarea>
                    </div>
                    <div class="row">
                        <div style="height: 100px"></div>
                        <div class="col-sm-12">
                            <div class="col-lg-1"></div>
                            <div class="col-sm-5">
                                申请人：小昭
                            </div>

                            <div class="col-sm-5">
                                日期：2016-03-21
                            </div>
                        </div>
                    </div>
                    <div style="height: 100px"></div>
                </div>
            </div>
        </div>
    </form:form>
</div>

</body>
</html>
