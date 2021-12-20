package com.syllabary.poemgenerator.poemGenerator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

@RestController
public class PoemController {

    public List<String> listAllPoems() {
        URL url = this.getClass().getClassLoader().getResource("static/poems");
        File file = new File(url.getFile());
        return Arrays.asList(file.list());
    }

}
