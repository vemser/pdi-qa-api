package model.responses;

import model.pagination.Pageable;
import model.pagination.Sort;
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