package com.expertpia.web.domains;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPost is a Querydsl query type for Post
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPost extends EntityPathBase<Post> {

    private static final long serialVersionUID = 29192406L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPost post = new QPost("post");

    public final NumberPath<Long> badCount = createNumber("badCount", Long.class);

    public final NumberPath<Long> clipCount = createNumber("clipCount", Long.class);

    public final ListPath<Comment, QComment> comments = this.<Comment, QComment>createList("comments", Comment.class, QComment.class, PathInits.DIRECT2);

    public final QInterest interest;

    public final StringPath postContent = createString("postContent");

    public final DateTimePath<java.util.Date> postDate = createDateTime("postDate", java.util.Date.class);

    public final DateTimePath<java.util.Date> postDateUp = createDateTime("postDateUp", java.util.Date.class);

    public final NumberPath<Long> postId = createNumber("postId", Long.class);

    public final StringPath postTitle = createString("postTitle");

    public final NumberPath<Long> replyCount = createNumber("replyCount", Long.class);

    public final QUser user;

    public QPost(String variable) {
        this(Post.class, forVariable(variable), INITS);
    }

    public QPost(Path<? extends Post> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPost(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPost(PathMetadata metadata, PathInits inits) {
        this(Post.class, metadata, inits);
    }

    public QPost(Class<? extends Post> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.interest = inits.isInitialized("interest") ? new QInterest(forProperty("interest"), inits.get("interest")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

