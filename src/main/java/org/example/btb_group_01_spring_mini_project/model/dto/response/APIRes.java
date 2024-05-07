package org.example.btb_group_01_spring_mini_project.model.dto.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class APIRes<T> {
    private String message;
    private HttpStatus status;
    private T payload;
}
