package com.example.nadahassanplatform.utils;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PaginationUtils {

  private static final int DEFAULT_PAGINATION_SIZE = 20;
  public static final String DEFAULT_PAGINATION_ORDER_BY = "createdDate";

  public static Pageable buildPageable(
      final Integer pageNumber, final Integer size, final String orderBy, final String direction) {
    return PageRequest.of(
        pageNumber != null ? pageNumber : 0,
        size != null ? size : DEFAULT_PAGINATION_SIZE,
        buildSort(orderBy, direction));
  }

  public static Sort buildSort(final String orderBy, final String direction) {
    Sort.Direction sortDirection = Sort.Direction.DESC;
    if (direction != null && direction.equals("asc")) {
      sortDirection = Sort.Direction.ASC;
    }
    return Sort.by(sortDirection, orderBy != null ? orderBy : DEFAULT_PAGINATION_ORDER_BY);
  }

  public static PageDTO buildPageDTO(final ModelMapper modelMapper, final Page<?> page) {
    final PageDTO pageDto =
        PageDTO.builder()
            .empty(page.isEmpty())
            .first(page.isFirst())
            .last(page.isLast())
            .number(page.getNumber())
            .numberOfElements(page.getNumberOfElements())
            .size(page.getSize())
            .totalElements(page.getTotalElements())
            .totalPages(page.getTotalPages())
            .sort(modelMapper.map(page.getSort(), SortDTO.class)).build();

    if (page.getPageable().isPaged())
      pageDto.setPageable(modelMapper.map(page.getPageable(), PageableDTO.class));

    return pageDto;
  }
}
