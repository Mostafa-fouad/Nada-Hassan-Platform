package com.example.nadahassanplatform.products.util;

import com.example.nadahassanplatform.core.exception.NotFoundException;
import com.example.nadahassanplatform.products.model.Product.Category;

import java.util.LinkedHashMap;
import java.util.List;

public class CategoryCodeMapper {

    private static final LinkedHashMap<Integer, Category> CATEGORY_CODES_MAPPING = new LinkedHashMap<>();

   static  {

        initializeCategoryCodeMap();
    }
    private static void initializeCategoryCodeMap() {

        CATEGORY_CODES_MAPPING.put(1, Category.SKIRTS);
        CATEGORY_CODES_MAPPING.put(2, Category.PANTS);
        CATEGORY_CODES_MAPPING.put(3, Category.DRESSES);
        CATEGORY_CODES_MAPPING.put(4, Category.JACKETS);
        CATEGORY_CODES_MAPPING.put(5, Category.SWEATSHIRTS);
        CATEGORY_CODES_MAPPING.put(6, Category.TOPS);
        CATEGORY_CODES_MAPPING.put(7, Category.SETS);
        CATEGORY_CODES_MAPPING.put(8, Category.OTHERS);
    }
    public static Category getCategory(final int categoryCode) {

        if(categoryCodeIsNotExist(categoryCode)) {

            throw new NotFoundException(String.format("Category with code %s is not found", categoryCode));
        }

        return CATEGORY_CODES_MAPPING.get(categoryCode);
    }

    public static List<Category> getAllCategories() {

        return CATEGORY_CODES_MAPPING.keySet().stream().map(CATEGORY_CODES_MAPPING::get).toList();
    }

    private static boolean categoryCodeIsNotExist(final int categoryCode) {
        return categoryCode < 1 || categoryCode > 8;
    }
}