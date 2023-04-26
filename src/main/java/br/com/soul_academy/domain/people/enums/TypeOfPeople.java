package br.com.soul_academy.domain.people.enums;

import lombok.Getter;

@Getter
public enum TypeOfPeople {
    ACADEMIA(1),
    PERSONAL(2),
    ALUNO(3);

    private final Integer code;

    TypeOfPeople(Integer code) {
        this.code = code;
    }
}
