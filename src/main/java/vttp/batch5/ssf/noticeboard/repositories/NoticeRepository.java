package vttp.batch5.ssf.noticeboard.repositories;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import vttp.batch5.ssf.noticeboard.models.Notice;

public class NoticeRepository {

	// TODO: Task 4
	// You can change the signature of this method by adding any number of parameters
	// and return any type
	// 
	/*
	 * Write the redis-cli command that you use in this method in the comment. 
	 * For example if this method deletes a field from a hash, then write the following
	 * redis-cli command 
	 * 	hdel myhashmap a_key
	 *
	 *
	 */

	//  @Autowired
	//  @Qualifier("notice")
	//  private RedisTemplate<String, Object> template;

	// public void insertNotices(String noticeId, Notice notice) {

	// 	JsonObject json = notice.toJson();

	// 	ValueOperations<String, Object> valueOps = template.opsForValue();
	// 	valueOps.set(noticeId, json.toString());	
	// }

	// private String serialiseNotice(Notice notice)
	// {

	// 	// SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	// 	// long epochPostDate = notice.getPostDate().getTime();

	// 	// return Json.createObjectBuilder()
    //     //         .add("title", notice.getTitle())
    //     //         .add("poster", notice.getPoster())
    //     //         .add("postDate", epochPostDate)
    //     //         .add("categories", notice.getCategories())
    //     //         .add("text", notice.getText())
    //     //         .build().toString();
	// }




}
