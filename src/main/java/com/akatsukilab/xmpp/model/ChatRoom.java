package com.akatsukilab.xmpp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
public class ChatRoom implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @JsonProperty
    public long id;
    public String roomName;
    public String naturalName;
    public String description;
    public String subject;
    public Date creationDate;
    public Date modificationDate;
    public String maxUsers;
    public String persistent;
    public String publicRoom;
    public String registrationEnabled;
    public String canAnyoneDiscoverJID;
    public String canOccupantsChangeSubject;
    public String canOccupantsInvite;
    public String canChangeNickname;
    public String logEnabled;
    public String loginRestrictedToNickname;
    public String membersOnly;
    public String moderated;
    public List<String> broadcastPresenceRoles;
    public List<String> owners;
    public List<String> admins;
    public List<String>  members;
    public List<String>  outcasts;
    
}
