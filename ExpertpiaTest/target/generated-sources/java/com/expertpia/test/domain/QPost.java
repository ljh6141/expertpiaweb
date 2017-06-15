package com.expertpia.test.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QPost is a Querydsl query type for Post
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPost extends EntityPathBase<Post> {

    private static final long serialVersionUID = 453033387L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPost post = new QPost("post");

    public final NumberPath<Long> badCount = createNumber("badCount", Long.class);

    public final QCategory category;

    public final NumberPath<Long> clipCount = createNumber("clipCount", Long.class);

    public final ListPath<Comment, QComment> comments = this.<Comment, QComment>createList("comments", Comment.class, QComment.class, PathInits.DIRECT2);

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
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QPost(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QPost(PathMetadata<?> metadata, PathInits inits) {
        this(Post.class, metadata, inits);
    }

    public QPost(Class<? extends Post> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.category = inits.isInitialized("category") ? new QCategory(forProperty("category")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

