package com.akila.TaskPlanner.dto;

import lombok.*;

import java.sql.Date;

@AllArgsConstructor(staticName = "Build")
@NoArgsConstructor
@Getter
@Setter
@Data
public class UpdateDTO {
    public int sNo;
    public int taskId;
    public String title;
    public String description;
    public String createdBy;
    public Date createdOn;
    public String status;
}
