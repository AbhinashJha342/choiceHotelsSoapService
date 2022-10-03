package com.soap.choicehotels.ChoiceHotelsSoapService.mappers.impl;

import com.soap.choicehotels.ChoiceHotelsSoapService.domain.Address;
import com.soap.choicehotels.ChoiceHotelsSoapService.mappers.Mapper;
import org.choicehotel.generated.AddressDto;

public class AddressDtoMapperImpl implements Mapper<Address, AddressDto> {

    @Override
    public AddressDto map(Address source) {
        if(source == null)
            return null;
        AddressDto addressDto = new AddressDto();
        addressDto.setCity(source.getCity());
        addressDto.setState(source.getState());
        addressDto.setPostalCode(source.getPostalCode());
        addressDto.setAddressLines(new AddressLinesDtoMapperImpl().map(source.getAddressLines()));
        return addressDto;
    }
}
