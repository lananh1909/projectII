package com.hust.converter;

import com.hust.entity.BlogEntity;
import com.hust.entity.ListImage;
import com.hust.model.BlogOutPutModel;

import java.util.ArrayList;
import java.util.List;

public class BlogConverter {
    public static BlogOutPutModel toOutputModel(BlogEntity blog, List<Long> images){
        BlogOutPutModel out = new BlogOutPutModel(blog.getId(), blog.getCreatedBy(), blog.getCreatedDate(), blog.getModifiedBy(), blog.getModifiedDate(),
                blog.getTitle(), blog.getContent(), images, blog.getUser());
        return out;
    }
}
