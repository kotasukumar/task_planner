package com.akila.TaskPlanner.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@AllArgsConstructor(staticName = "Build")
@NoArgsConstructor
@Entity
@Table(name = "task_planner")
@Getter
@Setter
@Data
public class TaskEntity {
    @Id
    @Column(name = "s_no", nullable = false)
    @GeneratedValue
    private int sNo;
    private int taskId;
    private String title;
    private String description;
    private String createdBy;
    private Date createdOn;
    private String assignedTo;
    private Date completedOn;
    private String status;
}
