package com.recyclebookstore.demo.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="token_info")
public class TokenInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long token_id;
    private Long user_id;
    private String token_str;
    private Date deadline;

    public Long getToken_id() {
        return token_id;
    }

    public void setToken_id(Long token_id) {
        this.token_id = token_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getToken_str() {
        return token_str;
    }

    public void setToken_str(String token_str) {
        this.token_str = token_str;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}
