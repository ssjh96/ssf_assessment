package vttp.batch5.ssf.noticeboard.repositories;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import vttp.batch5.ssf.noticeboard.models.Notice;

@Repository
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

	 @Autowired
	 @Qualifier("notice")
	 private RedisTemplate<String, Object> template;

	public void insertNotices(String noticeId, Map<String, Object> respObj) {

        JsonObject json = Json.createObjectBuilder()
                .add("id", respObj.get("id").toString())
                .add("timestamp", (long) respObj.get("timestamp"))
                .build();

        // Save the JSON string into Redis
        ValueOperations<String, Object> valueOps = template.opsForValue();
        valueOps.set(noticeId, json.toString());

		// ValueOperations<String, Object> valueOps = template.opsForValue();
			// valueOps.set(orderId, json.toString());

	}




}
