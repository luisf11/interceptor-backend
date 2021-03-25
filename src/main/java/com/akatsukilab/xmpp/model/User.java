package com.akatsukilab.xmpp.model;
import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class User implements Serializable{
    /**
     *
     */
    
    private static final long serialVersionUID = 1L;
@JsonProperty
    public long id;
    public String username;
    public String password;
    public String name;
    public String email;
    // public Properties properties;
}
