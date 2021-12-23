package com.syllabary.poemgenerator.poemGenerator;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@RequestMapping("/poem-generator")
class PoemService {

    private InputController inputController;

    public PoemService(InputController inputController) {
        this.inputController = inputController;
    }
//
//    @GetMapping("/getSortedMatrix")
//    public ResponseEntity<List<int[]>> getSortedMatrix() {
//        return new ResponseEntity<List<int[]>>(inputController.getSortedMatrix(), HttpStatus.OK);
//    }
//
    @GetMapping("/get2dMatrix")
    public ResponseEntity<int[][]> get2dMatrix() {
        return new ResponseEntity<int[][]>(inputController.get2dPoemMatrix(), HttpStatus.OK);
    }

    @GetMapping("/listAllPoems")
    public ResponseEntity<List<String>> getPoemList() {
        return new ResponseEntity<List<String>>(inputController.listAllPoems(), HttpStatus.OK);
    }

}
