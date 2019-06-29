package com.zero.repository;

import com.zero.model.Message;

import java.util.List;

/**
 * @author ：Zero
 * @date ：Created in 2019/6/27 21:40
 * @modified By：
 */
public interface MessageRepository {

    List<Message> findAll();

    Message save(Message message);

    Message update(Message message);

    Message updateText(Message message);

    Message findMessage(Long id);

    void deleteMessage(Long id);


}
