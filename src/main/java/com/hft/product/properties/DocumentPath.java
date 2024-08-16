package com.hft.product.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.annotation.PostConstruct;

@Data
@Validated
@ConfigurationProperties("hft.document-path")
@Component
public class DocumentPath {

    private String basePath;
    private String productImages;


    @PostConstruct
    public void setBasePath(){
        productImages = getBasePath().concat(getProductImages());

    }
}
