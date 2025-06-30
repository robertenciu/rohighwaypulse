package com.enciu.rohighwaypulse.module;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    private String description;
    private String status;
    private Float length;
    private Float completedLength;
    private Integer estimatedCompletionYear;
    private String totalBudget;
    private String fundingSource;
    private List<Segment> segments;
    private String startCity;
    private String endCity;
    @JsonProperty("percentageCompleted")
    public Float getPercentageCompleted() {
        if (this.length == 0) return 0f;
        return (float) Math.round((this.completedLength / this.length) * 100);
    }
}
