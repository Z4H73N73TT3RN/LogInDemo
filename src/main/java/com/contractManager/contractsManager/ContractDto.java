package com.contractManager.contractsManager;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContractDto {
    private Long id;
    @NotNull
    private Float price;
    @NotEmpty
    private String telephoneNumber;
    @NotEmpty
    private String customerNumber;
}
