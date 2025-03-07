package com.anonarticle.dto;

import lombok.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageRequestDTO {
    @Builder.Default
    private int no = 1;

    @Builder.Default
    private int page = 1;

    @Builder.Default
    private int size = 5;


    public Pageable getPageable(String sort) {
        return PageRequest.of(this.page - 1, this.size, Sort.by(sort).descending());
    }
}
