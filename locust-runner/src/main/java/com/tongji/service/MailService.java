package com.tongji.service;

public interface MailService {
    boolean sendSimpleMail(String to, String subject, String content);
}
