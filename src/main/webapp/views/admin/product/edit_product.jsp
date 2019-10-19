<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp" %>
<c:url var="ApiUrl" value="/api/admin/product"></c:url>
<html>
<head>
    <title>Chỉnh sửa sản phẩm</title>
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
                    <a href="/trangChu">Trang chủ</a>
                </li>
                <li class="active">Chỉnh sửa sản phẩm</li>
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
                        <label class="col-sm-3 control-label no-padding-right">Tên</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="title" name="productName"
                                   value="${model.productName}"/>
                        </div>
                    </div>
                    <br>
                    <br>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">Giá nhâp</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="thumbnail" name="importPrice"
                                   value="${model.importPrice}"/>
                        </div>
                    </div>
                    <br>
                    <br>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">Giá Bán</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="shortDescription" name="price"
                                   value="${model.price}"/>
                        </div>
                    </div>
                    <br>
                    <br>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">Số lượng</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="content" name="amount"
                                   value="${model.amount}"/>
                        </div>
                    </div>
                    <br>
                    <br>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">Giới tính</label>
                        <div class="col-sm-9">
                            <select class="form-control" id="sex" name="sexID">
                                <c:forEach items="${sexModels}" var="sex">
                                    <c:if test="${model.sexID == sex.id}">
                                        <option value="${sex.id}" selected="selected"> ${sex.sexName} </option>
                                    </c:if>
                                    <c:if test="${model.sexID != sex.id}">
                                        <option value="${sex.id}"> ${sex.sexName} </option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <br>
                    <br>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">Trạng thái</label>
                        <div class="col-sm-9">
                            <select class="form-control" id="status" name="status">
                                <c:if test="${model.status == 'TRADING'}">
                                    <option value="${model.status}" selected="selected"> ${model.status} </option>
                                    <option value="STOP TRADING"> STOP TRADING</option>
                                </c:if>
                                <c:if test="${model.status == 'STOP TRADING'}">
                                    <option value="${model.status}" selected="selected"> ${model.status} </option>
                                    <option value="TRADING"> TRADING</option>
                                </c:if>
                            </select>
                        </div>
                    </div>

                    <br>
                    <br>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">SubCategory</label>
                        <div class="col-sm-9">
                            <select class="form-control" id="code" name="subcategoryID">
                                <c:forEach items="${subcategoryModels}" var="category">
                                    <c:if test="${model.subcategoryID == category.id}">
                                        <option value="${category.id}"
                                                selected="selected"> ${category.subcategoryName} </option>
                                    </c:if>
                                    <c:if test="${model.subcategoryID != category.id}">
                                        <option value="${category.id}"> ${category.subcategoryName} </option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <br>
                    <br>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">Khuyến mãi</label>
                        <div class="col-sm-9">
                            <select class="form-control" id="sale" name="discountID">
                                <c:forEach items="${discountModels}" var="sale">
                                    <c:if test="${model.discountID == sale.id}">
                                        <option value="${sale.id}" selected="selected"> ${sale.discountName} </option>
                                    </c:if>
                                    <c:if test="${model.discountID != sale.id}">
                                        <option value="${sale.id}"> ${sale.discountName} </option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <br>
                    <br>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">Xu Hướng</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="trends" name="trends"
                                   value="${model.trends}"/>
                        </div>
                    </div>
                    <br>
                    <br>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">Bán Chạy</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="hotSale" name="hotSelling"
                                   value="${model.hotSelling}"/>
                        </div>
                    </div>
                    <br>
                    <br>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">Ảnh đại diện</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="thumb" name="thumbnail"
                                   value="${model.thumbnail}"/>
                        </div>
                    </div>
                    <br>
                    <br>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right">Danh sách ảnh</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="thumbnaillist" name="thumbnailList"
                                   value="${model.thumbnailList}"/>
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
                                       value="Cập nhật sản phẩm"
                                       id="btnAddOrUpdate"/>

                            </c:if>
                            <c:if test="${empty model.id}">
                                <input type="button" class="btn btn-white btn-warning btn-bold"
                                       value="Thêm mới sản phẩm"
                                       id="btnAddOrUpdate"/>
                            </c:if>
                        </div>
                    </div>
                </form>
                <br>
                <br>
                <h3 style="color: #004980; font-weight: bold">Màu sắc và số hàng hiện có: </h3>
                <form id="color">
                    <c:forEach items="${productColorModels}" var="productColor">
                        <c:forEach items="${colorModels}" var="color">
                            <c:if test="${productColor.colorID == color.id}">
                                <br>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right">${color.colorName}</label>
                                    <div class="col-sm-9">
                                        <input type="hidden" class="form-control" id="productID" name="productID"
                                               value="${model.id}"/>
                                        <input type="hidden" class="form-control" id="colorID" name="colorID"
                                               value="${color.id}"/>
                                        <input type="text" class="form-control" id="amount" name="amount"
                                               value="${productColor.amount}"/>
                                    </div>
                                </div>
                                <br>

                            </c:if>
                        </c:forEach>
                    </c:forEach>
                    <br>
                    <br>
                    <div class="form-group">
                        <div class="col-sm-12">
                            <c:if test="${not empty model.id}">
                                <input type="button" class="btn btn-white btn-warning btn-bold"
                                       value="Cập nhật màu sắc và số lượng"
                                       id="btnAddOrUpdateColor"/>
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
            addProduct(data);
        } else {
            updateProduct(data);
        }
    });

    function addProduct(data) {
        $.ajax({
            url: ('${ApiUrl}'),
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'html',
            success: function () {
                window.location.href = 'http://localhost:8080/admin/product?page=${previousPage}&size=2';
            },
            error: function () {
            }
        });
    }

    function updateProduct(data) {
        $.ajax({
            url: ('${ApiUrl}'),
            type: 'PUT',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'html',
            success: function () {
                window.location.href = 'http://localhost:8080/admin/product?page=${previousPage}&size=2';

            }
        });
    }
</script>
</body>
</html>