package com.EmailSender.service;

import com.EmailSender.dto.MailRequest;
import com.EmailSender.dto.MailResponse;
import freemarker.template.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender sender;

	@Autowired
	private Configuration config;

	public MailResponse sendEmail(MailRequest request, Map<String, Object> model) {
		MailResponse response = new MailResponse();
		MimeMessage message = sender.createMimeMessage();
		try {
			// set mediaType
			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());
			// add attachment
			// helper.addAttachment("logo.png", new ClassPathResource("logo.png"));
			// Template t = config.getTemplate("template.html");
			// String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
			RestTemplate template = new RestTemplate();
			String url = "https://food-distribution-app.herokuapp.com/getTemplate/" + request.getTo();
			String result = template.getForObject(url, String.class);
			System.out.println(result);
			helper.setTo(request.getTo());
			helper.setText(result, true);
			helper.setSubject(request.getSubject());
			helper.setFrom(request.getFrom());
			sender.send(message);

			response.setMessage(" An Email sent to : " + request.getTo() + ". Please verify your email account.");
			response.setStatus(Boolean.TRUE);
		} catch (MessagingException e) {
			response.setMessage("Mail Sending failure : "+e.getMessage());
			response.setStatus(Boolean.FALSE);
		}
		return response;
	}
}
