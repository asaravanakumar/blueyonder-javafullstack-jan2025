module mod1 {
    exports com.labs.java.module.product.model;
    exports com.labs.java.module.product.service to mod2;
//    opens com.labs.java.module.product.service;

//    provides com.labs.java.module.product.service.ProductService with com.labs.java.module.product.service.ProductServiceImpl;
}