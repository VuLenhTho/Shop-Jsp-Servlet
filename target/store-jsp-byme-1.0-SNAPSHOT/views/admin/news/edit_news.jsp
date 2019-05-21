<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<%--<c:url var="ApiUrl" value="/api/admin/news"></c:url>--%>
<html>
<head>
    <title>Chỉnh sửa bài viết</title>
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
                <li class="active">Chỉnh sửa bài viết</li>
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
                        <label class="col-sm-3 control-label no-padding-right">Thể loại</label>
                        <div class="col-sm-9">
                            <select class="form-control" id="code" name="categoryID">
                                <c:forEach items="${categoryList}" var="category">
                                    <c:if test="${model.categoryID == category.id}">
                                        <option value="${category.id}" selected="selected"> ${category.name} </option>
                                    </c:if>
                                    <c:if test="${model.categoryID != category.id}">
                                        <option value="${category.id}"> ${category.name} </option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <br>
                    <br>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">Tiêu đề</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="title" name="title" value="${model.title}"/>
                        </div>
                    </div>
                    <br>
                    <br>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">Hình đại diện</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="thumbnail" name="thumbnail"
                                   value="${model.thumbNail}"/>
                        </div>
                    </div>
                    <br>
                    <br>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">Mô tả ngắn</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="shortDescription" name="shortDescription"
                                   value="${model.shortDescription}"/>
                        </div>
                    </div>
                    <br>
                    <br>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">Nội dung</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="content" name="content"
                                   value="${model.content}"/>
                        </div>
                    </div>
                    <br>
                    <br>

                    <c:if test="${model.status == 'PENDING' || model.status == 'APPROVED'}">
                        <div class="form-group">
                            <label class="col-sm-3 control-label no-padding-right">Trạng thái</label>
                            <div class="col-sm-9">
                                <select class="form-control" id="status" name="status">
                                    <c:if test="${model.status == 'PENDING'}">
                                        <option value="${model.status}" selected="selected"> ${model.status} </option>
                                        <option value="APPROVED"> APPROVED </option>
                                    </c:if>
                                    <c:if test="${model.status == 'APPROVED'}">
                                        <option value="${model.status}" selected="selected"> ${model.status} </option>
                                        <option value="PENDING"> PENDING </option>
                                    </c:if>
                                </select>
                            </div>
                        </div>
                    </c:if>
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
                                       value="Cập nhật bài viết"
                                       id="btnAddOrUpdate"/>
                            </c:if>
                            <c:if test="${empty model.id}">
                                <input type="button" class="btn btn-white btn-warning btn-bold"
                                       value="Thêm mới bài viết"
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
            addNews(data);
        } else {
            updateNews(data);
        }
    });

    function addNews(data) {
        $.ajax({
            url: ('${ApiUrl}'),
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'html',
            success: function () {
                window.location.href = 'http://localhost:8080/admin/news';
            },
            error: function () {

            }
        });
    }

    function updateNews(data) {
        $.ajax({
            url: ('${ApiUrl}'),
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'html',
            success: function () {
                window.location.href = 'http://localhost:8080/admin/news';

            }
        });
    }
</script>
</body>
</html>