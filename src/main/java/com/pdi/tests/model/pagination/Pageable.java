package com.pdi.tests.model.pagination;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pageable {
    public Sort sort;
    public Integer offset;
    public Integer pageNumber;
    public Integer pageSize;
    public boolean paged;
    public boolean unpaged;
}