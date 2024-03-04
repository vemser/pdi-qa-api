package com.pdi.tests.model.responses;

import com.pdi.tests.model.pagination.Pageable;
import com.pdi.tests.model.pagination.Sort;
import java.util.ArrayList;

public class BaseResponse {
    public ArrayList<Object> content;
    public Pageable pageable;
    public Boolean last;
    public Integer totalPages;
    public Integer totalElements;
    public Integer size;
    public Integer number;
    public Sort sort;
    public Boolean first;
    public Integer numberOfElements;
    public Boolean empty;
}