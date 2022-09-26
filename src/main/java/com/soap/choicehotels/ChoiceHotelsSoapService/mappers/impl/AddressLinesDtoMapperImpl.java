package com.soap.choicehotels.ChoiceHotelsSoapService.mappers.impl;

import com.soap.choicehotels.ChoiceHotelsSoapService.domain.AddressLines;
import com.soap.choicehotels.ChoiceHotelsSoapService.mappers.Mapper;
import com.soap.choicehotels.ChoiceHotelsSoapService.model.AddressLinesDto;

public class AddressLinesDtoMapperImpl implements Mapper<AddressLines, AddressLinesDto> {

    @Override
    public AddressLinesDto map(AddressLines source) {
        if(source == null)
            return null;
        AddressLinesDto addressLinesDto = new AddressLinesDto();
        addressLinesDto.setExterior(source.getExterior());
        addressLinesDto.setStreet(source.getStreet());
        return addressLinesDto;
    }
}
