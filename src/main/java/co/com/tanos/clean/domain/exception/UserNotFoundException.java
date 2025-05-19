package co.com.tanos.clean.domain.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserNotFoundException extends RuntimeException{

    private ExceptionDetail details;
    private int status;

    public UserNotFoundException(String message, Throwable e, ExceptionDetail detail){
        super(message, e);
        setDetails(detail);
    }

    public UserNotFoundException(String message, ExceptionDetail detail, ExceptionDetail details, int status){
        super(message);
        this.status = status;
        setDetails(detail);
    }

    public UserNotFoundException(Long userId) {
        super(String.format("User with id %s not found", userId));
    }

    public UserNotFoundException() {
        super("User with id %s not found");
    }

}
