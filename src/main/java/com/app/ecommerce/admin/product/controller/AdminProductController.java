package com.app.ecommerce.admin.product.controller;

import com.app.ecommerce.admin.product.controller.dto.AdminProductDto;
import com.app.ecommerce.admin.product.controller.dto.UploadResponse;
import com.app.ecommerce.admin.product.model.AdminProduct;
import com.app.ecommerce.admin.product.service.AdminProductImageService;
import com.app.ecommerce.admin.product.service.AdminProductService;
import com.github.slugify.Slugify;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static com.app.ecommerce.admin.product.mapper.AdminProductMapper.mapAdminProduct;

@RestController
@RequiredArgsConstructor
public class AdminProductController {

    public static final Long EMPTY_ID = null;
    private final AdminProductService adminProductService;
    private final AdminProductImageService productImageService;

    @GetMapping("/admin/products")
    public Page<AdminProduct> getProducts(Pageable pageable){
        return adminProductService.getProducts(pageable);
    }


    @GetMapping("/admin/products/{id}")
    public AdminProduct getProduct(@PathVariable Long id){
    return adminProductService.getProduct(id);
    }


    @PostMapping("/admin/products")
    public AdminProduct createProduct(@RequestBody @Valid AdminProductDto adminProductDto){
        return adminProductService.createProduct(mapAdminProduct(EMPTY_ID, adminProductDto)
        );
    }


    @PutMapping("/admin/products/{id}")
    public AdminProduct updateProduct(@PathVariable Long id, @RequestBody @Valid AdminProductDto adminProductDto ){
        return adminProductService.updateProduct(mapAdminProduct(id, adminProductDto)
        );
    }

    @DeleteMapping("/admin/products/{id}")
    public void deleteProduct(@PathVariable Long id){
        adminProductService.deleteProduct(id);
    }


    @PostMapping("/admin/products/upload-image")
    public UploadResponse uploadImage(@RequestParam("file") MultipartFile multipartFile){
        try(InputStream inputStream = multipartFile.getInputStream()) {
            String savedFileName = productImageService.uploadImage(multipartFile.getOriginalFilename(), inputStream);
            return new UploadResponse(savedFileName);
        } catch (IOException e) {
            throw new RuntimeException("Coś poszło źle podczas wgrywania pliku", e);
        }
    }

    @GetMapping("/data/productImage/{filename}")
    public ResponseEntity<Resource> serveFiles(@PathVariable String filename) throws IOException {
        Resource file = productImageService.serveFiles(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, Files.probeContentType(Path.of(filename)))
                .body(file);
    }


}
