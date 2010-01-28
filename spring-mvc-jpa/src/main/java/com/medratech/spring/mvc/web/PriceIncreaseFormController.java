package com.medratech.spring.mvc.web;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.medratech.spring.mvc.service.PriceIncrease;
import com.medratech.spring.mvc.service.ProductManager;



@Controller
@RequestMapping("/priceincrease.htm")
public class PriceIncreaseFormController {
    private final Logger logger = Logger.getLogger(getClass());

    @Autowired    
    private ProductManager productManager;
    
    @Autowired
    private Validator priceValidator;

    @RequestMapping(method=RequestMethod.POST)
    public String processSubmit(
        @ModelAttribute("priceIncrease") PriceIncrease priceIncrease,
        BindingResult result, SessionStatus status) {
        
        priceValidator.validate(priceIncrease, result);
        
        if (result.hasErrors()) {
            return "priceincrease";
        } else {
            int increase = priceIncrease.getPercentage();
            
            logger.info("Increasing prices by " + increase + "%.");
            
            productManager.increasePrice(increase);            
        
            status.setComplete();
            return "redirect:hello.htm";
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public String setupForm(
        @RequestParam(required = false, value = "20") Integer percentage, 
        ModelMap model) {
        
        PriceIncrease priceIncrease = new PriceIncrease();
        priceIncrease.setPercentage(10);
        
        model.addAttribute("priceIncrease", priceIncrease);
        
        return "priceincrease";
    }

    public void setProductManager(ProductManager productManager) {
        this.productManager = productManager;
    }

    public ProductManager getProductManager() {
        return productManager;
    }

}
