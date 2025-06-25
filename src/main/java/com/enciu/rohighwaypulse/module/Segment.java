package com.enciu.rohighwaypulse.module;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Segment {
    private String name;
    private Integer length;
    private String status;
    private String contractor;
    private Integer estimatedCompletionYear;
}
