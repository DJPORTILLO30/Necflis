package com.daniloportillo.Necflis.controllers;



import com.daniloportillo.Necflis.entities.Category;
import com.daniloportillo.Necflis.entities.Content;
import com.daniloportillo.Necflis.repositories.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.util.Collection;
import java.util.Date;
import java.util.Optional;


@RestController
@RequestMapping(value = "/contenidos")
public class ContentController {

    @Autowired
    ContentRepository contentRepository;


    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public Collection<Content> getAllContents(){
        Iterable<Content> contents = contentRepository.findAll();
        return (Collection<Content>) contents;
    }



    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Content createContent(@RequestBody Content content , @DateTimeFormat(pattern = "yyyy.MM.ddd") Date date){
        Content newContent  = contentRepository.save(content);
        return newContent;
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Content getContent(@PathVariable(name = "id") Long id){
        Optional<Content> category = contentRepository.findById(id);
        Content result = null;
        if(category.isPresent()){
            result = category.get();
        }
        return result;
    }



    @DeleteMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void deleteContent(@PathVariable(name = "id") Long id){

        contentRepository.deleteById(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Content changeContent(@PathVariable(name = "id") Long id , @RequestBody Content content){
        Optional<Content> data = contentRepository.findById(id);
        if(data.isPresent()){
            Content actual = data.get();
            actual.setId(id);
            actual.setName(content.getName());
            actual.setSummary(content.getSummary());
            actual.setDateCreated(content.getDateCreated());
            actual.setIdCategory(content.getIdCategory());
            actual.setIdGenre(content.getIdGenre());
            Content changedContent = contentRepository.save(actual);
            return changedContent;
        }
        return null;
    }

}
