package com.mycompany.entites;

import java.math.BigDecimal;
import java.time.LocalDate;


public class Article extends BaseEntity{
    private Category category;

    private LocalDate validFrom = LocalDate.now();

    private LocalDate validTo = LocalDate.MAX;

    private String name;

    private String imageUrl;

    private BigDecimal price;

    private String description;
}
