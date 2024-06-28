package sust.el_muro.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sust.el_muro.daos.CommentsDao;
import sust.el_muro.models.Comment;
import sust.el_muro.models.CommentRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api")
public class CommentRestController {

  @Autowired
  CommentsDao commentDao;

  @GetMapping("/messages/{message_id}/comments")
  public List<Comment> getAll(@PathVariable Long message_id) {
    List<Comment> comments = commentDao.getCommentsFromMessage(message_id);

    return comments;
  }

}