package com.hust.converter;

import com.hust.entity.ActivityEntity;
import com.hust.model.ActivityOutputModel;

public class ActivityConverter {
    public static ActivityOutputModel toOutPutModel(ActivityEntity act){
        return new ActivityOutputModel(act.getId(), act.getCreatedBy(), act.getCreatedDate(),
                act.getModifiedBy(), act.getModifiedDate(), act.getTitle(), act.getContent(),
                act.getLocation(), act.getCommune(), act.getTopic(), act.getUser(), act.getFromDate(),
                act.getToDate(), act.getImage(), act.getAttendees().size());
    }
}
