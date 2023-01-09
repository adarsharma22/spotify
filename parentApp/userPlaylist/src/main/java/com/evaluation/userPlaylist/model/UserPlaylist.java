package com.evaluation.userPlaylist.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document
public class UserPlaylist {
    @Id
    private String emailId;
    private String phone,userName;
    private List<Song> Songs;
}
