package hr.java.spring.boot.Example.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HardwareDTO {
    @NotBlank(message = "Hardware name cannot be blank")
    private String hardwareName;

    @NotBlank(message = "Hardware description cannot be blank")
    private String hardwareDescription;

    @DecimalMin(value = "0.0", message = "Hardware price must be positive")
    private BigDecimal hardwarePrice;

    @NotBlank(message = "Category name cannot be blank")
    private String categoryName;
}
