package com.enciu.rohighwaypulse.module;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "highways")
@Data
public class Highway {
    @Id
    private String id;
    private String name;
    private String status;
    private Integer length;
    private Integer estimatedCompletionYear;
    private Integer totalBudget;
    private String fundingSource;
    private List<Segment> segments;
}
