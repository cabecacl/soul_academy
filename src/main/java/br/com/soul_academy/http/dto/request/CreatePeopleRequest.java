package br.com.soul_academy.http.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CreatePeopleRequest {

    @NotNull
    private String name;
    @NotNull
    private String registrationNumber;
    private String phoneNumber;
    private String email;
    private String address;
    private String zipCode;

    @NotNull
    private Long idCity;
    @NotNull
    private String typeOfPeople;
    @NotNull
    private String login;
}
