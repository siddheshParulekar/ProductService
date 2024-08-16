package com.hft.product.utils;

import com.hft.product.dto.ProdImageDTO;
import com.hft.product.entity.ProductImage;
import com.hft.product.enums.*;
import com.hft.product.exception.InvalidException;
import com.hft.product.repository.ProductImageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;


import java.nio.file.Paths;

@Slf4j
public class CommonUtils {
    private static ProductImageRepository  prodImageRepository;


    @Autowired
    public CommonUtils(
            ProductImageRepository prodImageRepository
                       ){
        CommonUtils.prodImageRepository = prodImageRepository;
    }


    public static Map<String,String> getEnumMap(String name, String value)
    {
        Map<String,String> map = new HashMap<>();
        map.put("name",name);
        map.put("value",value);
        return map;
    }

    public static Condition getCondition(String condition) {
        if (condition == null)
            throw new InvalidException("Condition cannot be null");
        else if (condition.equalsIgnoreCase(Condition.GOOD.name()))
            return Condition.GOOD;
        else if (condition.equalsIgnoreCase(Condition.LIKE_NEW.name()))
            return Condition.LIKE_NEW;
        else if (condition.equalsIgnoreCase(Condition.NEW.name()))
            return Condition.NEW;
        else if (condition.equalsIgnoreCase(Condition.POOR.name()))
            return Condition.POOR;
        else
            throw new InvalidException("Invalid condition type");
    }

    public static Brand getBrand(String brand) {
        if (brand == null)
            return Brand.OTHERS;
        final Map<String, Brand> brandMap = new HashMap<>();
        for (Brand brands : Brand.values()) {
            brandMap.put(brands.name().toLowerCase(), brands);
        }
        String normalizedBrand = brand.trim().toLowerCase();

        Brand resolvedBrand = brandMap.get(normalizedBrand);
        if (resolvedBrand == null) {
            throw new IllegalArgumentException("Invalid brand type");
        }
        return resolvedBrand;
    }

    public static Category getCategory(String category) {
        if (category == null)
            return Category.UNISEX;
        final Map<String, Category> categoryMap = new HashMap<>();
        for (Category category1 : Category.values()) {
            categoryMap.put(category1.name().toLowerCase(), category1);
        }
        String normalizedBrand = category.trim().toLowerCase();

        Category resolvedBrand = categoryMap.get(normalizedBrand);
        if (resolvedBrand == null) {
            throw new IllegalArgumentException("Invalid category type");
        }
        return resolvedBrand;
    }

    public static SubCategory getSubCategory(String subCategory) {
        if (subCategory == null)
            return SubCategory.OTHERS;
        final Map<String, SubCategory> subCategoryMap = new HashMap<>();
        for (SubCategory category1 : SubCategory.values()) {
            subCategoryMap.put(category1.name().toLowerCase(), category1);
        }
        String normalizedBrand = subCategory.trim().toLowerCase();

        SubCategory resolvedBrand = subCategoryMap.get(normalizedBrand);
        if (resolvedBrand == null) {
            throw new IllegalArgumentException("Invalid subCategory type");
        }
        return resolvedBrand;
    }

    public static Size getSize(String size) {
        if (size == null)
            return Size.FREE_SIZE;
        final Map<String, Size> subCategoryMap = new HashMap<>();
        for (Size category1 : Size.values()) {
            subCategoryMap.put(category1.name().toLowerCase(), category1);
        }
        String normalizedBrand = size.trim().toLowerCase();

        Size resolvedBrand = subCategoryMap.get(normalizedBrand);
        if (resolvedBrand == null) {
            throw new IllegalArgumentException("Invalid size type");
        }
        return resolvedBrand;
    }

    public static Colour getColor(String color) {
        if (color == null)
            return Colour.OTHER;
        final Map<String, Colour> subCategoryMap = new HashMap<>();
        for (Colour category1 : Colour.values()) {
            subCategoryMap.put(category1.name().toLowerCase(), category1);
        }
        String normalizedBrand = color.trim().toLowerCase();

        Colour resolvedBrand = subCategoryMap.get(normalizedBrand);
        if (resolvedBrand == null) {
            throw new IllegalArgumentException("Invalid color type");
        }
        return resolvedBrand;
    }


    public Flux<ProdImageDTO> getProductImages(String productId) {
        log.info("ProductImageService - Inside getProductImages method");

        return prodImageRepository.findByProductId(productId)
                .flatMap(this::readImageFile); // Directly map to ProdImageDTO
    }

    private Mono<ProdImageDTO> readImageFile(ProductImage productImage) {
        return Mono.fromCallable(() -> {
            byte[] fileByte = Files.readAllBytes(Paths.get(productImage.getFilePath()));
            return new ProdImageDTO(productImage.getFilename(), fileByte);
        }).subscribeOn(Schedulers.boundedElastic()); // Use boundedElastic for blocking I/O
    }
}
