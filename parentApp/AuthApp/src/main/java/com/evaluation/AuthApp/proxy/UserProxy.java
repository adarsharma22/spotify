package com.evaluation.AuthApp.proxy;

import com.evaluation.AuthApp.model.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="user-playlist",url = "localhost:3333")
public interface UserProxy {
    @PostMapping("/playlist-app/v1/add-user")
    public ResponseEntity<?>sendObjToPlaylistApp(@RequestBody UserDTO userDTO);
}
