package com.hft.product.service.serviceImpl;

import com.hft.product.entity.Product;
import com.hft.product.entity.ProductImage;
import com.hft.product.properties.DocumentPath;
import com.hft.product.repository.ProductImageRepository;
import com.hft.product.repository.ProductRepository;
import com.hft.product.request.ProductRequest;
import com.hft.product.service.IProductService;
import com.hft.product.utils.CommonUtils;
import com.hft.product.utils.UploadDocumentsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    UploadDocumentsUtils uploadDocumentsUtils;
    @Autowired
    ProductImageRepository productImageRepository;

    @Autowired
    DocumentPath documentPath;

    @Override
    public Mono<Void> createSellRequest(ProductRequest pr) {
        Product product = new Product(
                pr.getDescription(),
                pr.getPrize(),
                CommonUtils.getCondition(pr.getCondition()),
                CommonUtils.getCategory(pr.getCategory()),
                CommonUtils.getSubCategory(pr.getSubCategory()),
                CommonUtils.getBrand(pr.getBrand()),
                pr.getUserId(),
                CommonUtils.getSize(pr.getSize()),
                CommonUtils.getColor(pr.getColor())
        );

        // Save the product and process images
        return productRepository.save(product)
                .flatMap(savedProduct -> {
                    // Process files and save images
                    Flux<ProductImage> imageFlux = Flux.fromArray(pr.getFiles())
                            .filter(file -> !file.isEmpty())
                            .map(file -> {
                                String filePath = uploadDocumentsUtils.uploadDocuments(file, documentPath.getProductImages(), savedProduct.getBrand().name());
                                String[] parts = filePath.split("/");
                                String fileName = parts[parts.length - 1];
                                return new ProductImage(filePath, fileName, savedProduct.getId().toString(),pr.getUserId().toString(), LocalDateTime.now());
                            })
                            .flatMap(productImage -> productImageRepository.save(productImage)); // Save each ProductImage

                    return imageFlux.then(); // Return a Mono<Void> indicating completion
                });

    }
}
