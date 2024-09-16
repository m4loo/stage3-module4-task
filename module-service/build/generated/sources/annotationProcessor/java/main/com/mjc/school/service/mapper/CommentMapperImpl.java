package com.mjc.school.service.mapper;

import com.mjc.school.repository.model.CommentModel;
import com.mjc.school.service.dto.CommentDtoRequest;
import com.mjc.school.service.dto.CommentDtoResponse;
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
public class CommentMapperImpl extends CommentMapper {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public List<CommentDtoResponse> modelListToDtoList(List<CommentModel> modelList) {
        if ( modelList == null ) {
            return null;
        }

        List<CommentDtoResponse> list = new ArrayList<CommentDtoResponse>( modelList.size() );
        for ( CommentModel commentModel : modelList ) {
            list.add( commentToDtoResponse( commentModel ) );
        }

        return list;
    }

    @Override
    public CommentModel commentFromDtoRequest(CommentDtoRequest request) {
        if ( request == null ) {
            return null;
        }

        CommentModel commentModel = new CommentModel();

        commentModel.setId( request.getId() );
        commentModel.setName( request.getName() );

        commentModel.setNews( newsRepository.getReference(request.getNewsId()) );

        return commentModel;
    }

    @Override
    public CommentDtoResponse commentToDtoResponse(CommentModel model) {
        if ( model == null ) {
            return null;
        }

        CommentDtoResponse commentDtoResponse = new CommentDtoResponse();

        commentDtoResponse.setNewsDto( newsMapper.newsToDtoResponse( model.getNews() ) );
        commentDtoResponse.setId( model.getId() );
        commentDtoResponse.setName( model.getName() );
        commentDtoResponse.setCreatedDate( model.getCreatedDate() );
        commentDtoResponse.setLastUpdatedDate( model.getLastUpdatedDate() );

        return commentDtoResponse;
    }
}
