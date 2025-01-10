package com.anonarticle.dto;

import lombok.*;
import org.springframework.data.domain.Page;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PageResponseDTO {
    private List<AnonArticleDTO> dtoList;

    private int pg;
    private int size;
    private int total;
    private int startNo;
    private int start, end;
    private boolean prev, next;


    @Builder
    public PageResponseDTO(Page<AnonArticleDTO> anonArticleDTOPage) {
        this.pg = anonArticleDTOPage.getPageable().getPageNumber()+1;
        this.size = anonArticleDTOPage.getSize();
        this.total = (int)anonArticleDTOPage.getTotalElements();
        this.dtoList = anonArticleDTOPage.getContent();


        this.startNo = total - ((pg - 1) * size);
        this.end = (int) (Math.ceil(this.pg / 10.0)) * 10;
        this.start = this.end - 9;

        int last = (int) (Math.ceil(total / (double)size));
        this.end = end > last ? last : end;     //40 > 33 ? end =33 : end = 40
        this.prev = this.start > 1;
        this.next = total > this.end * this.size;

    }

}
