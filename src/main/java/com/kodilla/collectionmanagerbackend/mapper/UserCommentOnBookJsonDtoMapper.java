package com.kodilla.collectionmanagerbackend.mapper;

import com.kodilla.collectionmanagerbackend.domain.UserCommentOnBook;
import com.kodilla.collectionmanagerbackend.domain.UserCommentOnBookJsonDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserCommentOnBookJsonDtoMapper {
    public List<UserCommentOnBookJsonDto> mapCommentDtoToJson (List<UserCommentOnBook> userCommentOnBookList) {
        return userCommentOnBookList.stream()
                .map(c -> new UserCommentOnBookJsonDto(c.getDate(), c.getContent()))
                .collect(Collectors.toList());
    }
}
