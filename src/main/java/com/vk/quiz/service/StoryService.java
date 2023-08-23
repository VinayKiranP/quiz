package com.vk.quiz.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vk.quiz.dao.StoryDao;
import com.vk.quiz.model.Story;

@Service
public class StoryService {
    @Autowired
    private StoryDao storyDao;

    public List<Story> getAllStory(){
        return storyDao.findAll();
    }

    public Optional<Story> getStoryById(String id) {
        return storyDao.findById(id);
    }
    
    public List<Story> getStoryByName(String name) {
        return storyDao.findByName(name);
    }

    public Story addStory(Story story){
       return storyDao.save(story);
    }

    public Story updateStory(Story story){
        return storyDao.save(story);
    }

    public Story deleteStory(Story story){
        story.setDeleted(true);
        return storyDao.save(story);
    }
}
