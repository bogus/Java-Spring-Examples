package com.medratech.spring.mvc.web;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.medratech.spring.mvc.service.ProductManager;

@Controller
@RequestMapping("/*")
public class InventoryController {

    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    private ProductManager productManager;

    @RequestMapping
    public ModelAndView inventoryHandler() {

        if (logger.isDebugEnabled()) {
            logger.debug("inventoryHandler called");
        }

        String now = (new Date()).toString();        

        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        myModel.put("products", this.productManager.getProducts());

        return new ModelAndView("hello", "model", myModel);
    }

    public void setProductManager(ProductManager productManager) {
        this.productManager = productManager;
    }
}
