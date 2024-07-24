package com.meditrack.meditrack.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@MappedSuperclass
@Getter
public class CommonEntityColumns {

    private String gender ;
    private String emailAddress ;
    private String password ;
}
