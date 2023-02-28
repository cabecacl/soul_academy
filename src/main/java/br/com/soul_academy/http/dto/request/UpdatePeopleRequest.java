package br.com.soul_academy.http.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UpdatePeopleRequest {

    @NotNull
    private Long Id;
    private String name;
    private String registrationNumber;
    private String phoneNumber;
    private String email;
    private String address;
    private String zipCode;
    private Long idCity;
    private String TypeOfPeople;
    private String login;
}
