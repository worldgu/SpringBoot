package com.zero.spring_boot_file_upload.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author ：Zero
 * @date ：Created in 2019/6/25 21:43
 * @modified By：
 */
@Controller
public class UploadController {
    private static String UPLOADED_FOLDER = "E://";

    @GetMapping("/")
    public String index() {
        return "upload";
    }

    @GetMapping("/more")
    public String uploadMore() {
        return "uploadMore";
    }

    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStaus";
        }
        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            // UPLOADED_FOLDER 文件本地存储地址
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/uploadStatus";
    }

    @PostMapping("/uploadMore")
    public String moreFileUpload(@RequestParam("file") MultipartFile[] files,
                                 RedirectAttributes redirectAttributes) {
        if (files.length == 0) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }
        for (MultipartFile file : files) {
            try {
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
                Files.write(path, bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        redirectAttributes.addFlashAttribute("message", "You successfully uploaded all");
        return "redirect:/uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }
}
