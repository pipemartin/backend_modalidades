package com.ingsoftware.modalidadesapp.Controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api")
public class PdfController {

    /*
    @GetMapping("/getPdf/{pdfFileName}")
    public ResponseEntity<Resource> getPdf(@PathVariable String pdfFileName) {
        // Construye la ruta completa al archivo PDF en tu servidor
        String pdfPath = "C:/AppServ/www/modalidadesapp/src/main/resources/adjuntos/pdf_solicitud/" + pdfFileName; // Reemplaza con la ruta real
        Path path = Paths.get(pdfPath);

        try {
            // Carga el archivo PDF en un recurso
            Resource resource = new UrlResource(path.toUri());

            // Prepara la respuesta HTTP
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=" + resource.getFilename());

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(resource);
        } catch (MalformedURLException e) {
            // Manejar la excepción si la URL del recurso no es válida
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }
    */

    @GetMapping("/getPdf/{pdfRuta}/{pdfFileName}")
    public ResponseEntity<Resource> getPdf(@PathVariable String pdfRuta, @PathVariable String pdfFileName) {
        // Construye la ruta completa al archivo PDF en tu servidor
        String pdfPath = "J:/backend_modalidades-main/src/main/resources/adjuntos/" +pdfRuta+"/"+ pdfFileName; // Reemplaza con la ruta real
        Path path = Paths.get(pdfPath);
        try {
            // Lee los bytes del archivo PDF
            byte[] pdfBytes = Files.readAllBytes(path);

            // Configura las cabeceras de la respuesta
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("inline", pdfFileName);

            // Crea un recurso ByteArrayResource a partir de los bytes del PDF
            ByteArrayResource resource = new ByteArrayResource(pdfBytes);

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(resource);
        } catch (IOException e) {
            // Manejar la excepción si hay un problema al leer el archivo
            e.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @Value("${adjuntos.folder}") // Lee la ruta de la carpeta desde application.properties
    private String adjuntosFolder;

    @PostMapping("/uploadPdf")
    public String uploadPdf(@RequestParam("pdfFile") MultipartFile pdfFile) {
        try {

            // Guarda el archivo en la carpeta "adjuntos"
            Path filePath = Paths.get(adjuntosFolder, pdfFile.getOriginalFilename());
            FileCopyUtils.copy(pdfFile.getBytes(), filePath.toFile());

            return "Archivo PDF guardado con éxito.";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al guardar el archivo PDF.";
        }
    }

    @Value("${adjuntos.emprendimiento}") // Lee la ruta de la carpeta desde application.properties
    private String adjuntosEmprendimiento;

    @PostMapping("/uploadPdfEmprendimiento")
    public String uploadPdfEmprendimiento(@RequestParam("pdfFile") MultipartFile pdfFile) {
        try {

            // Guarda el archivo en la carpeta "adjuntos"
            Path filePath = Paths.get(adjuntosEmprendimiento, pdfFile.getOriginalFilename());
            FileCopyUtils.copy(pdfFile.getBytes(), filePath.toFile());

            return "Archivo PDF guardado con éxito.";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al guardar el archivo PDF.";
        }
    }

    @Value("${adjuntos.postgrado}") // Lee la ruta de la carpeta desde application.properties
    private String adjuntosPostgrado;

    @PostMapping("/uploadPdfPostgrado")
    public String uploadPdfPostgrado(@RequestParam("pdfFile") MultipartFile pdfFile) {
        try {

            // Guarda el archivo en la carpeta "adjuntos"
            Path filePath = Paths.get(adjuntosPostgrado, pdfFile.getOriginalFilename());
            FileCopyUtils.copy(pdfFile.getBytes(), filePath.toFile());

            return "Archivo PDF guardado con éxito.";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al guardar el archivo PDF.";
        }
    }

    @Value("${adjuntos.practica}") // Lee la ruta de la carpeta desde application.properties
    private String adjuntosPractica;

    @PostMapping("/uploadPdfPractica")
    public String uploadPdfPractica(@RequestParam("pdfFile") MultipartFile pdfFile) {
        try {

            // Guarda el archivo en la carpeta "adjuntos"
            Path filePath = Paths.get(adjuntosPractica, pdfFile.getOriginalFilename());
            FileCopyUtils.copy(pdfFile.getBytes(), filePath.toFile());

            return "Archivo PDF guardado con éxito.";
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al guardar el archivo PDF.";
        }
    }
}
