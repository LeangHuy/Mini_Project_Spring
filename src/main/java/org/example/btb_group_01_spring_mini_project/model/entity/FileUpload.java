package org.example.btb_group_01_spring_mini_project.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FileUpload {
    private String fileName;
    private String fileUrl;
    private String fileType;
    private Long fileSize;
}
