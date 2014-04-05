package jettmeter.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EchoController {
    private static final Logger logger = LoggerFactory.getLogger(EchoController.class);


    public EchoController() {
    }

    @RequestMapping(value = "/echo/{term}", method = RequestMethod.GET)
    @ResponseBody
    public String echo(@PathVariable String term) {
        return term;
    }
}
