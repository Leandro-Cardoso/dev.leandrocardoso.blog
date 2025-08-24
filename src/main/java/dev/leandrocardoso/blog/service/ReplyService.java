package dev.leandrocardoso.blog.service;

import dev.leandrocardoso.blog.model.Reply;
import dev.leandrocardoso.blog.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyService {

    private final ReplyRepository replyRepository;

    @Autowired
    public ReplyService(ReplyRepository replyRepository) {
        this.replyRepository = replyRepository;
    }

    public List<Reply> getAllReplies() {
        return this.replyRepository.findAll();
    }

}
