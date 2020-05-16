package com.example;

import com.example.domain.Customer;
import com.example.domain.Message;
import com.example.repos.CustomerDAO;
import com.example.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


@Controller
public class GreetingController {
//    @Autowired
//    private MessageRepo messageRepo;

    @Autowired
    private CustomerDAO customerDAO;


    @GetMapping(path = "/")
    public String index() {
        return "external";
    }

    @GetMapping(path = "/customers")
    public String customers(Model model) {
        addCustomers();
        model.addAttribute("customers", customerDAO.findAll());
        return "customers";
    }

    public void addCustomers() {

        Customer customer1 = new Customer();
        customer1.setAddress("1111 foo blvd");
        customer1.setName("Foo Industries");
        customer1.setServiceRendered("Important services");
        customerDAO.save(customer1);

        Customer customer2 = new Customer();
        customer2.setAddress("2222 bar street");
        customer2.setName("Bar LLP");
        customer2.setServiceRendered("Important services");
        customerDAO.save(customer2);

        Customer customer3 = new Customer();
        customer3.setAddress("33 main street");
        customer3.setName("Big LLC");
        customer3.setServiceRendered("Important services");
        customerDAO.save(customer3);
    }

//    @GetMapping("/greeting")
//    public String greeting(
//            @RequestParam(name = "name", required = false, defaultValue = "World") String name,
//            Map<String, Object> model) {
//        model.put("name", name);
//        return "greeting";
//    }
//
//    @GetMapping
//    public String main(Map<String, Object> model) {
//        Iterable<Message> messages = messageRepo.findAll();
//        model.put("messages", messages);
//        return "main";
//    }
//
//    @PostMapping
//    public String add(@RequestParam String text,
//                      @RequestParam String tag,
//                      Map<String, Object> model) {
//        Message message = new Message(text, tag);
//        messageRepo.save(message);
//
//        Iterable<Message> messages = messageRepo.findAll();
//        model.put("messages", messages);
//        return "main";
//    }
//
//    @PostMapping("filter")
//    public String filter(@RequestParam String filter,
//                         Map<String, Object> model) {
//        Iterable<Message> messages;
//        if (filter != null && !filter.isEmpty()) {
//            messages = messageRepo.findByTag(filter);
//        } else {
//            messages = messageRepo.findAll();
//        }
//        model.put("messages", messages);
//        return "main";
//    }
//
//    @GetMapping(path = "/logout")
//    public String logout(HttpServletRequest request) throws ServletException {
//        request.logout();
//        return "/";
//    }
}

//@Controller
//public class ProductController {
//
//    @Autowired
//    ProductService productService;
//
//    @GetMapping(path = "/products")
//    public String getProducts(Model model){
//        model.addAttribute("products", productService.getProducts());
//        return "products";
//    }
//
//    @GetMapping(path = "/logout")
//    public String logout(HttpServletRequest request) throws ServletException {
//        request.logout();
//        return "/";
//    }
//}