package com.nglb.students.service;

import org.jline.reader.LineReader;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class IOService {

    public IOService(@Lazy LineReader lineReader){
        this.lineReader = lineReader;
    }

    private final LineReader lineReader;

    public String readLine(){
        return lineReader.readLine();
    }
}
