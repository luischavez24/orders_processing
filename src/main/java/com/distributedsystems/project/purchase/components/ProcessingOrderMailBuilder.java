package com.distributedsystems.project.purchase.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.distributedsystems.project.purchase.entities.Order;

@Component
public class ProcessingOrderMailBuilder  {

    @Autowired
    private TemplateEngine templateEngine;
   
    private String template;
    
    private Order order;

    public ProcessingOrderMailBuilder withTemplate(String template) {
        this.template = template;
        return this;
    }
    
    public ProcessingOrderMailBuilder withOrder(Order order) {
        this.order = order;
        return this;
    }

    public String build() {
        Context context = new Context();
        context.setVariable("order", order);
        return templateEngine.process(template, context);
    }
}