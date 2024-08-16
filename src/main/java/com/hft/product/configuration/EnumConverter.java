package com.hft.product.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.r2dbc.convert.R2dbcCustomConversions;
import org.springframework.stereotype.Component;
import com.hft.product.enums.*;


import java.util.Arrays;

@Component
public class EnumConverter {

    @Bean
    public R2dbcCustomConversions customConversions() {
        return new R2dbcCustomConversions(Arrays.asList(
                new ConditionToStringConverter(),
                new StringToConditionConverter(),
                new CategoryToStringConverter(),
                new StringToCategoryConverter(),
                new SubCategoryToStringConverter(),
                new StringToSubCategoryConverter(),
                new BrandToStringConverter(),
                new StringToBrandConverter(),new ProdStatusToStringConverter(),
                new StringToProdStatusConverter(),new ApprovalStatusToStringConverter(),
                new StringToApprovalStatusConverter(),
                new SizeToStringConverter(),
                new StringToSizeConverter(),new ColourToStringConverter(),
                new StringToColourConverter()


        ));
    }

    // Converter for Condition enum
    public static class ConditionToStringConverter implements Converter<Condition, String> {
        @Override
        public String convert(Condition source) {
            return source.name();
        }
    }

    public static class StringToConditionConverter implements Converter<String, Condition> {
        @Override
        public Condition convert(String source) {
            return Condition.valueOf(source);
        }
    }

    // Repeat for other enums

    // Converter for Category enum
    public static class CategoryToStringConverter implements Converter<Category, String> {
        @Override
        public String convert(Category source) {
            return source.name();
        }
    }

    public static class StringToCategoryConverter implements Converter<String, Category> {
        @Override
        public Category convert(String source) {
            return Category.valueOf(source);
        }
    }

    // Converter for SubCategory enum
    public static class SubCategoryToStringConverter implements Converter<SubCategory, String> {
        @Override
        public String convert(SubCategory source) {
            return source.name();
        }
    }

    public static class StringToSubCategoryConverter implements Converter<String, SubCategory> {
        @Override
        public SubCategory convert(String source) {
            return SubCategory.valueOf(source);
        }
    }

    // Converter for Brand enum
    public static class BrandToStringConverter implements Converter<Brand, String> {
        @Override
        public String convert(Brand source) {
            return source.name();
        }
    }

    public static class StringToBrandConverter implements Converter<String, Brand> {
        @Override
        public Brand convert(String source) {
            return Brand.valueOf(source);
        }
    }

    // Converter for ProdStatus enum
    public static class ProdStatusToStringConverter implements Converter<ProdStatus, String> {
        @Override
        public String convert(ProdStatus source) {
            return source.name();
        }
    }

    public static class StringToProdStatusConverter implements Converter<String, ProdStatus> {
        @Override
        public ProdStatus convert(String source) {
            return ProdStatus.valueOf(source);
        }
    }

    // Converter for ApprovalStatus enum
    public static class ApprovalStatusToStringConverter implements Converter<ApprovalStatus, String> {
        @Override
        public String convert(ApprovalStatus source) {
            return source.name();
        }
    }

    public static class StringToApprovalStatusConverter implements Converter<String, ApprovalStatus> {
        @Override
        public ApprovalStatus convert(String source) {
            return ApprovalStatus.valueOf(source);
        }
    }

    // Converter for Size enum
    public static class SizeToStringConverter implements Converter<Size, String> {
        @Override
        public String convert(Size source) {
            return source.name();
        }
    }

    public static class StringToSizeConverter implements Converter<String, Size> {
        @Override
        public Size convert(String source) {
            return Size.valueOf(source);
        }
    }

    // Converter for Colour enum
    public static class ColourToStringConverter implements Converter<Colour, String> {
        @Override
        public String convert(Colour source) {
            return source.name();
        }
    }

    public static class StringToColourConverter implements Converter<String, Colour> {
        @Override
        public Colour convert(String source) {
            return Colour.valueOf(source);
        }
    }
}
