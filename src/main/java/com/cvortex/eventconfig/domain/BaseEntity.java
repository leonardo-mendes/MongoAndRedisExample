package com.cvortex.eventconfig.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class BaseEntity implements Serializable {

    @JsonIgnore
    private LocalDateTime creationDate;

    @JsonIgnore
    private String creationUser;

    @JsonIgnore
    private String lastUpdateUser;
}
