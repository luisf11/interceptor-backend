package com.akatsukilab.xmpp.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Property implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public String key;
    public String value;

    
}
