package hr.java.spring.boot.Example.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@Setter
@Getter
public class SearchHardwareDTO extends HardwareDTO {

    private BigDecimal lowerPrice;
    private BigDecimal upperPrice;

    public SearchHardwareDTO(String hardwareName,
                            String hardwareDescription,
                            BigDecimal lowerPrice,
                            BigDecimal upperPrice,
                            String categoryName) {
        super.setHardwareName(hardwareName);
        super.setHardwareDescription(hardwareDescription);
        this.lowerPrice = lowerPrice;
        this.upperPrice = upperPrice;
        super.setCategoryName(categoryName);
    }
    
}
