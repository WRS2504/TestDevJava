package com.digisystem.TestJavaDeveloper.controller;

import com.digisystem.TestJavaDeveloper.domain.DataToPersonUpdate;
import org.apache.logging.log4j.LogManager;
import com.digisystem.TestJavaDeveloper.domain.DataToCompute;
import com.digisystem.TestJavaDeveloper.domain.DataToPerson;
import com.digisystem.TestJavaDeveloper.domain.RspChallenge01;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.digisystem.TestJavaDeveloper.utilities.Util;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestJavaDeveloperController {

    @Autowired
    private MongoTemplate mongoTemplate;

    private static Logger logger = LogManager.getLogger(TestJavaDeveloperController.class);

    @RequestMapping(value = "/isOnline", method = RequestMethod.GET)
    public ResponseEntity<String> isOnline() {
        logger.debug("isOnline: Test Java Developer Micro Service is ON LINE");
        return new ResponseEntity<String>("Test Java Developer Micro Service is ON LINE", HttpStatus.OK);
    }

    @RequestMapping(value = "/chl01", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    public ResponseEntity<RspChallenge01> chl01(@RequestBody DataToCompute data) {
        logger.debug("CALL: chl01");
        return new ResponseEntity(Util.compute(data), HttpStatus.OK);
    }

    @RequestMapping(value = "/chl02FindAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    public ResponseEntity<List<DataToPerson>> challenge02FindAll() {
        List<DataToPerson> personList = mongoTemplate.findAll(DataToPerson.class);

        if(personList != null) {
            logger.debug("CALL: chl02FindAll is Ok");
            return new ResponseEntity(personList, HttpStatus.OK);
        }else{
            logger.debug("CALL: chl02FindAll not fund");
            return new ResponseEntity("not fund", HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/chl02Save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    public ResponseEntity chl02Save(@RequestBody DataToPerson data) {
        mongoTemplate.save(data);
        logger.debug("CALL: chl02Save");
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/chl02FindPersonById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    public ResponseEntity<DataToPerson> challenge02Save(@RequestParam String id) {
        DataToPerson person = mongoTemplate.findById(id, DataToPerson.class);
        if(person != null) {
            logger.debug("CALL: chl02FindPersonById is OK");
            return new ResponseEntity(person, HttpStatus.OK);
        }else{
            logger.debug("CALL: chl02FindPersonById not fund");
            return new ResponseEntity("not fund", HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/chl02FindPersonByName", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    public ResponseEntity<DataToPerson> challenge02FindPersonByName(@RequestParam String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("pessoa.nome").is(name));
        DataToPerson person = mongoTemplate.findOne(query, DataToPerson.class);
        if(person != null) {
            logger.debug("CALL: chl02FindPersonByName is OK");
            return new ResponseEntity(person, HttpStatus.OK);
        }else{
            logger.debug("CALL: chl02FindPersonByName not fund");
            return new ResponseEntity("not fund", HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/chl02FindPersonBySalary", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    public ResponseEntity<DataToPerson> challenge02FindPersonBySalary(@RequestParam String salary) {
        Query query = new Query();
        query.addCriteria(Criteria.where("pessoa.salario").is(salary));
        DataToPerson person = mongoTemplate.findOne(query, DataToPerson.class);

        if(person != null) {
            logger.debug("CALL: chl02FindPersonBySalary is OK");
            return new ResponseEntity(person, HttpStatus.OK);
        }else{
            logger.debug("CALL: chl02FindPersonBySalary not fund");
            return new ResponseEntity("not fund", HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/chl02UpdatePerson", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    public ResponseEntity chl02UpdatePersonById(@RequestBody DataToPersonUpdate data) {
        DataToPerson person = null;
        Query query = new Query();
        Update update = new Update();

        if(data.getTypeKeyToUpdate() == 0) {
            query.addCriteria(Criteria.where("_id").is(data.getKeyToUpdate()));
        }else if(data.getTypeKeyToUpdate() == 1){
            query.addCriteria(Criteria.where("pessoa.nome").is(data.getKeyToUpdate()));
        }else{
            logger.debug("CALL: chl02chl02UpdatePerson error number of type to update");
            return new ResponseEntity("Error number of type to update (type 0 or 1)", HttpStatus.BAD_REQUEST);
        }

        person = mongoTemplate.findOne(query, DataToPerson.class);

        if(person != null) {
            logger.debug("CALL: chl02UpdatePerson is OK");
            update.set("pessoa.nome", data.getPessoa().getNome());
            update.set("pessoa.idade", data.getPessoa().getIdade());
            update.set("pessoa.salario", data.getPessoa().getSalario());
            mongoTemplate.updateFirst(query, update, DataToPerson.class);
            logger.debug("CALL: chl02UpdatePerson Update was done");
            return new ResponseEntity("Update was done", HttpStatus.OK);
        }
        else{
            logger.debug("CALL: chl02UpdatePerson not fund");
            return new ResponseEntity("not fund", HttpStatus.OK);
        }
    }
}