package com.hft.product.service;

import com.hft.product.request.ProductRequest;
import reactor.core.publisher.Mono;

public interface IProductService {

    Mono<Void> createSellRequest(ProductRequest productRequest);
}
