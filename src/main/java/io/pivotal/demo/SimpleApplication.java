package io.pivotal.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.util.Arrays;
import java.util.Collection;

@SpringBootApplication
public class SimpleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleApplication.class, args);
	}
}

@RestController
class HelloController {

	@GetMapping("/hello")
	public String hello(){
		return "Hello World";
	}

	@GetMapping("/content")
	public Collection<ContentItem> content()
	{
		return Arrays.asList(new ContentItem(1L, "foo", "bar"), new ContentItem(2L, "bap", "baz"));
	}
}

@RepositoryRestResource
interface ContentItemRepository extends CrudRepository<ContentItem,Long>{

}

@Entity
class ContentItem {

	@Id
	Long id;

	String name;
	String path;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public ContentItem(Long id, String name, String path) {

		this.name = name;
		this.path = path;
	}

	public ContentItem() {}
}