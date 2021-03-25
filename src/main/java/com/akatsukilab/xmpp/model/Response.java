package com.akatsukilab.xmpp.model;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class Response implements Serializable{

    private List<User> data;
    private  int total;
    
}
