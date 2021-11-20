package qu.brick.spring.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import qu.brick.spring.web.data.Product;
import qu.brick.spring.web.repositories.ProductRepository;

@Controller
public class MainController {

    ProductRepository productRepository;

    public MainController(ProductRepository studentRepository) {
        this.productRepository = studentRepository;
    }

//    // GET [http://localhost:8189/app]/product/110/info
//    @GetMapping("/product/{id}/info")
//    @ResponseBody
//    public String showProductInfo(@PathVariable Long id) {
//        return "Product #" + id;
//    }

    // GET http://localhost:8189/app/products
    @GetMapping("/products")
    public String showStudentsPage(Model model) {
        model.addAttribute("products", productRepository.getAllProducts());
        return "products_page";
    }

    @GetMapping("/products/{id}")
    public String showStudentPage(Model model, @PathVariable Long id) {
        Product product = productRepository.findById(id);
        model.addAttribute("product", product);
        return "product_info_page";
    }

    @GetMapping("/products/add")
    public String addNewProductForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "add_new_product_page";
    }

    @PostMapping("/products/add")
    public String addNewProductCreate(Model model, Product product) {
        if (productRepository.addProduct(product)) {
            model.addAttribute("products", productRepository.getAllProducts());
            return "products_page";
        } else {
            String productExist = "Такой товар уже существует";
            model.addAttribute("exist", productExist);
            return "add_new_product_page";
        }
    }

}
