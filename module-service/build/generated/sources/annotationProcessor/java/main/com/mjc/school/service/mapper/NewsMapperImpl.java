package com.mjc.school.service.mapper;

import com.mjc.school.repository.model.NewsModel;
import com.mjc.school.service.dto.NewsDtoRequest;
import com.mjc.school.service.dto.NewsDtoResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-16T14:19:24+0500",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.4.2.jar, environment: Java 17.0.12 (Oracle Corporation)"
)
@Component
public class NewsMapperImpl extends NewsMapper {

    @Autowired
    private TagMapper tagMapper;
    @Autowired
    private AuthorMapper authorMapper;

    @Override
    public List<NewsDtoResponse> modelListToDtoList(List<NewsModel> modelList) {
        if ( modelList == null ) {
            return null;
        }

        List<NewsDtoResponse> list = new ArrayList<NewsDtoResponse>( modelList.size() );
        for ( NewsModel newsModel : modelList ) {
            list.add( newsToDtoResponse( newsModel ) );
        }

        return list;
    }

    @Override
    public NewsModel newsFromDtoRequest(NewsDtoRequest request) {
        if ( request == null ) {
            return null;
        }

        NewsModel newsModel = new NewsModel();

        newsModel.setId( request.getId() );
        newsModel.setTitle( request.getTitle() );
        newsModel.setContent( request.getContent() );

        newsModel.setAuthor( authorRepository.getReference(request.getAuthorId()) );
        newsModel.setTags( new ArrayList<>(request.getTagsIds().stream().map(tagId -> tagRepository.getReference(tagId)).toList()) );

        return newsModel;
    }

    @Override
    public NewsDtoResponse newsToDtoResponse(NewsModel model) {
        if ( model == null ) {
            return null;
        }

        NewsDtoResponse newsDtoResponse = new NewsDtoResponse();

        newsDtoResponse.setAuthorDto( authorMapper.authorToDtoResponse( model.getAuthor() ) );
        newsDtoResponse.setTagsDto( tagMapper.modelListToDtoListResponse( model.getTags() ) );
        newsDtoResponse.setId( model.getId() );
        newsDtoResponse.setTitle( model.getTitle() );
        newsDtoResponse.setContent( model.getContent() );
        newsDtoResponse.setCreateDate( model.getCreateDate() );
        newsDtoResponse.setLastUpdateDate( model.getLastUpdateDate() );

        return newsDtoResponse;
    }
}
