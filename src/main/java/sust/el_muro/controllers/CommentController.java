package sust.el_muro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import sust.el_muro.daos.CommentsDao;

@Controller
public class CommentController {

  @Autowired
  CommentsDao commentDao;

    @PostMapping("/comments")
    public String createComment(@RequestParam Long message_id, @RequestParam Long user_id, @RequestParam String content, RedirectAttributes redAt) {
        System.out.println("mensaje: " + message_id);
        System.out.println("usuario: " + user_id);
        System.out.println("contenido: " + content);

        commentDao.create(message_id,user_id,content);

        redAt.addFlashAttribute("bien", "Comentario Agregado con éxito");
        
        return "redirect:/";
    }

}
