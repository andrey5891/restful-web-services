package com.in28minutes.rest.webservices.restfulwebservices.user;

import com.in28minutes.rest.webservices.restfulwebservices.user.exception.NoOnePostFoundException;
import com.in28minutes.rest.webservices.restfulwebservices.user.exception.NoOneUserFoundException;
import com.in28minutes.rest.webservices.restfulwebservices.user.exception.PostNotFoundException;
import com.in28minutes.rest.webservices.restfulwebservices.user.exception.UserNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {

    private static final List<User> users = new ArrayList<>();

    private static final List<Post> posts = new ArrayList<>();

    private static Integer userCount = 3;

    private static Integer postCount = 0;

    static {
        users.add(new User(1, "Adam", new Date()));
        users.add(new User(2, "Eve", new Date()));
        users.add(new User(3, "Jack", new Date()));
    }

    public List<User> findAll() {
        if (users.size() == 0) {
            throw new NoOneUserFoundException("no one user found in DB imitation");
        }
        return users;
    }

    public User savePost(User user) {
        if (user.getId() == null) {
            user.setId(++userCount);
        }
        users.add(user);
        return user;
    }

    public User findOne(Integer id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        throw new UserNotFoundException("id - " + id);
    }

    public User deleteById(Integer id) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId().equals(id)) {
                iterator.remove();
                return user;
            }
        }
        throw new UserNotFoundException("id - " + id);
    }

    /*public List<Post> findAllPosts(Integer userId) {
        List<Post> resultPosts = new ArrayList<>();
        for (Post post : posts) {
            if (post.getUserId().equals(userId)) {
                resultPosts.add(post);
            }
        }
        if (posts.size() == 0) {
            throw new NoOnePostFoundException("no posts for this user");
        }
        return posts;
    }*/

    public Post savePost(Post post) {
        if (post.getId() == null) {
            post.setId(++postCount);
        }
        posts.add(post);
        return post;
    }

    public Post findOnePost(Integer id) {
        for (Post post : posts) {
            if (post.getId().equals(id)) {
                return post;
            }
        }
        throw new PostNotFoundException("id - " + id);
    }
}
