package com.hft.product.entity;

import com.hft.product.dto.ProductDTO;
import com.hft.product.enums.*;
import com.hft.product.utils.CommonUtils;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.IOException;
import java.math.BigDecimal;

@Table("product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class Product {

    @Id
    String id;
    String description;
    BigDecimal prize;
    Condition condition ;
    Category category = Category.UNISEX;
    SubCategory subCategory = SubCategory.OTHERS;
    Brand brand;
    Long sellerId;
    ProdStatus prodStatus = ProdStatus.IN_STOCK;
    ApprovalStatus approvalStatus = ApprovalStatus.PENDING;
    Size size  = Size.FREE_SIZE;
    Colour colour = Colour.OTHER;




    public Product(String description, BigDecimal prize, Condition condition, Category category, SubCategory subCategory, Brand brand, Long sellerId, Size size,Colour colour) {
        this.description = description;
        this.prize = prize;
        this.condition = condition;
        this.category = category;
        this.subCategory = subCategory;
        this.brand = brand;
        this.sellerId = sellerId;
        this.size= size;
        this.colour = colour;
    }

    public ProductDTO getProductDTO() throws IOException {
        return  new ProductDTO(id, description,prize, CommonUtils.getEnumMap(condition.name(),condition.value()),CommonUtils.getEnumMap(category.name(),category.value()) ,CommonUtils.getEnumMap(subCategory.name(),subCategory.value()),CommonUtils.getEnumMap(brand.name(),brand.value()),sellerId,CommonUtils.getEnumMap(prodStatus.name(),prodStatus.value()),CommonUtils.getEnumMap(approvalStatus.name(),approvalStatus.value()) ,CommonUtils.getEnumMap(size.name(),size.value()), CommonUtils.getEnumMap(colour.name(),colour.value()),CommonUtils.getProductImages(id));
    }
}
