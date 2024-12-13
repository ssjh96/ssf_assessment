package vttp.batch5.ssf.noticeboard.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import vttp.batch5.ssf.noticeboard.models.Notice;
import vttp.batch5.ssf.noticeboard.repositories.NoticeRepository;

@Service
public class NoticeService {

	// TODO: Task 3
	// You can change the signature of this method by adding any number of parameters
	// and return any type
	
	@Value("{${publishing.server.url}}")
	private String publishingServerUrl;

	@Autowired
	private NoticeRepository noticeRepo;

	public List<String> postToNoticeServer(Notice notice) 
	{
		String url = publishingServerUrl + "/notice";
		System.out.println(url);

		List<String> respList = new ArrayList<>();
		
		JsonArrayBuilder jab = Json.createArrayBuilder();
		
		for (String c : notice.getCategories())
		{
			jab.add(c);
		}

		JsonArray jCategories = jab.build();

		JsonObject jNotice = Json.createObjectBuilder()
			.add("title", notice.getTitle())
			.add("poster", notice.getPoster())
			.add("postDate", notice.getPostDate().getTime())
			.add("categories", jCategories)
			.add("text", notice.getText())
			.build();

		RestTemplate restTemplate = new RestTemplate();

		RequestEntity<String> req = RequestEntity.post(url).contentType(MediaType.APPLICATION_JSON).body(jNotice.toString());

		try 
		{
			ResponseEntity<String> resp = restTemplate.exchange(req, String.class);

			if (resp.getStatusCode().is2xxSuccessful())
			{
				respList.add(resp.getBody().toString());
			}

		} 
		catch (Exception e) 
		{
			String error = e.getMessage();
			respList.add(error);
		}

		System.out.println(respList);
		return respList;
	}
}