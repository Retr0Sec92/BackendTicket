package com.felece.felece_case.Models.Search;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class BusSearch {
    private String arrival;
    private String departure;
}
