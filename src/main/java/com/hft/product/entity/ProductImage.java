package com.hft.product.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@Table("product_image")
public class ProductImage {

    @Id
    private String id;

    @Column("file_path")
    private String filePath;

    @Column("file_name")
    private String filename;

    @Column("product_id")
    private String productId;  // Store the product ID as a reference

    // Auditing fields
    @Column("created_by")
    private String createdBy;

    @Column("creation_date")
    private LocalDateTime creationDate;

    @Column("last_modified_by")
    private String lastModifiedBy;

    @Column("last_modified_date")
    private LocalDateTime lastModifiedDate;

    public ProductImage( String filePath, String filename, String productId, String createdBy, LocalDateTime creationDate) {

        this.filePath = filePath;
        this.filename = filename;
        this.productId = productId;
        this.createdBy = createdBy;
        this.creationDate = creationDate;
    }
}
