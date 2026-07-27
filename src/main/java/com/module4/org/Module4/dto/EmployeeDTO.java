package com.module4.org.Module4.dto;


import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeDTO {
    private Long id;

    private String name;

    private String email;

    private Integer age;

    private LocalDate dateOfJoining;
//    @Pattern(regexp = "^(ADMIN|USER)$", message = "Role is incorrect")
    private String role;
    private boolean active;      //During serialization and deserialization from Jackson, the isActive was mismatched. Hence we give JsonProperty here to let
                                // Jackson know that the name for this field is isActive
}
