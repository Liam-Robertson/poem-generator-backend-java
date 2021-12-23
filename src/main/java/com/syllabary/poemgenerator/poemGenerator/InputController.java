package com.syllabary.poemgenerator.poemGenerator;

import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class InputController {

    public List<int[]> getSortedMatrix() {
        List<int[]> poemMatrixUnsorted = this.get2dPoemMatrix();
        Collections.sort(poemMatrixUnsorted, new Comparator<int[]>() {
            public int compare(int []a,int []b) {
                for(int i = 0; i< 6;i++)
                    if(a[i]!=b[i]) return a[i]-b[i];
                return a[6] - b[6];
            }
        });
        return poemMatrixUnsorted;
    }

    public List<List<Integer>> get2dPoemMatrix() {
        List<String> poemNameListRaw = this.listAllPoems();
        List<List<Integer>> poemCodeList = poemNameListRaw
                .stream()
                .map((poemName) -> {
                    List<String> poemCodeListStr = Arrays.asList(poemName.substring(0, poemName.length() - 4).split("-"));
                    List<Integer> poemCodeListFinal = poemCodeListStr.stream().map(poemNameStr -> ).collect(Collectors.toList());
                    return poemCodeListFinal;
                })
                .collect(Collectors.toList());
        return poemCodeList;
    }

    public List<String> listAllPoems() {
        URL url = this.getClass().getClassLoader().getResource("static/poems");
        File file = new File(url.getFile());
        return Arrays.asList(file.list());
    }

}
