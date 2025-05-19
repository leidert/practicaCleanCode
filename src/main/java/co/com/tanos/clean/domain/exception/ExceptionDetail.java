package co.com.tanos.clean.domain.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ExceptionDetail {
    private String userMessage;
    private String severity;
}
