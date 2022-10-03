package com.soap.choicehotels.ChoiceHotelsSoapService.mappers.impl;

import com.soap.choicehotels.ChoiceHotelsSoapService.domain.AddressLines;
import com.soap.choicehotels.ChoiceHotelsSoapService.mappers.Mapper;
import org.choicehotel.generated.AddressLinesDto;

public class AddressLinesMapperImpl implements Mapper<AddressLinesDto, AddressLines> {

    @Override
    public AddressLines map(AddressLinesDto source) {
        if(source == null)
            return null;
        return new AddressLines(source.getExterior(), source.getStreet());
    }
}
