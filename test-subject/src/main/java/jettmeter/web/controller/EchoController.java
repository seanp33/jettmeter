package jettmeter.web.controller;

import jettmeter.web.model.Record;
import jettmeter.web.service.repository.RepositoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EchoController {
    private static final Logger logger = LoggerFactory.getLogger(EchoController.class);


    @Autowired(required = true)
    private RepositoryService<String, Record, String> repository;

    @RequestMapping(value = "/echo/{term}", method = RequestMethod.GET)
    @ResponseBody
    public String echo(@PathVariable String term) {
        return term;
    }
}
