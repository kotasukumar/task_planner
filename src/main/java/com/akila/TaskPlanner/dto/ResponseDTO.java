package com.akila.TaskPlanner.dto;

import lombok.*;

@AllArgsConstructor(staticName = "Build")
@NoArgsConstructor
@Getter
@Setter
@Data
public class ResponseDTO {
    public Object data;
    public String message;
}
