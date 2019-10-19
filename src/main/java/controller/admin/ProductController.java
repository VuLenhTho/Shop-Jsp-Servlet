package controller.admin;

import constant.Constant;
import model.*;
import model.response.ModelResponse;
import paging.PageRequest;
import service.*;
import service.impl.*;
import utils.MapClientToServerUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/product")
public class ProductController extends HttpServlet {
    private IProductService productService;
    private ISexService sexService;
    private IDiscountService discountService;
    private ISubcategoryService subcategoryService;
    private IProductColorService productColorService;
    private IColorService colorService;
    private ISizeService sizeService;
    private String previousPage;
    private HttpServletRequest req;


    public ProductController() {
        productService = new ProductServiceImpl();
        sexService = new SexServiceImpl();
        discountService = new DiscountServiceImpl();
        subcategoryService = new SubcategoryServiceImpl();
        colorService = new ColorServiceImpl();
        sizeService = new SizeServiceImpl();
        productColorService = new ProductColorServiceImpl();
        previousPage = "1";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.req = req;
        String path;
        String type = req.getParameter(Constant.TYPE);
        sendTheCurrentPageInTheList(type);
        path = redirectToTheEditOrAddNewPage(type);
        sendProductAttributeData(type);
        sendProductDataByPageNumber();

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
        requestDispatcher.forward(req, resp);
    }

    private void sendTheCurrentPageInTheList(String type) {
        String currentPage = req.getParameter("page");
        if (currentPage != null) {
            this.previousPage = currentPage;
        }
        if (type != null) {
            req.setAttribute("previousPage", this.previousPage);
        }
    }

    private String redirectToTheEditOrAddNewPage(String type) {
        String path = Constant.EMPTY;
        Long ID;
        if (type != null) {
            if (type.equals(Constant.ACTION_EDIT)) {
                ID = getProductID();
                ProductModel productModel = productService.findByID(ID);
                if (productModel != null) {
                    req.setAttribute("model", productModel);
                    path = "/views/admin/product/edit_product.jsp";
                } else {
                    req.setAttribute("message", "AccountModel isn't exist");
                }

            } else if (type.equals(Constant.ACTION_CREATE)) {
                path = "/views/admin/product/edit_product.jsp";
            }
        } else {
            path = "/views/admin/product/product_list.jsp";
        }
        return path;
    }


    private void sendProductAttributeData(String type) {
        List<SexModel> sexModels = sexService.findAllSex();
        req.setAttribute("sexModels", sexModels);
        List<SubcategoryModel> subcategoryModels = subcategoryService.findAllSub();
        req.setAttribute("subcategoryModels", subcategoryModels);
        List<DiscountModel> discountModels = discountService.findAllDiscount();
        req.setAttribute("discountModels", discountModels);
        List<SizeModel> sizeModels = sizeService.findAllSize();
        req.setAttribute("sizeModels", sizeModels);
        if (type != null) {
            List<ProductColorModel> productColorModels = productColorService.findByProductID(getProductID());
            req.setAttribute("productColorModels", productColorModels);
            List<ColorModel> colorModels = colorService.findAllColor();
            req.setAttribute("colorModels", colorModels);
        }

    }

    private Long getProductID() {
        String parameter = req.getParameter("id");
        Long ID;
        if (!parameter.equals(Constant.EMPTY)) {
            ID = Long.parseLong(parameter);
            return ID;
        }
        return 0L;
    }

    private void sendProductDataByPageNumber() {
        long totalItem;
        long totalPage;
        PageRequest pageRequest = MapClientToServerUtil.toModel(PageRequest.class, req);
        List<ProductModel> productModelList = productService.findAllProduct(pageRequest);
        totalItem = productService.countAllProduct();
        totalPage = (long) Math.ceil((double) totalItem / pageRequest.getLimit());
        ModelResponse<ProductModel> result = new ModelResponse<>();
        result.setPage(pageRequest.getPage());
        result.setData(productModelList);
        result.setTotalPage(totalPage);
        result.setTotalItem(totalItem);
        req.setAttribute("models", result);
    }
}
