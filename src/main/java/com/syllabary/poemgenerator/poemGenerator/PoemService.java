package com.syllabary.poemgenerator.poemGenerator;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
@RequestMapping("/poem-generator")
class PoemService {

    private PoemController poemController;

    public PoemService(PoemController poemController) {
        this.poemController = poemController;
    }

    @GetMapping("/listAllPoems")
    public @ResponseBody ResponseEntity<List<String>> get() {
        return new ResponseEntity<List<String>>(poemController.listAllPoems(), HttpStatus.OK);
    }

}
