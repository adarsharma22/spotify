package com.evaluation.userPlaylist.repository;

import com.evaluation.userPlaylist.model.UserPlaylist;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlayListRepository extends MongoRepository<UserPlaylist,String> {
}
