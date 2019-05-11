package bupt.coder.commentmicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Comment")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @PutMapping
    public void add(@RequestBody Comment comment) {
        commentRepository.saveAndFlush(comment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        Comment comment = commentRepository.findById(id).get();
        commentRepository.delete(comment);
    }

    @PostMapping("/{id}")
    public void update(@RequestBody Comment comment, @PathVariable long id) {
        Comment old = commentRepository.findById(id).get();
        old.setAuthor(comment.getAuthor());
        old.setDate(comment.getDate());
        old.setMessage(comment.getMessage());
        commentRepository.saveAndFlush(old);
    }

    @GetMapping("/{id}")
    public Comment find(@PathVariable long id) {
        return commentRepository.findById(id).get();
    }


    @GetMapping
    public List<Comment> findAll(){
        return commentRepository.findAll();
    }
}
