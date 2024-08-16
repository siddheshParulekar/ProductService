package com.hft.product.repository;

import com.hft.product.entity.ProductImage;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface ProductImageRepository extends ReactiveCrudRepository<ProductImage,String> {

    Flux<ProductImage> findByProductId(String productId);
}
