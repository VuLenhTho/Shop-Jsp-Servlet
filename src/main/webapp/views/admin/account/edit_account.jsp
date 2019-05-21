<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="ApiUrl" value="/api/admin/account"></c:url>
<html>
<head>
    <title>Chỉnh sửa tài khoản</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try {
                    ace.settings.check('breadcrumbs', 'fixed')
                } catch (e) {
                }
            </script>
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Trang chủ</a>
                </li>
                <li class="active">Chỉnh sửa tài khoản</li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <c:if test="${not empty message}">
                    <div class="alert alert-${alert}">
                            ${message}
                    </div>
                </c:if>
                <form id="formUpdateOrCreate">
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">UserName</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="title" name="userName" value="${model.userName}"/>
                        </div>
                    </div>
                    <br>
                    <br>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">PassWord</label>
                        <div class="col-sm-9">
                            <input type="password" class="form-control" id="password" name="password" value="${model.password}"/>
                        </div>
                    </div>
                    <br>
                    <br>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">Họ</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="thumbnail" name="firstName"
                                   value="${model.firstName}"/>
                        </div>
                    </div>
                    <br>
                    <br>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">Tên</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="shortDescription" name="lastName"
                                   value="${model.lastName}"/>
                        </div>
                    </div>
                    <br>
                    <br>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">Email</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="content" name="email"
                                   value="${model.email}"/>
                        </div>
                    </div>
                    <br>
                    <br>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">Số điện thoại</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="phoneNumber" name="phoneNumber"
                                   value="${model.phoneNumber}"/>
                        </div>
                    </div>
                    <br>
                    <br>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">Giới tính</label>
                        <div class="col-sm-9">
                            <select class="form-control" id="sexID" name="sexID">
                                <option value="1" selected="selected"> Nam </option>
                                <option value="2"> Nữ </option>
                            </select>
                        </div>
                    </div>
                    <br>
                    <br>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">Quyền</label>
                        <div class="col-sm-9">
                            <select class="form-control" id="code" name="roleID">
                                <c:forEach items="${roleModelList}" var="role">
                                    <c:if test="${model.roleID == role.id}">
                                        <option value="${role.id}" selected="selected"> ${role.roleName} </option>
                                    </c:if>
                                    <c:if test="${model.roleID != role.id}">
                                        <option value="${role.id}"> ${role.roleName} </option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <br>
                    <br>
                    <div class="form-group">

                        <input type="hidden" class="form-control" id="id" name="id" value="${model.id}"/>

                    </div>
                    <br>
                    <br>
                    <div class="form-group">
                        <div class="col-sm-12">
                            <c:if test="${not empty model.id}">
                                <input type="button" class="btn btn-white btn-warning btn-bold"
                                       value="Cập nhật tài khoản"
                                       id="btnAddOrUpdate"/>
                            </c:if>
                            <c:if test="${empty model.id}">
                                <input type="button" class="btn btn-white btn-warning btn-bold"
                                       value="Thêm mới tài khoản"
                                       id="btnAddOrUpdate"/>
                            </c:if>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<script>
    $('#btnAddOrUpdate').click(function (e) {
        e.preventDefault();
        var data = {};
        var formData = $('#formUpdateOrCreate').serializeArray();
        $.each(formData, function (i, v) {
            data["" + v.name + ""] = v.value;
        });

        var id = $('#id').val();
        if (id == '') {
            addAccount(data);
        } else {
            updateAccount(data);
        }
    });

    function addAccount(data) {
        $.ajax({
            url: ('${ApiUrl}'),
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'html',
            success: function () {
                window.location.href = 'http://localhost:8080/admin/account';
            },
            error: function () {

            }
        });
    }

    function updateAccount(data) {
        $.ajax({
            url: ('${ApiUrl}'),
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'html',
            success: function () {
                window.location.href = 'http://localhost:8080/admin/account';

            }
        });
    }
</script>
</body>
</html>