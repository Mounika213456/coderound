package com.coderound;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class IncomeTaxRequest {

    @JsonProperty("employeeid")
    private int employeeid;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("email")
    private String email;
    @JsonProperty("phoneNumber")
    private BigDecimal phoneNumber;
    @JsonProperty("doj")
    private date doj;
    @JsonProperty("salary")
    private double salary ;
}
