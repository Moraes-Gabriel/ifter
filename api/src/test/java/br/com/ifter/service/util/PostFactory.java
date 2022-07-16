package br.com.ifter.service.util;

import br.com.ifter.model.CategoryPost;
import br.com.ifter.model.Post;

import java.util.ArrayList;

public class PostFactory {

    public static Post get() {
        return getBuilder().build();
    }

    public static Post.PostBuilder getBuilder() {
        return Post.builder()
                .id(1L)
                .description("O andre e muito bonito")
                .category(CategoryPost.PUBLIC)
                .posts(new ArrayList<Post>());
    }
}
