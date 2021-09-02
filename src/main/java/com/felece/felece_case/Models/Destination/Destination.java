package com.felece.felece_case.Models.Destination;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "destinations")
@Builder
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Destination {
    @Id
    private  String id;
    private  String start;
    private  String finish;
    private  List<String> stations;
}
