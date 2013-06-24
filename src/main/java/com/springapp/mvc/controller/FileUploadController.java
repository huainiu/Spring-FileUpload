package com.springapp.mvc.controller;

import com.springapp.mvc.model.FileUpload;
import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 * User: tharanga
 * Date: 6/24/13
 * Time: 5:05 PM
 * To change this template use File | Settings | File Templates.
 */

public class FileUploadController extends SimpleFormController {
    public FileUploadController(){
        setCommandClass(FileUpload.class);
        setCommandName("fileUploadForm");
    }

    @Override
    protected ModelAndView onSubmit(HttpServletRequest request,
                                    HttpServletResponse response, Object command, BindException errors)
            throws Exception {

        FileUpload file = (FileUpload)command;

        MultipartFile multipartFile = file.getFile();

        String fileName="";

        if(multipartFile!=null){
            fileName = multipartFile.getOriginalFilename();
            //do whatever you want
        }

        return new ModelAndView("FileUploadSuccess","fileName",fileName);
    }
}
