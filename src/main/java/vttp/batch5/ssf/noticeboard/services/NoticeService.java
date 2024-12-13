package vttp.batch5.ssf.noticeboard.services;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import vttp.batch5.ssf.noticeboard.models.Notice;

public class NoticeService {

	// TODO: Task 3
	// You can change the signature of this method by adding any number of parameters
	// and return any type
	
	@Value("{${publishing.server.url}}")
	private String publishingServerUrl;

	public Map<String, Object> postToNoticeServer(Notice notice) 
	{
		// Parse in JSON payload
		// Prepare read string as JSON; payload is a plain JSON string sent from postman
		Map<String, Object> payload = new HashMap<>();

		payload.put("title", notice.getTitle());
		payload.put("poster", notice.getPoster());
		payload.put("postDate", notice.getPostDate());
		

		return null;


	}
}