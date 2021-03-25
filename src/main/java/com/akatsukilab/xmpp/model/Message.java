package com.akatsukilab.xmpp.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class Message implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public String to;
    public String from;
    public String type;
    public String body;
    public Date delay_stamp;
    public String delay_from;
}
