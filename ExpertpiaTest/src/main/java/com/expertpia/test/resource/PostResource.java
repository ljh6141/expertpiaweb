package com.expertpia.test.resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.expertpia.test.domain.Comment;
import com.expertpia.test.domain.Post;
import com.expertpia.test.service.PostService;


@Path("/post")
public class PostResource {
	@Autowired
	private PostService postService;
//	@Autowired
//	private PostRepository postRepository;
//	@Autowired
//	private CommentRepository commentRepository;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Path("/list")
	public Response list() {
		List<Post> postList= postService.getlist();
		return Response.ok(postList).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Path("/list/{post_id}")
	public Response getPostInfo(@PathParam("post_id") long id) {
//		Post posts=postRepository.findOne(id);
//		GenericEntity<Post> entity = new GenericEntity<Post>(posts) {};//xml스타일?	
//		List<Comment> comments=commentRepository.findByPost(posts);
//		if(comments!=null){
//			return Response.ok(comments).build();
//		}
		Post posts=postService.getPostInfo(id);
		List<Comment> comments=postService.getCommentInfo(posts);
		System.out.println("어디로가는지"+posts+"나와바"+comments);
//		if(comments!=null){
//			return Response.ok(comments).build();
//			}
		Map<Object, Object> model=new HashMap<Object, Object>();
		model.put(comments, posts);
		return Response.ok(model).build();
	}

//	@POST
//	@Consumes(MediaType.MULTIPART_FORM_DATA)
//	@Produces(MediaType.MULTIPART_FORM_DATA)
//	@Path("/upload")
//	public Response fileUpload(Post post) {
//		HttpServletRequest request = null;
//		HttpSession session = request.getSession();
//		String root_path = session.getServletContext().getRealPath("/"); // ������ root ���
//		String attach_path = "files/";
//		FileBean fileBean= new FileBean();
//		MultipartFile upload=fileBean.getUpload();
//		String filename = "";
//		if (upload != null) {
//			filename = upload.getOriginalFilename();
//			fileBean.setFilename(filename);
//			try {
//				File file = new File(root_path + attach_path + filename);
//				System.out.println(file);
//				upload.transferTo(file);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		String file_path = "/extest/" + attach_path + filename;
//		post.setPostContent(filename);
//		System.out.println("파일이름: "+filename);
//		System.out.println(post.getPostContent());
//		return Response.ok(post).build();
//	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/create")
	public Response insert(Post post) {
		postService.create(post);
		return Response.ok(post).build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/update/{post_id}")
	public Response modify(Post post, @PathParam("post_id") long id) {
		Post postInfo=postService.update(post, id);
		return Response.ok(postInfo).build();
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/delete/{post_id}")
	public Response delete(@PathParam("post_id") long id) {
		Post postInfo=postService.delete(id);
		return Response.ok(postInfo).build();
	}
	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	@Path("/search/{post_title}")
//	public Response searchTitle(@PathParam("post_title") String title) {
//		List<Post> postInfo=postService.searchTitle(title);
//		return Response.ok(postInfo).build();
//	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/search/{tc}")
	public Response searchTc(@PathParam("tc") String title, @PathParam("tc") String content) {
		List<Post> postInfo=postService.searchTc(title, content);
		return Response.ok(postInfo).build();
	}
}
