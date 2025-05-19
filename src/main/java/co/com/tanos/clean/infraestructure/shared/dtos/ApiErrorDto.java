package co.com.tanos.clean.infraestructure.shared.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ApiErrorDto {

    private int status;
    private String message;
    private List<String> errors;

    public ApiErrorDto(int status, String message, List<String> errors ){
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public ApiErrorDto(int status, String message ){
        this.status = status;
        this.message = message;
    }
}
