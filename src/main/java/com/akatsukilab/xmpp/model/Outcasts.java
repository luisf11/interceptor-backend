package com.akatsukilab.xmpp.model;
import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class Outcasts implements Serializable{
    public List<String> outcast;
}
