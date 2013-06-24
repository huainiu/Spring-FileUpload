package com.springapp.mvc;

import com.springapp.mvc.model.FileUpload;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created with IntelliJ IDEA.
 * User: tharanga
 * Date: 6/24/13
 * Time: 5:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class FileUploadValidator implements Validator {
    @Override
    public boolean supports(Class clazz) {
        //just validate the FileUpload instances
        return FileUpload.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        FileUpload file = (FileUpload)target;

        if(file.getFile().getSize()==0){
            errors.rejectValue("file", "required.fileUpload");
        }
    }
}
