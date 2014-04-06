package jettmeter.web.controller;

import jettmeter.web.model.Record;
import jettmeter.web.service.repository.RepositoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

import static org.apache.commons.lang.RandomStringUtils.randomAlphanumeric;

@Controller
public class StoreController {
    private static final Logger logger = LoggerFactory.getLogger(StoreController.class);

    @Autowired(required = true)
    private RepositoryService<String, Record, String> repository;

    @RequestMapping(value = "/store/write/rand", method = RequestMethod.GET)
    @ResponseBody
    public String writeRand() {
        String id = UUID.randomUUID().toString();
        Record rec = new Record(id);
        rec.set(randomAlphanumeric(3), randomAlphanumeric(3));
        return repository.write(rec);
    }
}

