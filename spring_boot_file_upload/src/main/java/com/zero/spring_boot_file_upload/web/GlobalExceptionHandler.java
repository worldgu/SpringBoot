package com.zero.spring_boot_file_upload.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author ：Zero
 * @date ：Created in 2019/6/25 22:00
 * @modified By：
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MultipartException.class)
    public String handleError1 (MultipartException e, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message",e.getCause().getMessage());
        return "redirect:/uploadStatus";
    }

}
