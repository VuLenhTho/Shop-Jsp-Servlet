<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quản lý sản phẩm</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs ace-save-state" id="breadcrumbs">
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Trang chủ</a>
                </li>
            </ul>
        </div>
        <form action="<c:url value="/admin/product"/>" id="formSubmit" method="get">
            <div class="page-content">
                <c:if test="${not empty message}">
                <div class="alert alert-${alert}">
                        ${message}
                </div>
                </c:if>
                <div class="row">
                    <div class="col-xs-12">
                        <div class="widget-box table-filter">
                            <div class="table-btn-controls">
                                <div class="pull-right tableTools-container">
                                    <div class="dt-buttons btn-overlap btn-group">
                                        <a flag="info"
                                           class="dt-button buttons-colvis btn btn-white btn-primary btn-bold"
                                           data-toggle="tooltip"
                                           title='Thêm sản phẩm' href="/admin/product?type=create">
<span>
<i class="fa fa-plus-circle bigger-110 purple"></i>
</span>
                                        </a>
                                        <button id="btnDelete" type="button" disabled
                                                class="dt-button buttons-html5 btn btn-white btn-primary btn-bold">
<span>
<i class="fa fa-trash-o bigger-110 pink"></i>
</span>
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="table-responsive">
                                    <table class="table table-bordered">
                                        <thead>
                                        <tr>
                                            <td>Số thứ tự</td>
                                            <th>Tên sản phẩm</th>
                                            <th>Giá nhập</th>
                                            <th>Giá bán</th>
                                            <th>Số lượng</th>
                                            <th>Giới tính</th>
                                            <th>Trạng thái</th>
                                            <th>Subcategory</th>
                                            <th>Khuyến mại</th>
                                            <th>Xu hướng</th>
                                            <th>Bán chạy</th>
<%--                                            <th>Màu</th>--%>
<%--                                            <th>Size</th>--%>
                                            <th>Thao tác</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="item" items="${models.data}">
                                            <tr>
                                                <td>${item.id}</td>
                                                <th>${item.productName}</th>
                                                <th>${item.importPrice}</th>
                                                <th>${item.price}</th>
                                                <th>${item.amount}</th>
                                                <c:forEach var="sex" items="${sexModels}">
                                                    <c:if test="${sex.id == item.sexID}">
                                                        <th>${sex.sexName}</th>
                                                    </c:if>
                                                </c:forEach>
                                                <th>${item.status}</th>
                                                <c:forEach var="sub" items="${subcategoryModels}">
                                                    <c:if test="${sub.id == item.subcategoryID}">
                                                        <th>${sub.subcategoryName}</th>
                                                    </c:if>
                                                </c:forEach>
                                                <c:forEach var="sale" items="${discountModels}">
                                                    <c:if test="${sale.id == item.discountID}">
                                                        <th>${sale.discountName}</th>
                                                    </c:if>
                                                </c:forEach>
                                                <th>${item.trends}</th>
                                                <th>${item.hotSelling}</th>
<%--                                                <c:forEach var="color" items="${colorModels}">--%>
<%--                                                    <c:if test="${color.id == item.colorID}">--%>
<%--                                                        <th>${colorName}</th>--%>
<%--                                                    </c:if>--%>
<%--                                                </c:forEach>--%>
<%--                                                <c:forEach var="size" items="${sizeModels}">--%>
<%--                                                    <c:if test="${size.id == item.sizeID}">--%>
<%--                                                        <th>${sizeName}</th>--%>
<%--                                                    </c:if>--%>
<%--                                                </c:forEach>--%>
                                                <th>
                                                    <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                                                       title="Cập nhập bài viết"
                                                       href="/admin/product?type=edit&id=${item.id}">
                                                        <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                                    </a>
                                                </th>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                    <ul class="pagination" id="pagination"></ul>
                                    <input type="hidden" value="" id="page" name="page">
                                    <input type="hidden" value="2" id="size" name="size">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
        </form>
    </div>
</div>
</div>
<script type="text/javascript">
    var totalPages = ${models.totalPage};
    var currentPage = ${models.page};
    var limit = 2;
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPages,
            visiblePages: 10,
            startPage: currentPage,
            limit: 2,
            onPageClick: function (event, page) {
                if (currentPage != page) {
                    $('#size').val(limit);
                    $("#page").val(page);
                    $('#formSubmit').submit();
                }
            }
        })
    });
</script>
</body>
</html>