package com.alejandro.info;

import com.alejandro.info.service.IWebScraping;
import com.alejandro.info.util.HTMLBuilder;
import com.alejandro.info.util.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@EnableScheduling
public class InfoApplication implements CommandLineRunner {

	@Autowired
	private HTMLBuilder builder;

	public static void main(String[] args) {
		SpringApplication.run(InfoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String body = builder.buildHTML();
		Set<String> mails = new HashSet<>();
		mails.add("vanesadaymr@gmail.com");
		mails.add("alejandro950825@gmail.com");
		MailUtil m = new MailUtil();
		m.sendMails(mails, body);
	}
}
