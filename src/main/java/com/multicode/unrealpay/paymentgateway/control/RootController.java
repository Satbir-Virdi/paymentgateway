package com.multicode.unrealpay.paymentgateway.control;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
@CrossOrigin
public class RootController {

    @GetMapping()
    public ModelAndView redirectToClient() {
        return new ModelAndView("redirect:/paymentgatewayclient.html");
    }

}
