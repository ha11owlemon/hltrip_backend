package com.hall.Controller;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@RestController
public class pdfController {

    @PostMapping("/uploadPdf")
    public ResponseEntity<String> uploadPdf(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty() || !file.getOriginalFilename().endsWith(".pdf")) {
            return new ResponseEntity<>("Invalid file. Please upload a PDF file.", HttpStatus.BAD_REQUEST);
        }

        try {
            // Save the uploaded PDF file to a temporary location
            Path tempDir = Files.createTempDirectory("");
            Path tempFile = tempDir.resolve(file.getOriginalFilename());
            Files.write(tempFile, file.getBytes());

            // Convert PDF to JPG
            PDDocument document = PDDocument.load(tempFile.toFile());
            PDFRenderer pdfRenderer = new PDFRenderer(document);
            for (int page = 0; page < document.getNumberOfPages(); page++) {
                BufferedImage bim = pdfRenderer.renderImageWithDPI(page, 300);
                File outputfile = new File(tempDir.toFile(), "page-" + page + ".jpg");
                ImageIO.write(bim, "jpg", outputfile);
            }
            document.close();

            // Create a ZIP file containing all JPG files
            String zipFileName = "images.zip"; // 使用相对路径
            try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(tempDir.resolve(zipFileName).toString()))) {
                File[] jpgFiles = tempDir.toFile().listFiles((dir, name) -> name.endsWith(".jpg"));
                if (jpgFiles != null) {
                    for (File jpgFile : jpgFiles) {
                        ZipEntry zipEntry = new ZipEntry(jpgFile.getName());
                        zos.putNextEntry(zipEntry);
                        Files.copy(jpgFile.toPath(), zos);
                        zos.closeEntry();
                    }
                }
            }

            // Construct the download URL for the ZIP file
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path("/download/")
                    .path(tempDir.getFileName().toString())
                    .path("/images.zip")
                    .toUriString();

            return new ResponseEntity<>(fileDownloadUri, HttpStatus.OK);

        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("An error occurred while processing the PDF file.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/download/{directory}/{filename:.+}")
    public void downloadFile(@PathVariable String directory, @PathVariable String filename, HttpServletResponse response) {
        try {
            Path filePath = Paths.get(System.getProperty("java.io.tmpdir")).resolve(directory).resolve(filename);
            File file = filePath.toFile();
            if (file.exists()) {
                response.setContentType("application/octet-stream");
                response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
                response.setHeader("Content-Length", String.valueOf(file.length()));

                InputStream inputStream = new FileInputStream(file);
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    response.getOutputStream().write(buffer, 0, bytesRead);
                }
                response.getOutputStream().flush();
                inputStream.close();
            } else {
                response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

}
