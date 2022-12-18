package com.fed.commerce.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.util.StringUtils;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link User} entity
 */
@Data
public class UserDto implements Serializable {
    @Size(max = 45)
    @JsonProperty("user_id")
    private String userId;
    @Size(max = 45)
    private String password;

    public boolean checkLoginFields() {
        return StringUtils.hasText(this.userId) && StringUtils.hasText(this.password);
    }


}