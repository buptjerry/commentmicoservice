package bupt.coder.commentmicroservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class CommentMicroserviceApplication {

    @Bean
    @Profile("create")
    CommandLineRunner init(CommentRepository commentRepository) {
        return args -> {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse("2019-05-11");
            Comment comment = new Comment("搞毕设好累啊", date, "TheShy");
            Comment comment2 = new Comment("突然感觉自己不能适应996了", date, "Facker");
            Comment comment3 = new Comment("好想进体制内", date, "Uzi");
            Comment comment4 = new Comment("体制内少钱呀", date, "Doinb");
            Comment comment5 = new Comment("感觉生命更重要", date, "Rookie");
            commentRepository.save(comment);
            commentRepository.save(comment2);
            commentRepository.save(comment3);
            commentRepository.save(comment4);
            commentRepository.save(comment5);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(CommentMicroserviceApplication.class, args);
    }

}
