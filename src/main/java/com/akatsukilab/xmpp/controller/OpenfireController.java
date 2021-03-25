package com.akatsukilab.xmpp.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import javax.websocket.server.PathParam;

import com.akatsukilab.xmpp.model.ChatRooms;
import com.akatsukilab.xmpp.model.Message;
import com.akatsukilab.xmpp.model.Messages;
import com.akatsukilab.xmpp.model.Response;
import com.akatsukilab.xmpp.model.ChatRoom;
import com.akatsukilab.xmpp.model.User;
import com.akatsukilab.xmpp.model.Users;
import com.akatsukilab.xmpp.service.OpenFireRestClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.java.Log;

@Controller
public class OpenfireController {

    @Autowired
    OpenFireRestClient restClient;
    private HashSet<ChatRoom> listofChatRooms = new HashSet<ChatRoom>();
    private HashSet<User> users = new HashSet<User>();
    private HashSet<Message> chats = new HashSet<Message>();

    @GetMapping("users")
    public ResponseEntity<?> getUsers() {
        users.clear();

        Users response = restClient.getEntitie("users", Users.class);
        AtomicInteger my_index = new AtomicInteger();

        List<User> list = response.getUsers();
        list.forEach(user -> {
            user.setId(my_index.getAndIncrement());
            users.add(user);
        });
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("X-Total-Count", String.valueOf(response.getUsers().size()));
        return ResponseEntity.ok().headers(responseHeaders).body(users);

    }

    @GetMapping("users/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") int id) {

        User userFound = users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
        User response = restClient.getEntitie("users/" + userFound.getUsername(), User.class);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @CrossOrigin(origins = {"http://35.174.114.134"})
    @GetMapping("chatrooms")
    public ResponseEntity<?> getChatRooms() {

        listofChatRooms.clear();
        ChatRooms response = restClient.getEntitie("chatrooms", ChatRooms.class);
        AtomicInteger my_index = new AtomicInteger();
        response.getChatRooms().forEach(chat -> {
            chat.setId(my_index.getAndIncrement());
            listofChatRooms.add(chat);
        });
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("X-Total-Count", String.valueOf(response.getChatRooms().size()));
        return ResponseEntity.ok().headers(responseHeaders).body(listofChatRooms);
    }

    @GetMapping("chatrooms/{id}")
    public ResponseEntity<?> getChatRoom(@PathVariable("id") int id) {
        ChatRoom foundChat = listofChatRooms.stream().filter(chat -> chat.getId() == id).findAny().orElse(null);
        Messages response = restClient.getEntitie("chatrooms/" + foundChat.getRoomName() + "/chathistory", Messages.class);
        
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("chats")
    public ResponseEntity<?> getChatByUser(@RequestParam(name = "chatroom") String chatroom,
            @RequestParam(name = "user") String user) {
        return null;
    }
    @CrossOrigin(origins = {"http://35.174.114.134"})
    @GetMapping("chat")
    public ResponseEntity<?> getChatByChatRoom(@RequestParam(name = "chatroom") String chatroom) {
        return new ResponseEntity<>(restClient.getEntitie("chatrooms/" + chatroom + "/chathistory", Messages.class),
                HttpStatus.OK);
    }

}
