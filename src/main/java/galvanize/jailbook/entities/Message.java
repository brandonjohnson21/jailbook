package galvanize.jailbook.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "Message")
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "Body_Text", nullable = false)
    private String bodyText;

    @Column(name = "Is_Read", nullable = false)
    private Integer read;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Message_ID", nullable = false)
    private Integer messageId;

    @Column(name = "Message_Timestamp", nullable = false)
    private LocalDateTime messageTimestamp;

    @Column(name = "Recipient", nullable = false)
    private Integer recipient;

    @Column(name = "Sender", nullable = false)
    private Integer sender;

    public Message setBodyText(String bodyText) {
        this.bodyText = bodyText;
        return this;
    }

    public String getBodyText() {
        return bodyText;
    }

    public Message setRead(Integer read) {
        this.read = read;
        return this;
    }

    public Integer getRead() {
        return read;
    }

    public Message setMessageId(Integer messageId) {
        this.messageId = messageId;
        return this;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public Message setMessageTimestamp(LocalDateTime messageTimestamp) {
        this.messageTimestamp = messageTimestamp;
        return this;
    }

    public LocalDateTime getMessageTimestamp() {
        return messageTimestamp;
    }

    public Message setRecipient(Integer recipient) {
        this.recipient = recipient;
        return this;
    }

    public Integer getRecipient() {
        return recipient;
    }

    public Message setSender(Integer sender) {
        this.sender = sender;
        return this;
    }

    public Integer getSender() {
        return sender;
    }

    @Override
    public String toString() {
        return "Message{" +
               "bodyText=" + bodyText + '\'' +
               "read=" + read + '\'' +
               "messageId=" + messageId + '\'' +
               "messageTimestamp=" + messageTimestamp + '\'' +
               "recipient=" + recipient + '\'' +
               "sender=" + sender + '\'' +
               '}';
    }
}
