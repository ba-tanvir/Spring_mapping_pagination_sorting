package com.example.carinsuranceapi3.service;

import com.example.carinsuranceapi3.Entity.BaseEntity;
import com.example.carinsuranceapi3.dto.IRequestBodyDTO;
import com.example.carinsuranceapi3.repository.BaseRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Data
@AllArgsConstructor
public abstract class BaseService<E extends BaseEntity, D extends IRequestBodyDTO> {

    private final BaseRepository<E> genericRepository;

    private ModelMapper modelMapper;

    public List<D> get_all(){
        List<E> allEntities=new ArrayList<>();
        allEntities=genericRepository.findAll();
        return allEntities.stream().map(this::getDto).collect(Collectors.toList());
    }

    public List<D> get_all_sorting(String fieldName){
        List<E> allEntities=new ArrayList<>();
        allEntities=genericRepository.findAll(Sort.by(Sort.Direction.ASC,fieldName));
        return allEntities.stream().map(this::getDto).collect(Collectors.toList());
    }

    public List<D> get_pagination(int offset, int pageSize){
       Page<E> allEntities =genericRepository.findAll(PageRequest.of(offset, pageSize));
        return allEntities.stream().map(this::getDto).collect(Collectors.toList());
    }

    public D create(E item){
        System.out.println(item);
        genericRepository.save(item);
        return modelMapper.map(item,getDtoClass());
    }

    public D update (E item){
        genericRepository.save(item);
        return modelMapper.map(item,getDtoClass());
    }
    @SuppressWarnings("unchecked")
    private Class<D> getDtoClass() {
        return (Class<D>) (((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1]);
    }
    private D getDto(E e){
        return modelMapper.map(e,getDtoClass());
    }
}
