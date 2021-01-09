package com.example.demo.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.beans.PublicationBean;

@FeignClient(value = "publication-service")
public interface PublicationProxy {
	
	@GetMapping("/publications/{id}")
	public EntityModel<PublicationBean> findPublicationById(@PathVariable(name = "id") Long id);
	
	@GetMapping("/publications")
	public  CollectionModel<PublicationBean> getAllPublications();


}
