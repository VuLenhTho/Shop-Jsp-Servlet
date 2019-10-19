package controller.admin.api;

import model.ProductModel;
import service.IProductService;
import service.impl.ProductServiceImpl;
import utils.JsonToModelUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

@WebServlet("/api/admin/product")
public class ProductAPIController extends HttpServlet implements Serializable {
    IProductService productService;

    public ProductAPIController() {
        productService = new ProductServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("/application/json");
        ProductModel productModel = JsonToModelUtil.of(req.getReader()).toModel(ProductModel.class);
        productService.insertProduct(req,productModel);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("/application/json");
        ProductModel productModel = JsonToModelUtil.of(req.getReader()).toModel(ProductModel.class);
        productService.updateProduct(req,productModel);
    }
}
