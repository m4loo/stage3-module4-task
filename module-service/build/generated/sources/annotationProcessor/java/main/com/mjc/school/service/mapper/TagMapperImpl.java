package com.mjc.school.service.mapper;

import com.mjc.school.repository.model.TagModel;
import com.mjc.school.service.dto.TagDtoRequest;
import com.mjc.school.service.dto.TagDtoResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-16T14:19:24+0500",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.2.jar, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class TagMapperImpl implements TagMapper {

    @Override
    public List<TagDtoResponse> modelListToDtoListResponse(List<TagModel> modelList) {
        if ( modelList == null ) {
            return null;
        }

        List<TagDtoResponse> list = new ArrayList<TagDtoResponse>( modelList.size() );
        for ( TagModel tagModel : modelList ) {
            list.add( tagToDtoResponse( tagModel ) );
        }

        return list;
    }

    @Override
    public TagModel tagFromDtoRequest(TagDtoRequest request) {
        if ( request == null ) {
            return null;
        }

        TagModel tagModel = new TagModel();

        tagModel.setId( request.getId() );
        tagModel.setName( request.getName() );

        return tagModel;
    }

    @Override
    public TagDtoResponse tagToDtoResponse(TagModel tagModel) {
        if ( tagModel == null ) {
            return null;
        }

        TagDtoResponse tagDtoResponse = new TagDtoResponse();

        tagDtoResponse.setId( tagModel.getId() );
        tagDtoResponse.setName( tagModel.getName() );

        return tagDtoResponse;
    }
}
