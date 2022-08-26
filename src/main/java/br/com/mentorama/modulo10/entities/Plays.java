package br.com.mentorama.modulo10.entities;

import com.sun.tools.javac.util.JCDiagnostic;
import com.sun.tools.javap.TypeAnnotationWriter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Plays {

    @Id
    private String playId;

    private String spectatorId;

    private String playName;

    private Note note;

    public Plays(){}

    public Plays(String playId, String spectatorId, String playName, Note note, String comment) {
        this.playId = playId;
        this.spectatorId = spectatorId;
        this.playName = playName;
        this.note = note;
        this.comment = comment;
    }

    public String getPlayId() {
        return playId;
    }

    public void setPlayId(String playId) {
        this.playId = playId;
    }

    public String getSpectatorId() {
        return spectatorId;
    }

    public void setSpectatorId(String spectatorId) {
        this.spectatorId = spectatorId;
    }

    public String getPlayName() {
        return playName;
    }

    public void setPlayName(String playName) {
        this.playName = playName;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    private String comment;
}
