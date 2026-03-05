package hr.java.spring.boot.Example.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
public class SearchHardware extends Hardware {

    private BigDecimal lowerPrice;
    private BigDecimal upperPrice;

    public SearchHardware(Long id,
                         String name,
                         String description,
                         BigDecimal lowerPrice,
                         BigDecimal upperPrice,
                         Category category)
    {
        this(name, description, lowerPrice, upperPrice, category);
        super.setId(id);
    }

    public SearchHardware(String name,
                         String description,
                         BigDecimal lowerPrice,
                         BigDecimal upperPrice,
                         Category categoryName)
    {
        super.setName(name);
        super.setDescription(description);
        this.lowerPrice = lowerPrice;
        this.upperPrice = upperPrice;
        super.setCategory(categoryName);
    }

}
