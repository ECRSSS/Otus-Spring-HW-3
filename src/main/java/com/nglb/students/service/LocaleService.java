package com.nglb.students.service;


import org.springframework.core.io.Resource;

public interface LocaleService {

    String getMessage(String property);

    Resource getLocalizedFile(String fileName);

    void setLocale(String locale);
}
