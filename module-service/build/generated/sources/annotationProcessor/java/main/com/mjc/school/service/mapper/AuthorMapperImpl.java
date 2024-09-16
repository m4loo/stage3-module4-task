package com.mjc.school.service.mapper;

import com.mjc.school.repository.model.AuthorModel;
import com.mjc.school.service.dto.AuthorDtoRequest;
import com.mjc.school.service.dto.AuthorDtoResponse;
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
public class AuthorMapperImpl implements AuthorMapper {

    @Override
    public List<AuthorDtoResponse> modelListToDtoList(List<AuthorModel> modelList) {
        if ( modelList == null ) {
            return null;
        }

        List<AuthorDtoResponse> list = new ArrayList<AuthorDtoResponse>( modelList.size() );
        for ( AuthorModel authorModel : modelList ) {
            list.add( authorToDtoResponse( authorModel ) );
        }

        return list;
    }

    @Override
    public AuthorModel authorFromDtoRequest(AuthorDtoRequest request) {
        if ( request == null ) {
            return null;
        }

        AuthorModel authorModel = new AuthorModel();

        authorModel.setId( request.getId() );
        authorModel.setName( request.getName() );

        return authorModel;
    }

    @Override
    public AuthorDtoResponse authorToDtoResponse(AuthorModel model) {
        if ( model == null ) {
            return null;
        }

        AuthorDtoResponse authorDtoResponse = new AuthorDtoResponse();

        authorDtoResponse.setId( model.getId() );
        authorDtoResponse.setName( model.getName() );
        authorDtoResponse.setCreateDate( model.getCreateDate() );
        authorDtoResponse.setLastUpdateDate( model.getLastUpdateDate() );

        return authorDtoResponse;
    }
}
