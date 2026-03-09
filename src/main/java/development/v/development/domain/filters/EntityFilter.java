package development.v.development.domain.filters;

import development.v.development.domain.dtos.PaginationDto;

public class EntityFilter {

    private PaginationDto pagination;
    private java.util.Map<String, Object> filters;

    public EntityFilter(PaginationDto pagination) {
        this.pagination = pagination;
        this.filters = new java.util.HashMap<>();
    }

    public EntityFilter addFilter(String key, Object value) {
        if (value != null) filters.put(key, value);
        return this;
    }

    public PaginationDto getPagination() { return pagination; }
    public java.util.Map<String, Object> getFilters() { return filters; }

}