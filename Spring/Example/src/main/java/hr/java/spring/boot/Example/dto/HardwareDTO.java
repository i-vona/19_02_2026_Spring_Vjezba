package hr.java.spring.boot.Example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HardwareDTO {
    private String hardwareName;
    private String hardwareDescription;
    private BigDecimal hardwarePrice;
    private String categoryName;
}
